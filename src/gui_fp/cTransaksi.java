/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_fp;

import java.util.Scanner;
import javax.swing.DefaultListModel;

/**
 *
 * @author Ilhamstxr
 */
public class cTransaksi {

    static Scanner s = new Scanner(System.in);
    private cPembeli pbl;
    private cProduk produk[];
    private int jumlahProduk[], subtotalProduk[];
//    private int totproduk[];
    private int idxPrd, maksPrd;
    private int jumlah, total;
    int jwb;

//    private int jumlah, total;
//    private String kode, tgl;
    cTransaksi() {
        maksPrd = 20;
        produk = new cProduk[maksPrd];
        jumlahProduk = new int[maksPrd];
        subtotalProduk = new int[maksPrd];
        idxPrd = 0;
        System.out.println("constructor transaksi berhasil dibuat");
    }

    // cara 1
    public void setPembeli(String n, String a) {
        pbl = new cPembeli(n, a);
    }

    // cara 2
    public void setPembeli(cPembeli pb) {
        pbl = new cPembeli();
        pbl = pb;
    }

    public void setProduk(cProduk p) {
        produk[idxPrd] = new cProduk();
        produk[idxPrd] = p;
    }

//    public void setTotal(int t) {
//        total = t;
//    }
//
//    public void setJumlah(int j) {
//        jumlah = j;
//    }
    public cPembeli getPembeli() {
        return pbl;
    }

    public cProduk[] getProduk() {
        return produk;
    }

    public int getTotal(int idx) {
        total = subtotalProduk[idx];
        return total;
    }
//

    public int getJumlah(int idx) {
        jumlah = jumlahProduk[idx];
        return jumlah;
    }

//    public int getIdxproduk() {
//        return idxPrd;
//    }
    // keranjang
    public void tambahProduk(cProduk p, int j) {
        if (idxPrd < maksPrd) {
            produk[idxPrd] = p;
            jumlahProduk[idxPrd] = j;
            subtotalProduk[idxPrd] = j * p.getHarga();
            idxPrd++;
            System.out.println("tambah berhasil");
        } else {
            System.out.println("Keranjang Penuh");
        }
    }

    public cProduk[] getObjekProduk() {
        return produk;
    }

    public cProduk[] reset() {
        cTransaksi tr = new cTransaksi();
        produk = new cProduk[maksPrd];
        jumlahProduk = new int[maksPrd];
        subtotalProduk = new int[maksPrd];
        idxPrd = 0;
        System.out.println("reset");
        return produk;
    }

    public void hapusProduk(String k) {

        boolean ketemu = false;
        System.out.println(k);
        for (int i = 0; i < idxPrd; i++) {
            if (k.equalsIgnoreCase(produk[i].getKode())) {
                ketemu = true;
                produk[i] = null;
                for (int j = 0; j < idxPrd; j++) {
                    if (j == idxPrd - 1) {
                        produk[j] = null;
                    } else {
                        produk[j] = produk[j + 1];
                    }
                }
                idxPrd--;
                System.out.println("Hapus Sukses");
            }
        }
    }

    public int konfirmasi() {
        System.out.println("Yakin Ubah?");
        System.out.println("1. Ya");
        System.out.println("2. Tidak");
        System.out.print("pilih = ");
        int jawab = s.nextInt();
        return jawab;
    }
}
