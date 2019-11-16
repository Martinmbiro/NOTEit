package com.vickikbt.notekeeper.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Entity.class, version = 1)
public abstract class NoteDatabase  extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract DAO dao();

    public static synchronized NoteDatabase getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    NoteDatabase.class, "NoteKeeper")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{

        private DAO dao;
        private PopulateDbAsyncTask(NoteDatabase db){
            dao=db.dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

}
