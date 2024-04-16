package com.pam.tokpedd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTambah;
    EditText etHarga, etBarang;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_listing);

        btnTambah = findViewById(R.id.btnTambah);
        etBarang = findViewById(R.id.etBarang);
        etHarga = findViewById(R.id.etHarga);

        btnTambah.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!etBarang.getText().toString().isEmpty() && !etHarga.getText().toString().isEmpty()) {
            String barang = etBarang.getText().toString();
            String harga = etHarga.getText().toString();
            etBarang.setText("");
            etHarga.setText("");

            Intent intent = new Intent();
            intent.putExtra("barang", barang);
            intent.putExtra("harga", harga);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
