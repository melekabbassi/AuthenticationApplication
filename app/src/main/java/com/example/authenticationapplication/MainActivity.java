package com.example.authenticationapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) findViewById(R.id.EditTextEmail);
        password = (EditText) findViewById(R.id.EditTextPassword);

        login = findViewById(R.id.ButtonLogin);

        login.setOnClickListener(v -> {
            String emailText = email.getText().toString();
            String passwordText = password.getText().toString();

            if (emailText.isEmpty() || passwordText.isEmpty()) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Empty Field");
                alertDialog.setMessage("Please enter a value");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }
                );
                alertDialog.show();
            } else if(emailText.equals(getResources().getString(R.string.known_email)) && passwordText.equals(getResources().getString(R.string.known_password))) {
                switchActivity();
            } else {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Invalid Credentials");
                alertDialog.setMessage("Please enter a valid email and password");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }
                );
                alertDialog.show();
            }
        });
    }

    private void switchActivity() {
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }
}