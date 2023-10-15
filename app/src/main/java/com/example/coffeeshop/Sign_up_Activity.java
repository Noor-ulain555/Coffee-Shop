package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.example.coffeeshop.databinding.ActivitySignUpBinding;

public class Sign_up_Activity extends AppCompatActivity {
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.already.setOnClickListener(v -> {
            Intent c = new Intent(Sign_up_Activity.this, sign_in_Activity.class);
            startActivity(c);
        });

        binding.facebook.setOnClickListener(v -> {
            String url = "https://www.facebook.com"; // Add "https://" prefix
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        binding.google.setOnClickListener(v -> {
            String url = "http://www.google.com"; // Add "https://" prefix
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        binding.signUps.setOnClickListener(v -> {
            Intent b = new Intent(Sign_up_Activity.this, recyclerView.class);
            startActivity(b);
        });
    }
}
