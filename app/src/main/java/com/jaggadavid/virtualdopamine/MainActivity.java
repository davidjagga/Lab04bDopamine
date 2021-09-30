package com.jaggadavid.virtualdopamine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity{
    View startview, taskDisplay, taskAddView;
    Editable editText;
    LinearLayout list;
    ImageButton addTask;
    SharedPreferences sh;
    Set<Integer> setOfIDs;
    String TAG = "com.jaggadavid.lab03.shared";
    SharedPreferences.Editor edit;
    Set<String> set= new HashSet<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sh = getSharedPreferences(TAG, MODE_PRIVATE);
        edit = sh.edit();
        set= new HashSet<String>();
        setOfIDs = new HashSet<>();
        sh.getStringSet("list", set);
        setContentView(R.layout.activity_main);
        startview = findViewById(R.id.startPage);
        taskDisplay = findViewById(R.id.taskView);
        taskAddView = findViewById(R.id.taskAdd);
        //editText = findViewById(R.id.editText);
        list = findViewById(R.id.todolist);
        startview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.tasskdisplay);
            }
        });
        addTask = findViewById(R.id.addbutton);

    }

    public void addTask(View view){
        setContentView(R.layout.taskadd);
    }
    public void putTask(View view){
        EditText edittext;
        edittext= (EditText) findViewById(R.id.editText);
        editText = edittext.getEditableText();
        System.out.println(editText.toString());
        System.out.println(set.toString());
        set.add(editText.toString());
        edit.putStringSet("list", set).apply();
        System.out.println("Test "+editText);
        setContentView(R.layout.tasskdisplay);
        list = findViewById(R.id.todolist);

        for (String s: set){
            CheckBox newCheckbox = new CheckBox(this);
            //newCheckbox.setId(R.id.basicCheckbox);
            newCheckbox.setText(s);
            newCheckbox.setOnClickListener(this::onCheckboxClicked);
            Random rand = new Random();
            int x  = rand.nextInt((1000 - 100) + 1) + 100;
            while (setOfIDs.contains(x)){
                x  = rand.nextInt((1000 - 100) + 1) + 100;
            }
            newCheckbox.setId(x);
            setOfIDs.add(x);
            newCheckbox.setMaxWidth(10000);
            list.addView(newCheckbox);
        }

        //setContentView(R.layout.tasskdisplay);

    }
    public void goHome(View view){
        setContentView(R.layout.tasskdisplay);
    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?

        list = findViewById(R.id.todolist);
        list.removeView(findViewById(view.getId()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        sh.getStringSet("list", Collections.emptySet());
    }


}