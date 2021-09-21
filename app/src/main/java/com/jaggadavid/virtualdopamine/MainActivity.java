package com.jaggadavid.virtualdopamine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity{
    View startview, taskDisplay, taskAddView;
    Editable editText;
    LinearLayout list;
    ImageButton addTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        System.out.println("Test "+editText);
        setContentView(R.layout.tasskdisplay);
        list = findViewById(R.id.todolist);
        CheckBox newCheckbox = new CheckBox(this);
        //newCheckbox.setId(R.id.basicCheckbox);
        newCheckbox.setText(editText);
        list.addView(newCheckbox);
        //setContentView(R.layout.tasskdisplay);

    }
    public void goHome(View view){
        setContentView(R.layout.tasskdisplay);
    }
}