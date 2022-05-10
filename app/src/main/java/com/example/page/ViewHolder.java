package com.example.page;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder extends RecyclerView.ViewHolder {

    TextView msg;

    //added
    TextView name;
    TextView time;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        msg = itemView.findViewById(R.id.text_view_message);

        //added
        name = itemView.findViewById(R.id.textView_name);
        time = itemView.findViewById(R.id.textView_time);
    }
}
