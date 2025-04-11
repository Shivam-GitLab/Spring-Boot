package com.spring.journal.service;

import com.spring.journal.entity.JournalEntryV1;
import com.spring.journal.repository.EntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public void saveEntry(JournalEntryV1 journalEntry){
        entryRepository.save(journalEntry);
    }

    public List<JournalEntryV1> getAll(){
        return entryRepository.findAll();
    }

    public Optional<JournalEntryV1> findById(ObjectId id){
        return entryRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        entryRepository.deleteById(id);
    }
}

// controller ---> service --->  repository

