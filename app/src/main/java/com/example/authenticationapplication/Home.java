package com.example.authenticationapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView welcome;
    TextView known_email;

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        welcome = (TextView) findViewById(R.id.TextViewWelcome);
        known_email = (TextView) findViewById(R.id.TextViewKnownEmail);

        Button logout = findViewById(R.id.ButtonLogout);

        logout.setOnClickListener(v -> {
            switchActivity();
        });

    }

    private void switchActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}