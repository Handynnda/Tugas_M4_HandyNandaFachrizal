package com.example.tugas_m4_handynandafachrizal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    // Deklarasi EditText dan Button
    private EditText etEmail, etUsername, etPassword;
    private Button btnRegister;
    private ImageView backbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etEmail = findViewById(R.id.Email);
        etUsername = findViewById(R.id.Username);
        etPassword = findViewById(R.id.Password);
        btnRegister = findViewById(R.id.button2);
        backbutton = findViewById(R.id.back);

        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this,
                        Dashboard.class);
                startActivity(intent);
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (email.isEmpty() || username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(Register.this, "Semua field harus diisi",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Register.this, "Registrasi berhasil!",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,
                            Login.class);
                    startActivity(intent);
                }
            }
        });
    }
}
