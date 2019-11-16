package com.vickikbt.notekeeper.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vickikbt.notekeeper.R;
import com.vickikbt.notekeeper.Room.Entity;

import java.util.ArrayList;
import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Entity> notes=new ArrayList<>();

    private OnItemClickListener listener;

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

        return new NoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Entity currentNote= notes.get(position);
        holder.textViewTitle.setText(currentNote.getTitle());
        holder.textViewDescriiption.setText(currentNote.getDescription());
        holder.textViewPriority.setText(String.valueOf( currentNote.getPriority() ));

    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setNotes(List<Entity> notes){
        this.notes=notes;
        notifyDataSetChanged();
    }

    public Entity getNoteAt(int position){
        return notes.get(position);
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        private TextView textViewTitle, textViewDescriiption, textViewPriority;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle=itemView.findViewById(R.id.recyclerView_title);
            textViewDescriiption=itemView.findViewById(R.id.recyclerView_description);
            textViewPriority=itemView.findViewById(R.id.recyclerView_priority);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position =getAdapterPosition();
                    if (listener!=null && position!=RecyclerView.NO_POSITION) {
                        listener.onItemClick(notes.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Entity note);

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }

}
