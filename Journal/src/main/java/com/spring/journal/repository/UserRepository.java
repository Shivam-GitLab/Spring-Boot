package com.spring.journal.repository;

import com.spring.journal.entity.JournalEntry;
import com.spring.journal.entity.User;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(@NonNull String userName);
}
