package com.vickikbt.notekeeper.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.vickikbt.notekeeper.Repository.Repository;
import com.vickikbt.notekeeper.Room.Entity;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Entity>> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        allNotes=repository.getAllNotes();
    }

    public void insert(Entity note){
        repository.insert(note);
    }

    public void update(Entity note){
        repository.update(note);
    }

    public void delete(Entity note){
        repository.delete(note);
    }

    public void deleteAllNotes(){
        repository.deleteAllNotes();
    }

    public LiveData<List<Entity>> getAllNotes(){
        return allNotes;
    }

}
