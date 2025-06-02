package com.spring.journal.service;

import com.spring.journal.entity.JournalEntry;
import com.spring.journal.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository entryRepository;
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){
        try {
            journalEntry.setDate(LocalDateTime.now());
            journalEntryRepository.save(journalEntry);
        } catch (Exception e) {
//            log.error("Exception " ,e);
        }
    }
    /*public void saveEntry(JournalEntry journalEntry){
        entryRepository.save(journalEntry);
    }*/

    public List<JournalEntry> getAll(){
        return entryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id){
        return entryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        entryRepository.deleteById(id);
    }
}

// controller ---> service --->  repository

