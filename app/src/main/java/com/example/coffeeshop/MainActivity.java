package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.coffeeshop.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "The login has been done", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MainActivity.this, sign_in_Activity.class);
                startActivity(i);
            }
        });

        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Sign up", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, Sign_up_Activity.class);
                startActivity(i);
            }
        });

    binding.skipped.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "Going to place Order Direct", Toast.LENGTH_LONG).show();
            Intent i = new Intent(MainActivity.this, recyclerView.class);
            startActivity(i);

        }
    });

    }
}
