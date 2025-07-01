package com.example.dashboard;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.DeliveryViewHolder> {

    List<DeliveryRequest> deliveryList;

    public DeliveryAdapter(List<DeliveryRequest> deliveryList) {
        this.deliveryList = deliveryList;
    }

    @NonNull
    @Override
    public DeliveryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_request_item, parent, false);
        return new DeliveryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryViewHolder holder, int position) {
        DeliveryRequest request = deliveryList.get(position);
        holder.studentNameText.setText("Student: " + request.getStudentName());
        holder.bookNameText.setText("Book: " + request.getBookName());
        holder.statusText.setText("Status: " + request.getStatus());

        holder.trackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TrackDeliveryActivity.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return deliveryList.size();
    }

    public static class DeliveryViewHolder extends RecyclerView.ViewHolder {
        TextView studentNameText, bookNameText, statusText;
        Button trackButton;

        public DeliveryViewHolder(@NonNull View itemView) {
            super(itemView);
            studentNameText = itemView.findViewById(R.id.studentNameText);
            bookNameText = itemView.findViewById(R.id.bookNameText);
            statusText = itemView.findViewById(R.id.statusText);
            trackButton = itemView.findViewById(R.id.btn_track);
        }
    }
}
