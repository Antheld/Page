package com.example.page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button ButtonSendMsg;
    EditText EditTextWriteMsg;
    RecyclerView RecyclerViewMsg;

    ArrayList <String> msgs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonSendMsg = findViewById(R.id.button_message_send);
        EditTextWriteMsg = findViewById(R.id.edit_text_message_write);
        RecyclerViewMsg = findViewById(R.id.recycler_view);

        RecyclerViewMsg.setLayoutManager(new LinearLayoutManager(this));

        DataAdapter dataAdapter = new DataAdapter(this, msgs);
        RecyclerViewMsg.setAdapter(dataAdapter);

        ButtonSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = EditTextWriteMsg.getText().toString();
                msgs.add(message);
               // dataAdapter.notifyDataSetChanged();
                EditTextWriteMsg.setText("");
            }
        });
    }
}