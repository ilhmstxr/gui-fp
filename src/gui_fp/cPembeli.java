/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_fp;

/**
 *
 * @author Ilhamstxr
 */
public class cPembeli {

    private String nama, alamat;

    cPembeli() {
        System.out.println("Constructor Pembeli Dibuat...");
    }

    cPembeli(String n, String a) {
        nama = n;
        alamat = a;
        System.out.println(nama + alamat + " Dibuat...");
    }

    cPembeli(String n) {
        nama = n;
        System.out.println(nama + " Dibuat..");
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
}
