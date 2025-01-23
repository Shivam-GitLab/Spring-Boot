package com.spring.journal.service;

import com.spring.journal.entity.JournalEntry;
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

    public void saveEntry(JournalEntry journalEntry){
        entryRepository.save(journalEntry);
    }

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

