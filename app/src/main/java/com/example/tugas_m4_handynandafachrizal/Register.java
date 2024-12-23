package com.example.tugas_m4_handynandafachrizal;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;
    private EditText editTextProdi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inisialisasi AutoCompleteTextView untuk Nama
        autoCompleteTextView = findViewById(R.id.Username);
        String[] namaList = {"Handy", "Nanda", "Fachrizal", "Uzma"};
        ArrayAdapter<String> namaAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, namaList);
        autoCompleteTextView.setAdapter(namaAdapter);

        // Inisialisasi EditText untuk Prodi
        editTextProdi = findViewById(R.id.Kelas);

        // Data untuk daftar program studi
        String[] prodiList = {"Teknik Informatika", "Sistem Informasi", "Desain Komunikasi Visual",
                "Manajemen Informatika", "Teknik Sipil"};

        // Menampilkan dialog daftar prodi saat EditText diklik
        editTextProdi.setOnClickListener(v -> showProdiDialog(prodiList));
    }

    private void showProdiDialog(String[] prodiList) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("Pilih Program Studi");
        builder.setItems(prodiList, (dialog, which) -> {
            // Set teks yang dipilih ke EditText
            editTextProdi.setText(prodiList[which]);
        });
        builder.show();
    }
}
