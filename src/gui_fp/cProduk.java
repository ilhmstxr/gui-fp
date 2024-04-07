/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_fp;

import java.time.LocalDateTime;

/**
 *
 * @author Ilhamstxr
 */
public class cProduk {
    // data

    private String nama, kode;
    private int harga, stok, index;
    private static int produkKe = 0;

    LocalDateTime date = LocalDateTime.now();
    int tanggal = date.getDayOfMonth();
    int bulan = date.getMonthValue();
    int tahun = date.getYear();
    int jam = date.getHour();
    int menit = date.getMinute();

    // method
    cProduk() {
        System.out.println("Constructor Produk Dibuat...");
    }

    cProduk(int idx, String n, int h, int s) {
        produkKe++;
        String urutanProduk = String.format("%03d", produkKe);
        String strBulan = String.format("%02d", bulan);

        kode = tanggal + "" + strBulan + "" + urutanProduk;
        index = idx;
        nama = n;
        harga = h;
        stok = s;
        System.out.println("Object " + nama + " Dibuat");
    }

    public void setHarga(int h) {
        harga = h;
    }

    public void setStok(int s) {
        stok = s;
    }

    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public String getKode(){
        return kode;
    }
    
    public int getStok() {
        return stok;
    }

    public String ToString() {
        return nama + " harga:" + harga + " stok:" + stok;
    }
}
