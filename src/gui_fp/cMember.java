/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui_fp;

import javax.swing.JOptionPane;
import java.time.LocalDateTime;

/**
 *
 * @author Ilhamstxr
 */
public class cMember {

    LocalDateTime date = LocalDateTime.now();
    int tanggal = date.getDayOfMonth();
    int bulan = date.getMonthValue();
    int tahun = date.getYear();
    int jam = date.getHour();
    int menit = date.getMinute();

    private String namaLengkap, tanggalMasuk, alamat, uid;
    private int password;
//    private static int urutanMember ;

    public cMember(int idx, String nama, String almt) {
//        urutanMember++;
//        System.out.println(idx);
        String member = String.format("%03d", idx);
        String strBulan = String.format("%02d", bulan);
        String strHari = String.format("%02d", tanggal);

        namaLengkap = nama;
        alamat = almt;
        tanggalMasuk = strHari + "-" + strBulan + "-" + tahun;
        uid = tahun + "" + strBulan + strHari + "" + member;

//        username = uname;
//        password = pw;
    }

    public String getUID() {
        return uid;
    }

    public String getNama() {
        return namaLengkap;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public String getTanggalmasuk() {
        return tanggalMasuk;
    }

//    public String getUsername() {
//        return username;
//    }
}
