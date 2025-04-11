package com.spring.journal.repository;


import com.spring.journal.entity.JournalEntryV1;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

//String --> ObjectId
public interface EntryRepository extends MongoRepository<JournalEntryV1, ObjectId> {

}
