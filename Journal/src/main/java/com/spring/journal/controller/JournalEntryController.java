package com.spring.journal.controller;

import com.spring.journal.entity.JournalEntry;
import com.spring.journal.service.JournalEntryService;
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
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;


    @GetMapping("/getEntry")
    public ResponseEntity<?> getAll() {
        List<JournalEntry> allEntry = journalEntryService.getAll();
        if (allEntry != null && !allEntry.isEmpty()) {
            return new ResponseEntity<>(allEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /*
    @GetMapping("/getEntry")
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }
     */

    @PostMapping("/postEntry")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {

        try {
//            myEntry.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /*
    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }
   */

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId myId,
                                             @RequestBody JournalEntry newEntry) {
        JournalEntry oldEntry = journalEntryService.findById(myId).orElse(null);
        if (oldEntry != null) {
            oldEntry.setTitle(
                    !newEntry.getTitle().isEmpty() ?
                            newEntry.getTitle() : oldEntry.getTitle());
            /*2. Way ^ 1 Way
            newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ?
                            newEntry.getTitle() : oldEntry.getTitle());
             */
            oldEntry.setContent(
                    newEntry.getContent() != null && !newEntry.getContent().isEmpty() ?
                            newEntry.getContent() : oldEntry.getContent());
            journalEntryService.saveEntry(oldEntry);
            return new ResponseEntity<>(oldEntry, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    /*
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
     */

}
