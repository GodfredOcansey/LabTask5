package com.ocanseygodfred.labtask5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

DatabaseManager databaseManager= new DatabaseManager(this);
TextView textView;
Button button;
EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        textView=(TextView)findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setVisibility(View.INVISIBLE);

        databaseManager.insert();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setVisibility(View.VISIBLE);
                md();
            }
        });



        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (editText.getText().toString() == "Teh"){
                    editText.setText("The");
                }
                else {

                }
                return false;
            }
        });



    }

    private void md() {

        Cursor cursor= databaseManager.ViewData();

        StringBuilder stringBuilder= new StringBuilder();

        while  (cursor.moveToNext()){
            stringBuilder.append("\nCorrect"+ cursor.getString(1)+
                    "\nWrong: "+ cursor.getString(2)+
                    "\n\n");
        }

        textView.setText(stringBuilder);
    }


}
