package com.spring.journal.controller;

import com.spring.journal.entity.JournalEntry;
import com.spring.journal.service.EntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class EntryControllerV2 {

    @Autowired
    private EntryService journalEntryService;


    @GetMapping("/getEntry")
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping("/postEntry")
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    /*
     @PostMapping("/postEntry")
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }
    */
//    ==========================================

    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable ObjectId myId) {
        Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
        return journalEntry.map(
                entry -> new ResponseEntity<>(entry, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        // else return

        /*
        if (journalEntry.isPresent()){
            return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        // elseReturn
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        */
    }

    /*
     @GetMapping("/id/{myId}")
    public JournalEntry getEntryById(@PathVariable ObjectId myId) {
        return entryService.findById(myId).orElse(null);
    }
    */


    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateEntryById(@PathVariable ObjectId myId,
                                        @RequestBody JournalEntry newEntry) {
        JournalEntry oldEntry = journalEntryService.findById(myId).orElse(null);
        if (oldEntry != null) {
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ?
                    newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ?
                    newEntry.getContent() : oldEntry.getContent());
        }
        journalEntryService.saveEntry(oldEntry);
        return oldEntry;
    }

}
