package com.spring.journal.entity;
import java.time.LocalDateTime;

import lombok.Data;
//import lombok.Getter;
import lombok.NonNull;
//import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "journal_entries")

@Data
//@Data -> @Setter //@Getter More

public class JournalEntry {

    @Id
//  private String id;
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;



   /*
    Project Lombok - Remove Getter & Setter
    // Getters and Setters
    public Object getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    */
}

