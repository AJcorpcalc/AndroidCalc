package com.example.myapplication.ui.notes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class NotesFragment extends Fragment {

    private RecyclerView notesRecyclerView;
    private NotesAdapter notes_Adapter;
    private List<String> notes = new ArrayList<>();

    private void save(String name) {
        SharedPreferences pref = getContext().getSharedPreferences(getString(R.string.MyPref), MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        StringBuilder sb = new StringBuilder();
        for (String s : notes) sb.append(s).append("<s>");
        if (notes.size() > 0) sb.delete(sb.length() - 3, sb.length());
        editor.putString(name, sb.toString()).apply();
    }

    private void load(String name) {
        SharedPreferences pref = getContext().getSharedPreferences(getString(R.string.MyPref), MODE_PRIVATE);
        String[] st = pref.getString(name, "").split("<s>");
        notes.addAll(Arrays.asList(st));
    }

    @Override
    public void onStop() {
        if (notes.size() > 0) save(getString(R.string.List_for_save));
        super.onStop();
    }

    private void delete(String note) {
        notes.remove(note);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_notes, container, false);
        notesRecyclerView = root.findViewById(R.id.notes_recycler_view);
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        notes_Adapter = new NotesAdapter(getActivity(), new NotesAdapter.SelectNotesListener() {
            @Override
            public void onNotesSelect(String note) {

                Toast.makeText(getActivity(), "Зажмите, чтобы удалить", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNotesLongClick(String note) {
                if (notes.contains(note)) {
                    delete(note);
                    notes_Adapter.clearItems();
                    notes_Adapter.setItems(notes);
                }
            }
        });
        notesRecyclerView.setAdapter(notes_Adapter);

        final EditText textView = (EditText) root.findViewById(R.id.TextList);
        load(getString(R.string.List_for_save));
        notes_Adapter.setItems(notes);

        View.OnClickListener btnBigSum = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.add(textView.getText().toString());
                notes_Adapter.clearItems();
                notes_Adapter.setItems(notes);
            }
        };
        TextView.OnFocusChangeListener btnText = new TextView.OnFocusChangeListener() {

            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == true) {
                    textView.setText("");
                    ((InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .showSoftInput(v, InputMethodManager.SHOW_FORCED);
                }

            }


        };
        root.findViewById(R.id.Button_Add).setOnClickListener(btnBigSum);
        textView.setOnFocusChangeListener(btnText);
        return root;
    }
}