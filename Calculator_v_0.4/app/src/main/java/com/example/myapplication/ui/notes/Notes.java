package com.example.myapplication.ui.notes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class Notes  {
    private List<String> notes=new ArrayList<>();


    private void save(String name, Context context){
        SharedPreferences pref= context.getSharedPreferences("myPref",MODE_PRIVATE);
        SharedPreferences.Editor editor=pref.edit();
        StringBuilder sb=new StringBuilder();
        for(String s:notes) sb.append(s).append("<s>");
        if(notes.size()>0) sb.delete(sb.length()-3,sb.length());
        editor.putString(name,sb.toString()).apply();
    }
    private void load(String name,Context context){

        SharedPreferences pref= context.getSharedPreferences("myPref",MODE_PRIVATE);
        String[] st=pref.getString(name,"").split("<s>");
        notes.addAll(Arrays.asList(st));

    }
    public void setNotes(String note) {
        this.notes.add(note);
    }


    public List<String> getNotes() {

        return this.notes ;

    }

    public Notes(Context context){//Activity activity){
       // InputStream str = activity.getResources().openRawResource(R.raw.list);
        notes.add("piiii");
        save("list",context);
         load("list",context);



    }
}
