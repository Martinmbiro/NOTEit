package com.vickikbt.notekeeper.Room;

import androidx.room.PrimaryKey;
import androidx.room.Room;


@androidx.room.Entity(tableName = "note_table")
public class Entity extends Room {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    private int priority;

    public Entity(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
