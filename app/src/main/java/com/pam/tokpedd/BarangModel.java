package com.pam.tokpedd;

public class BarangModel {
    String barang, harga;
    int image;
    public BarangModel(String barang, String harga, int image){
        this.barang = barang;
        this.harga = harga;
        this.image = image;
    }

    public String getBarang() {
        return barang;
    }

    public String getHarga() {
        return harga;
    }

    public int getImage() {return image;}
}
