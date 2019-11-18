package com.vickikbt.notekeeper.Room;

import androidx.room.PrimaryKey;
import androidx.room.Room;


@androidx.room.Entity(tableName = "note_table")
public class Entity extends Room {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;


    public Entity(String title, String description) {
        this.title = title;
        this.description = description;
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
}
