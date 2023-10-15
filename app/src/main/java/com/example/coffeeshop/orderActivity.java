package com.example.coffeeshop;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeeshop.databinding.ActivityOrderBinding; // Import your generated View Binding class

import java.util.ArrayList;

import Adapters.orderAdapter;
import Models.Ordermodel;
import data.DbHandler;

public class orderActivity extends AppCompatActivity {
    private ActivityOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityOrderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView orderrecyclerView = binding.orderRecyclerView;

        DbHandler handler = new DbHandler(this);
        ArrayList<Ordermodel> list = handler.getOrders();

        orderAdapter adapter = new orderAdapter(list, this);
        orderrecyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        orderrecyclerView.setLayoutManager(linearLayout);
    }
}
