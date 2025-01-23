package com.spring.journal.repository;


import com.spring.journal.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//String --> ObjectId
public interface EntryRepository extends MongoRepository<JournalEntry, ObjectId> {

}
