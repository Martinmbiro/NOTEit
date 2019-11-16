package com.vickikbt.notekeeper.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    void insert(Entity note);

    @Update
    void update(Entity note);

    @Delete
    void delete(Entity note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Entity>> getAllNotes();

}
