package com.example.page;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button ButtonSendMsg;
    EditText EditTextWriteMsg;
    RecyclerView RecyclerViewMsg;


    ArrayList <String> msgs = new ArrayList<>();

    //added
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm, dd.mm.yyyy");
    ArrayList <String> time = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonSendMsg = findViewById(R.id.button_message_send);
        RecyclerViewMsg = findViewById(R.id.recycler_view);
        EditTextWriteMsg = findViewById(R.id.edit_text_message_write);


        RecyclerViewMsg.setLayoutManager(new LinearLayoutManager(this));

        DataAdapter dataAdapter = new DataAdapter(this, msgs, time);
        RecyclerViewMsg.setAdapter(dataAdapter);

        //added
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        DatabaseReference myRefTime = database.getReference("time");

        //Data
        ButtonSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = EditTextWriteMsg.getText().toString();
                String time = sdf.format(Calendar.getInstance().getTime());

                //added
                myRef.push().setValue(message);
                myRefTime.push().setValue(time);


                //msgs.add(message);
                dataAdapter.notifyDataSetChanged();


                EditTextWriteMsg.setText("");



            }
        });

        //added
        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String msg = snapshot.getValue(String.class);
                msgs.add(msg);
                dataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //added
        myRefTime.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String date = sdf.format(Calendar.getInstance().getTime());
                date = snapshot.getValue(String.class);

                time.add(date);
                dataAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}