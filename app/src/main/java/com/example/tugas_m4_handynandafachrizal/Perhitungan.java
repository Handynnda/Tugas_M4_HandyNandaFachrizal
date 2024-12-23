package com.example.tugas_m4_handynandafachrizal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Perhitungan extends AppCompatActivity {

    private ImageView backbutton;
    private EditText inpNama, inputNim, inpTxtNilai;
    private TextView viewNama, viewNim, viewNilai, viewKeterangan;
    private Button hitungButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perhitungan);

        // Inisialisasi elemen
        backbutton = findViewById(R.id.back);
        inpNama = findViewById(R.id.InpNama);
        inputNim = findViewById(R.id.InputNim);
        inpTxtNilai = findViewById(R.id.InpTxtNilai);
        viewNama = findViewById(R.id.ViewNama);
        viewNim = findViewById(R.id.ViewNim);
        viewNilai = findViewById(R.id.ViewNilai);
        viewKeterangan = findViewById(R.id.viewKeterangan);
        hitungButton = findViewById(R.id.Hitung);

        //set listener untuk tombol kembali
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Perhitungan.this,
                        Login.class);
                startActivity(intent);
            }
        });

        // Set listener untuk tombol "HITUNG"
        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hitung();
            }
        });
    }

    private void Hitung() {
        String nama = inpNama.getText().toString().trim();
        String nim = inputNim.getText().toString().trim();
        String nilaiStr = inpTxtNilai.getText().toString().trim();

        // Validasi input
        if (nama.isEmpty() || nim.isEmpty() || nilaiStr.isEmpty()) {
            Toast.makeText(this, "Mohon lengkapi semua data!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double nilai = Double.parseDouble(nilaiStr);
            String keterangan;

            // Menentukan keterangan berdasarkan nilai
            if (nilai >= 80) {
                keterangan = "Lulus Nilai A";
            } else if (nilai >= 61) {
                keterangan = "Lulus Nilai B";
            } else if (nilai >= 51) {
                keterangan = "Lulus Nilai C";
            } else {
                keterangan = "Tidak Lulus";
            }

            // Menampilkan hasil pada TextView
            viewNama.setText("Nama: " + nama);
            viewNim.setText("NIM: " + nim);
            viewNilai.setText("Nilai: " + nilai);
            viewKeterangan.setText("Keterangan: " + keterangan);

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Nilai harus berupa angka!", Toast.LENGTH_SHORT).show();
        }
    }
}
