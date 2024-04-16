package com.pam.tokpedd;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BarangItemClickListener {
    private RecyclerView rvItems;
    private Button btnAdd;
    private ArrayList<BarangModel> barangList = new ArrayList<BarangModel>();
    private static final int REQUEST_ADD_ITEM = 1;
    private BarangAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvItems = findViewById(R.id.rvItems);
        setData();

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        adapter = new BarangAdapter(this, barangList, this);
        RecyclerView.LayoutManager lm = new GridLayoutManager(this, 2);
        rvItems.setLayoutManager(lm);
        rvItems.setAdapter(adapter);
    }

    void setData() {
        barangList.add(new BarangModel("Buku", "20000", R.drawable.buku));
        barangList.add(new BarangModel("Pulpen", "40000",  R.drawable.pulpen));
        barangList.add(new BarangModel("Kaos", "50000",  R.drawable.buku));
        barangList.add(new BarangModel("Buku", "20000",  R.drawable.pulpen));
        barangList.add(new BarangModel("Buku", "20000", R.drawable.buku));
        barangList.add(new BarangModel("Pulpen", "40000",  R.drawable.pulpen));
        barangList.add(new BarangModel("Kaos", "50000",  R.drawable.buku));
        barangList.add(new BarangModel("Buku", "20000",  R.drawable.pulpen));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd) {
            Intent i = new Intent(this, AddActivity.class);
            startActivityForResult(i, REQUEST_ADD_ITEM);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ADD_ITEM && resultCode == RESULT_OK && data != null) {
            String barang = data.getStringExtra("barang");
            String harga = data.getStringExtra("harga");
            tambahData(barang, harga);
        }
    }

    void tambahData(String nama, String harga) {
        barangList.add(new BarangModel(nama, harga, R.drawable.buku));
        adapter.notifyItemInserted(barangList.size() - 1);
    }

    @Override
    public void onItemDelete(int position) {
        barangList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
