package com.example.coffeeshop;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.example.coffeeshop.databinding.ActivitySignInBinding;

public class sign_in_Activity extends AppCompatActivity {
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Your UI elements are now accessible through the binding object.
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

        binding.wantAccount.setOnClickListener(v -> {
            Intent b = new Intent(sign_in_Activity.this, Sign_up_Activity.class);
            startActivity(b);
        });

        binding.signIn.setOnClickListener(v -> {
            Intent intent = new Intent(sign_in_Activity.this, recyclerView.class);
            startActivity(intent);
        });
    }
}
