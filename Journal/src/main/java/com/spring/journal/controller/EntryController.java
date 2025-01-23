//package com.spring.journal.controller;
//
//import com.spring.journal.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class EntryController {
//
//    private final Map<Long,JournalEntry> journalEntries = new HashMap<>();
//    @GetMapping("/getEntry")
//    public ArrayList<JournalEntry> getAll(){
//        return new ArrayList<>(journalEntries.values());
//    }
//    @PostMapping("postEntry")
//    public boolean createEntry(@RequestBody JournalEntry myEntry){
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }
//
//    @GetMapping("/id/{myId}")
//    public JournalEntry getEntryById(@PathVariable long myId){
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}")
//    public JournalEntry deleteEntryById(@PathVariable long myId){
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("id/{myId}")
//    public JournalEntry updateEntryById(@PathVariable long myId,
//                                        @RequestBody JournalEntry myEntry){
//        return journalEntries.put(myId, myEntry);
//    }
//
//}
