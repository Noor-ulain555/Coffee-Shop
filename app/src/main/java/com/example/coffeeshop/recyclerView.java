package com.example.coffeeshop;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import Adapters.coffeeAdapter;
import Models.coffeemodel;
import com.example.coffeeshop.databinding.ActivityRecyclerViewBinding;

public class recyclerView extends AppCompatActivity {
    private ActivityRecyclerViewBinding binding;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecyclerViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        RecyclerView recyclerView = binding.recyclerView2;
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        ArrayList<coffeemodel> list = new ArrayList<>();
        list.add(new coffeemodel(R.drawable.kebab, "30", "Savor our mouthwatering burger, featuring a juicy handcrafted patty, premium toppings, and a toasted bun", "Kebab"));
        list.add(new coffeemodel(R.drawable.pizza, "100", "Savor our mouthwatering pizza, premium topping,", "pizza"));
        list.add(new coffeemodel(R.drawable.spare, "200", "Savor our Beef Steak,", "Beef Steak"));
        list.add(new coffeemodel(R.drawable.muffin, "20", "Savor our Sweet Chocolate muffins", "Choco Muffin"));

        coffeeAdapter adapter = new coffeeAdapter(list, this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.orderss) {
            startActivity(new Intent(recyclerView.this, orderActivity.class));
            Toast.makeText(this, "data inserted", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
