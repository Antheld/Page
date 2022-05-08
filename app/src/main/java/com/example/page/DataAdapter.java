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

    LayoutInflater inflater;


    public DataAdapter(Context context, ArrayList<String> msgs) {
        this.msgs = msgs;
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
        holder.msg.setText(messages);
    }

    @Override
    public int getItemCount() {
        return msgs.size();
    }
}
