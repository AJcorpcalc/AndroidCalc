package com.example.myapplication.ui.notes;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {


    private final List<String> notesList = new ArrayList<>();
    private final LayoutInflater inflater;
    private final SelectNotesListener selectNotesListener;

    NotesAdapter(Context context, SelectNotesListener selectNotesListener) {
        inflater = LayoutInflater.from(context);
        this.selectNotesListener = selectNotesListener;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_item_view, parent, false);
        return new NotesViewHolder(view,selectNotesListener);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.bind(notesList.get(position));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public void setItems(Collection<String> notes) {
        notesList.addAll(notes);
        notifyDataSetChanged();
    }

    public void clearItems() {
        notesList.clear();
        notifyDataSetChanged();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTextView;
        private final SelectNotesListener selectNotesListener;
        public NotesViewHolder(View itemView,SelectNotesListener selectNotesListener) {
            super(itemView);
            this.selectNotesListener = selectNotesListener;
            nameTextView = itemView.findViewById(R.id.notes_list_item);
        }

        public void bind(final String note) {
            nameTextView.setText(note);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectNotesListener.onNotesSelect(note);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    selectNotesListener.onNotesLongClick(note);
                    return true;
                }
            });

        }
    }
    interface SelectNotesListener {
        void onNotesSelect(String note);
        void onNotesLongClick(String note);
    }
}
