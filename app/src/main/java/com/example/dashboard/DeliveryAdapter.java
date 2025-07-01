package com.example.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.ViewHolder> {

    private List<DeliveryRequest> deliveryList;
    private Context context;

    public DeliveryAdapter(Context context, List<DeliveryRequest> deliveryList) {
        this.context = context;
        this.deliveryList = deliveryList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView studentNameText, bookNameText, statusText;
        Button btnTrack;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentNameText = itemView.findViewById(R.id.studentNameText);
            bookNameText = itemView.findViewById(R.id.bookNameText);
            statusText = itemView.findViewById(R.id.statusText);
            btnTrack = itemView.findViewById(R.id.btn_track);
        }

        public void bind(DeliveryRequest request, Context context) {
            studentNameText.setText("Student: " + request.getUserName());
            bookNameText.setText("Book: " + request.getBookTitle());
            statusText.setText("Status: " + request.getStatus());

            btnTrack.setOnClickListener(v -> {
                Intent intent = new Intent(context, TrackDeliveryActivity.class); // ✅ Updated class name
                intent.putExtra("bookTitle", request.getBookTitle());
                intent.putExtra("status", request.getStatus());
                context.startActivity(intent);
            });

        }
    }

    @NonNull
    @Override
    public DeliveryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_request_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeliveryAdapter.ViewHolder holder, int position) {
        holder.bind(deliveryList.get(position), context);
    }

    @Override
    public int getItemCount() {
        return deliveryList.size();
    }
}
