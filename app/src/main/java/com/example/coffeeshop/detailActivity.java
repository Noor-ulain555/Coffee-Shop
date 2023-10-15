package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.coffeeshop.databinding.ActivityDetailBinding;

import java.util.Objects;

import data.DbHandler;

public class detailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private DbHandler handler;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        handler = new DbHandler(this);

        if (getIntent().getIntExtra("type", 0) == 1) {
            final int image = getIntent().getIntExtra("image", 0);
          final String price = getIntent().getStringExtra("price");
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("description");

            binding.Detailimage.setImageResource(image);
           binding.price2.setText(String.valueOf(price));

            binding.ordername.setText(name);
            binding.detaildescrip.setText(description);

            binding.InsertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isInserted = handler.InsertOrder(
                            binding.namebox.getText().toString(),
                            binding.phonebox.getText().toString(),
                            image,
                            Integer.parseInt(price),
                            description,
                            name,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(detailActivity.this, "Data inserted successfully", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(detailActivity.this, "Error inserting data", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            int id = getIntent().getIntExtra("id", 0);
            Cursor cursor = handler.getOrderById(id);

            if (cursor != null && cursor.moveToFirst()) {
                int image = cursor.getInt(3);
                binding.Detailimage.setImageResource(image);
                String price = cursor.getString(4);
                binding.price2.setText(String.valueOf(price));

                binding.ordername.setText(cursor.getString(6));
                binding.detaildescrip.setText(cursor.getString(5));
                binding.namebox.setText(cursor.getString(1));
                binding.phonebox.setText(cursor.getString(2));
                binding.quantity.setText(String.valueOf(cursor.getInt(7)));
                binding.InsertBtn.setText("Update Now");

                binding.InsertBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdated = handler.UpdateOrder(
                                binding.namebox.getText().toString(),
                                binding.phonebox.getText().toString(),
                                image,
                                price,
                                binding.detaildescrip.getText().toString(),
                                binding.ordername.getText().toString(),
                                Integer.parseInt(binding.quantity.getText().toString()),
                                id
                        );

                        if (isUpdated) {
                            Toast.makeText(detailActivity.this, "Details updated", Toast.LENGTH_LONG).show();
                            finish();
                        } else {
                            Toast.makeText(detailActivity.this, "Update failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        }
    }
}
