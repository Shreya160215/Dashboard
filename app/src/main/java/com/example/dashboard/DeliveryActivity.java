package com.example.dashboard;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DeliveryActivity extends AppCompatActivity {

    RecyclerView deliveryRecyclerView;
    List<DeliveryRequest> deliveryList;
    DeliveryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        deliveryRecyclerView = findViewById(R.id.deliveryRecyclerView);
        deliveryRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        deliveryList = new ArrayList<>();
        deliveryList.add(new DeliveryRequest("Aarav Singh", "Java Programming", "Pending"));
        deliveryList.add(new DeliveryRequest("Priya Mehta", "Data Structures", "Delivered"));
        deliveryList.add(new DeliveryRequest("Rohan Das", "Python Basics", "In Transit"));

        adapter = new DeliveryAdapter(deliveryList);
        deliveryRecyclerView.setAdapter(adapter);
    }
}
