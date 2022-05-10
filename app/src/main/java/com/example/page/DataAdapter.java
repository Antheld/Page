package com.example.page;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<ViewHolder>{

    ArrayList <String> msgs;
    //added
    ArrayList <String> date;

    LayoutInflater inflater;


    public DataAdapter(Context context, ArrayList<String> msgs, /*added*/ ArrayList<String> date) {
        this.msgs = msgs;
        //added
        this.date = date;


        this.inflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_message, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String messages = msgs.get(position);
        //added String time = date.get(position);
        //String time = time.get;


        holder.msg.setText(messages);
        //added
        holder.time.setText("clap clap stomp");

    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }
}
