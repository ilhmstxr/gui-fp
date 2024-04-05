/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_fp;

import java.util.Scanner;

/**
 *
 * @author Ilhamstxr
 */
public class cTransaksi {
    
    static Scanner s = new Scanner(System.in);
    private cPembeli pbl;
    private cProduk prd[];
    private int jumprd[];
    private int totprd[];
    private int idxPrd, maksprd;
    int jwb;

    private int jumlah, total;
    private String kode, tgl;

    cTransaksi() {
        prd = new cProduk[10];
        jumprd = new int[5];
        totprd = new int[5];
        idxPrd = 0;
        maksprd = 5;
        System.out.println("Default const berhasil dibuat");
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
        prd[idxPrd] = new cProduk();
        prd[idxPrd] = p;
    }

    public void setTotal(int t) {
        total = t;
    }

    public void setJumlah(int j) {
        jumlah = j;
    }

    public cPembeli getPembeli() {
        return pbl;
    }

    public cProduk[] getProduk() {
        return prd;
    }

    public int getTotal() {
        return total;
    }

    public int getJumlah() {
        return jumlah;
    }

    public int getIdxprd() {
        return idxPrd;
    }

    // keranjang
    public void tambahProduk(cProduk p, int j) {
        prd[idxPrd] = p;
        jumprd[idxPrd] = j;
        totprd[idxPrd] = j * p.getHarga();
        idxPrd++;
    }

    public void tambahProduk(cProduk p) {
        if (idxPrd < maksprd) {
            prd[idxPrd] = p;
            System.out.println("Tambah Sukses");
            idxPrd++;
        } else {
            System.out.println("Keranjang penuh");
        }
    }

    public void lihatKeranjang() {
        System.out.println("Keranjang");
        for (int i = 0; i < idxPrd; i++) {
            System.out.println((i + 1) + ". " + prd[i].getNama() + " [" + jumprd[i] + "]");
        }
        System.out.println("");
    }

    public void hapusProduk(String np) {
        // appKasir main = new konfirmasi();
        boolean ketemu = false;
        for (int i = 0; i < idxPrd; i++) {
            if (np.equalsIgnoreCase(prd[i].getNama())) {
                ketemu = true;
                System.out.println("Apakah yakin?");
                System.out.println("1. Ya");
                System.out.println("2. Tidak");
                System.out.println("pilih = ");
                int jwb = s.nextInt();
                if (jwb == 1) {
                    prd[i] = null;
                    for (int j = 0; j < idxPrd; j++) {
                        if (j == idxPrd - 1) {
                            prd[j] = null;
                        } else {
                            prd[j] = prd[j + 1];
                        }
                    }
                    idxPrd--;
                    System.out.println("Hapus Sukses");
                }
                System.out.println("Hapus Gagal");
                // jwb = konfirmasi();
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
