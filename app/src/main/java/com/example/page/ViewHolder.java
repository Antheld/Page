package com.example.page;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ViewHolder extends RecyclerView.ViewHolder {

    TextView msg;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        msg = itemView.findViewById(R.id.text_view_message);

    }
}
