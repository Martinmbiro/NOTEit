package com.vickikbt.notekeeper.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.vickikbt.notekeeper.Room.DAO;
import com.vickikbt.notekeeper.Room.Entity;
import com.vickikbt.notekeeper.Room.NoteDatabase;

import java.util.List;

public class Repository {

    private DAO dao;
    private LiveData<List<Entity>> allNotes;

    public Repository(Application application){
        NoteDatabase database=NoteDatabase.getInstance(application);
        dao=database.dao();
        allNotes=dao.getAllNotes();
    }

    public void insert(Entity note){
        new InsertNoteAsyncTask(dao).execute(note);
    }
    public void update(Entity note){
        new UpdateNoteAsyncTask(dao).execute(note);
    }
    public void delete(Entity note){
        new DeleteNoteAsyncTask(dao).execute(note);
    }
    public void deleteAllNotes(){
        new DeleteAllNotesAsyncTask(dao).execute();
    }
    public LiveData<List<Entity>> getAllNotes(){
        return allNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Entity, Void, Void>{
        private DAO dao;

        private InsertNoteAsyncTask(DAO dao){
            this.dao=dao;
        }
        @Override
        protected Void doInBackground(Entity... notes) {
            dao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Entity, Void, Void>{
        private DAO dao;

        private UpdateNoteAsyncTask(DAO dao){
            this.dao=dao;
        }
        @Override
        protected Void doInBackground(Entity... notes) {
            dao.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Entity, Void, Void>{
        private DAO dao;

        private DeleteNoteAsyncTask(DAO dao){
            this.dao=dao;
        }
        @Override
        protected Void doInBackground(Entity... notes) {
            dao.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void>{
        private DAO dao;

        private DeleteAllNotesAsyncTask(DAO dao){
            this.dao=dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllNotes();
            return null;
        }
    }



}
