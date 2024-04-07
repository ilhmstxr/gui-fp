/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui_fp;

import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.ListModel;
import javax.swing.plaf.TabbedPaneUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Ilhamstxr
 */
public class menu extends javax.swing.JFrame {
    
    private JTabbedPane tabbedPane;
//    daftar member
    private int totalPembeli = 200, totalMember = 100;
    private cPembeli listPembeli[] = new cPembeli[totalPembeli];
    private static int idxMember = 0;
    private cMember listMember[] = new cMember[totalMember];
    private cTransaksi tr = new cTransaksi();
    
    private String kode = "";
    private boolean param = false;

//    produk
    private static int idxPrd = 0, totalProduk = 100;
    private int grandTotal = 0;
    
    private cProduk listProduk[] = new cProduk[totalProduk];
    
    private cProduk[] produkDiKeranjang;

    /**
     * Creates new form menu
     */
    public menu() {
        produkDiKeranjang = tr.getObjekProduk();
        initComponents();
        seedingMember();
        refreshTableMember();
        seedingProduk();
        refreshTableProduk();
        refreshKeranjang();
        refreshListProduk();
    }
    
    public void seedingMember() {
//        System.out.println(idx);
        listMember[idxMember++] = new cMember(idxMember, "woheell", "kentotloh");
//        System.out.println(idxMember);
        listMember[idxMember++] = new cMember(idxMember, "iiii", "uuuu");
//        System.out.println(idxMember);
        listMember[idxMember++] = new cMember(idxMember, "wadalah", "hus");
//        System.out.println(idxMember);
    }
    
    public void seedingProduk() {
        listProduk[idxPrd] = new cProduk(idxPrd, "sosis Muantap", 23000, 53);
        idxPrd++;
        listProduk[idxPrd] = new cProduk(idxPrd, "sosis Champ", 19000, 42);
        idxPrd++;
        listProduk[idxPrd] = new cProduk(idxPrd, "sosis Salam", 24000, 15);
        idxPrd++;
        listProduk[idxPrd] = new cProduk(idxPrd, "nugget Champ", 38000, 21);
        idxPrd++;
        listProduk[idxPrd] = new cProduk(idxPrd, "nugget Goldenstar", 42000, 0);
        idxPrd++;
        listProduk[idxPrd] = new cProduk(idxPrd, "nugget Kanzler", 40000, 23);
        idxPrd++;
        listProduk[idxPrd] = new cProduk(idxPrd, "chikuwa Shifudo", 27000, 12);
        idxPrd++;
        listProduk[idxPrd] = new cProduk(idxPrd, "chikuwa Sunfish", 27000, 38);
        idxPrd++;
    }
    
    public void hargaTotal() {
        for (int i = 0; i < produkDiKeranjang.length; i++) {
            if (produkDiKeranjang[i] != null) {
                System.out.println("work 2");
                System.out.println(produkDiKeranjang[i].ToString());
                grandTotal += tr.getTotal(i);
            }
        }
        String total = String.valueOf(grandTotal);
        System.out.println(total);
        
        labelTotalHarga.setText(total);
    }
    
    public void refreshTableMember() {
//        refresh tabel user
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"UID", "Nama", "Alamat", "Tanggal Daftar Member"}, 0); // Column names

        for (int i = 0; i < listMember.length; i++) {
            if (listMember[i] != null) {
                Object[] objekListMember = {
                    listMember[i].getUID(),
                    //                    listMember[i].getUsername(),
                    listMember[i].getNama(),
                    listMember[i].getAlamat(),
                    listMember[i].getTanggalmasuk()
                };
                tableModel.addRow(objekListMember);
            }
        }
        
        daftarMember.setModel(tableModel);
    }
    
    public void refreshTableProduk() {
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"kode Produk", "Nama Produk", "Stok Produk", "Harga Produk"}, 0); // Column names

        for (int i = 0; i < listProduk.length; i++) {
            if (listProduk[i] != null) {
                Object[] objekListProduk = {
                    listProduk[i].getKode(),
                    listProduk[i].getNama(),
                    listProduk[i].getStok(),
                    listProduk[i].getHarga()
                };
                tableModel.addRow(objekListProduk);
            }
        }
        
        daftarProduk.setModel(tableModel);
    }
    
    public void refreshKeranjang() {
        //        keranjang
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"Nama Produk", "Harga Produk", "Jumlah yang dibutuhkan", "total"}, 0); // Column names

        for (int j = 0; j < produkDiKeranjang.length; j++) {
            if (produkDiKeranjang[j] != null) {
                Object[] objekListProduk = {
                    produkDiKeranjang[j].getNama(),
                    produkDiKeranjang[j].getHarga(),
                    tr.getJumlah(j),
                    tr.getTotal(j)
                };
                tableModel.addRow(objekListProduk);
            }
        }
        tabelStrukListProduk.setModel(tableModel);
        tabelKeranjang.setModel(tableModel);
    }
    
    public void refreshListProduk() {
        DefaultListModel listModel = new DefaultListModel();
        for (int i = 0; i < listProduk.length; i++) {
            if (listProduk[i] != null) {
                listModel.addElement((i + 1) + ". " + listProduk[i].ToString());
            }
        }
        jListProduk.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabMaster = new javax.swing.JTabbedPane();
        panelMember = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namaTXT = new javax.swing.JTextField();
        alamatTXT = new javax.swing.JTextField();
        resetButton = new java.awt.Button();
        daftarButton1 = new java.awt.Button();
        jScrollPane1 = new javax.swing.JScrollPane();
        daftarMember = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        panelProduk = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        namaProdukTXT = new javax.swing.JTextField();
        hargaProdukTXT = new javax.swing.JTextField();
        stokProdukTXT = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        daftarProduk = new javax.swing.JTable();
        tambahProdukTXT = new java.awt.Button();
        resetProdukTXT = new java.awt.Button();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        panelTransaksi = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelTotalHarga = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelStrukListProduk = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        bayarTXT = new javax.swing.JTextField();
        kembali = new javax.swing.JLabel();
        buttonBayar = new javax.swing.JButton();
        panelHistori = new javax.swing.JPanel();
        tabMasterHistori = new javax.swing.JTabbedPane();
        LP_Produk = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        LP_Pembeli = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        PanelPilih = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        cariProdukTXT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jumlahProdukTXT = new javax.swing.JTextField();
        buttonHapusProdukTRX = new javax.swing.JButton();
        buttonCetakBayar = new javax.swing.JButton();
        jScrollPaneKeranjang = new javax.swing.JScrollPane();
        tabelKeranjang = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        hapusProdukTRXTXT = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListProduk = new javax.swing.JList<>();
        resetTransaksiButton = new javax.swing.JButton();
        buttonTambahProdukTRX = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelMember.setBackground(new java.awt.Color(153, 204, 255));
        panelMember.setPreferredSize(new java.awt.Dimension(816, 700));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Daftar Member Baru");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Nama Lengkap: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Alamat:");

        namaTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaTXTActionPerformed(evt);
            }
        });

        alamatTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatTXTActionPerformed(evt);
            }
        });

        resetButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetButton.setLabel("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        daftarButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        daftarButton1.setLabel("Daftar");
        daftarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daftarButton1ActionPerformed(evt);
            }
        });

        daftarMember.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UID", "Nama", "Alamat", "Tanggal Daftar"
            }
        ));
        daftarMember.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                daftarMemberComponentAdded(evt);
            }
        });
        daftarMember.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                daftarMemberPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(daftarMember);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-ice-48.png"))); // NOI18N
        jLabel21.setText("jLabel20");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-account-48.png"))); // NOI18N
        jLabel22.setText("jLabel22");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-home-50.png"))); // NOI18N
        jLabel23.setText("jLabel23");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-ice-48.png"))); // NOI18N
        jLabel36.setText("jLabel20");

        javax.swing.GroupLayout panelMemberLayout = new javax.swing.GroupLayout(panelMember);
        panelMember.setLayout(panelMemberLayout);
        panelMemberLayout.setHorizontalGroup(
            panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMemberLayout.createSequentialGroup()
                .addGroup(panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelMemberLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMemberLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelMemberLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(namaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelMemberLayout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alamatTXT))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                        .addComponent(daftarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(248, 248, 248))
        );
        panelMemberLayout.setVerticalGroup(
            panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel21)
                    .addComponent(jLabel36))
                .addGroup(panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMemberLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMemberLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(namaTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addGroup(panelMemberLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(panelMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(daftarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelMemberLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alamatTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE))
        );

        tabMaster.addTab("Member", panelMember);

        panelProduk.setBackground(new java.awt.Color(153, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Tambah Produk");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nama Produk: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Stok Produk: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Harga Produk: ");

        namaProdukTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaProdukTXTActionPerformed(evt);
            }
        });

        hargaProdukTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaProdukTXTActionPerformed(evt);
            }
        });

        daftarProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Produk", "Nama Produk", "Harga Produk", "Stok Produk", "Tanggal Ditambahkan", "Tanggal Diubah"
            }
        ));
        jScrollPane2.setViewportView(daftarProduk);

        tambahProdukTXT.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tambahProdukTXT.setLabel("Tambah");
        tambahProdukTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahProdukTXTActionPerformed(evt);
            }
        });

        resetProdukTXT.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        resetProdukTXT.setLabel("Reset");
        resetProdukTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetProdukTXTActionPerformed(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-ice-48.png"))); // NOI18N
        jLabel24.setText("jLabel20");

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-ice-48.png"))); // NOI18N
        jLabel25.setText("jLabel20");

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-product-50.png"))); // NOI18N
        jLabel26.setText("jLabel26");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-price-50.png"))); // NOI18N
        jLabel27.setText("jLabel27");

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-stock-50.png"))); // NOI18N

        javax.swing.GroupLayout panelProdukLayout = new javax.swing.GroupLayout(panelProduk);
        panelProduk.setLayout(panelProdukLayout);
        panelProdukLayout.setHorizontalGroup(
            panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panelProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProdukLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProdukLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(namaProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProdukLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(resetProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelProdukLayout.createSequentialGroup()
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(242, 242, 242))))
                    .addGroup(panelProdukLayout.createSequentialGroup()
                        .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelProdukLayout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hargaProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelProdukLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(stokProdukTXT))))
                        .addGap(52, 52, 52)
                        .addComponent(tambahProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelProdukLayout.setVerticalGroup(
            panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel25)
                    .addComponent(jLabel24))
                .addGap(21, 21, 21)
                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26)
                    .addGroup(panelProdukLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(namaProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addGroup(panelProdukLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hargaProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addGroup(panelProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelProdukLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(stokProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(tambahProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(resetProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        tabMaster.addTab("Produk", panelProduk);

        panelTransaksi.setBackground(new java.awt.Color(153, 204, 255));

        jLabel8.setText("TOTAL");

        jLabel9.setText("RP. ");

        labelTotalHarga.setText("0");

        jLabel11.setText("Nama Pembeli: ");

        jLabel12.setText("Member:");

        jLabel13.setText("Sejak: ");

        tabelStrukListProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabelStrukListProduk);

        jLabel10.setText("Bayar: ");

        jLabel19.setText("Kembali");

        bayarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarTXTActionPerformed(evt);
            }
        });

        kembali.setText("0");

        buttonBayar.setText("Bayar");
        buttonBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTransaksiLayout = new javax.swing.GroupLayout(panelTransaksi);
        panelTransaksi.setLayout(panelTransaksiLayout);
        panelTransaksiLayout.setHorizontalGroup(
            panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransaksiLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransaksiLayout.createSequentialGroup()
                        .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelTransaksiLayout.createSequentialGroup()
                                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelTransaksiLayout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelTransaksiLayout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(275, 275, 275)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransaksiLayout.createSequentialGroup()
                                        .addComponent(bayarTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(22, 22, 22))
                                    .addComponent(kembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelTransaksiLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(labelTotalHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(98, 98, 98))
                    .addGroup(panelTransaksiLayout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(276, 276, 276))))
            .addGroup(panelTransaksiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTransaksiLayout.setVerticalGroup(
            panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransaksiLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(labelTotalHarga))
                .addGap(39, 39, 39)
                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(bayarTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel19)
                    .addComponent(kembali))
                .addGap(18, 18, 18)
                .addGroup(panelTransaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(buttonBayar))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(519, Short.MAX_VALUE))
        );

        tabMaster.addTab("Transaksi", panelTransaksi);

        panelHistori.setBackground(new java.awt.Color(255, 255, 255));

        tabMasterHistori.setBackground(new java.awt.Color(255, 255, 255));

        LP_Produk.setBackground(new java.awt.Color(153, 204, 255));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable3);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Tanggal");

        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1.setText("Menurun");

        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2.setText("Naik");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-up-50.png"))); // NOI18N

        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-down-50.png"))); // NOI18N

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-date-50.png"))); // NOI18N

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LP_ProdukLayout = new javax.swing.GroupLayout(LP_Produk);
        LP_Produk.setLayout(LP_ProdukLayout);
        LP_ProdukLayout.setHorizontalGroup(
            LP_ProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
            .addGroup(LP_ProdukLayout.createSequentialGroup()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LP_ProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(100, 100, 100)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LP_ProdukLayout.setVerticalGroup(
            LP_ProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LP_ProdukLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LP_ProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LP_ProdukLayout.createSequentialGroup()
                        .addGroup(LP_ProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LP_ProdukLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(102, 102, 102))
                    .addGroup(LP_ProdukLayout.createSequentialGroup()
                        .addGroup(LP_ProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(LP_ProdukLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );

        tabMasterHistori.addTab("Laporan Produk", LP_Produk);

        LP_Pembeli.setBackground(new java.awt.Color(153, 204, 255));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-date-50.png"))); // NOI18N

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel33.setText("Tanggal");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-up-50.png"))); // NOI18N

        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton5.setText("Naik");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton6.setText("Menurun");

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Aset/icons8-down-50.png"))); // NOI18N

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(jTable5);

        javax.swing.GroupLayout LP_PembeliLayout = new javax.swing.GroupLayout(LP_Pembeli);
        LP_Pembeli.setLayout(LP_PembeliLayout);
        LP_PembeliLayout.setHorizontalGroup(
            LP_PembeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 818, Short.MAX_VALUE)
            .addGroup(LP_PembeliLayout.createSequentialGroup()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(LP_PembeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(100, 100, 100)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LP_PembeliLayout.setVerticalGroup(
            LP_PembeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LP_PembeliLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LP_PembeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LP_PembeliLayout.createSequentialGroup()
                        .addGroup(LP_PembeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jRadioButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(LP_PembeliLayout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jRadioButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(102, 102, 102))
                    .addGroup(LP_PembeliLayout.createSequentialGroup()
                        .addGroup(LP_PembeliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(LP_PembeliLayout.createSequentialGroup()
                                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel32))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
        );

        tabMasterHistori.addTab("Laporan Pembeli", LP_Pembeli);

        javax.swing.GroupLayout panelHistoriLayout = new javax.swing.GroupLayout(panelHistori);
        panelHistori.setLayout(panelHistoriLayout);
        panelHistoriLayout.setHorizontalGroup(
            panelHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMasterHistori)
        );
        panelHistoriLayout.setVerticalGroup(
            panelHistoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMasterHistori, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, Short.MAX_VALUE)
        );

        tabMaster.addTab("Laporan", panelHistori);

        PanelPilih.setBackground(new java.awt.Color(153, 204, 255));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setText("Silahkan Pilih Produk Yang Akan Di Beli !");

        cariProdukTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariProdukTXTActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Masukkan Nama Produk (angka): ");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Banyak Yang Dibeli :");

        buttonHapusProdukTRX.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonHapusProdukTRX.setText("Hapus");
        buttonHapusProdukTRX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusProdukTRXActionPerformed(evt);
            }
        });

        buttonCetakBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buttonCetakBayar.setText("Cetak Pilihan");
        buttonCetakBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCetakBayarActionPerformed(evt);
            }
        });

        jScrollPaneKeranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPaneKeranjangMouseClicked(evt);
            }
        });

        tabelKeranjang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Produk", "Harga Satuan", "Banyak Yang Dibeli", "Total Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneKeranjang.setViewportView(tabelKeranjang);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Masukkan Nama Produk Yang Akan Di Hapus : ");

        hapusProdukTRXTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusProdukTRXTXTActionPerformed(evt);
            }
        });

        jListProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProdukMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jListProduk);

        resetTransaksiButton.setText("Reset");
        resetTransaksiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetTransaksiButtonActionPerformed(evt);
            }
        });

        buttonTambahProdukTRX.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonTambahProdukTRX.setText("Tambah");
        buttonTambahProdukTRX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahProdukTRXActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPilihLayout = new javax.swing.GroupLayout(PanelPilih);
        PanelPilih.setLayout(PanelPilihLayout);
        PanelPilihLayout.setHorizontalGroup(
            PanelPilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPilihLayout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPilihLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addGap(18, 18, 18)
                .addGroup(PanelPilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelPilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                            .addComponent(cariProdukTXT)
                            .addComponent(buttonHapusProdukTRX)
                            .addComponent(jLabel17)
                            .addComponent(hapusProdukTRXTXT))
                        .addGroup(PanelPilihLayout.createSequentialGroup()
                            .addComponent(buttonCetakBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(resetTransaksiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jumlahProdukTXT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonTambahProdukTRX)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPaneKeranjang)
        );
        PanelPilihLayout.setVerticalGroup(
            PanelPilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPilihLayout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(PanelPilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PanelPilihLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cariProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jumlahProdukTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTambahProdukTRX)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel17)
                        .addGap(8, 8, 8)
                        .addComponent(hapusProdukTRXTXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonHapusProdukTRX)
                        .addGap(18, 18, 18)
                        .addGroup(PanelPilihLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonCetakBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resetTransaksiButton)))
                    .addComponent(jScrollPane7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneKeranjang, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabMaster.addTab("Pilih Produk", PanelPilih);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMaster)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabMaster, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(830, 836));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void namaTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaTXTActionPerformed

    private void alamatTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatTXTActionPerformed

    private void daftarMemberComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_daftarMemberComponentAdded

    }//GEN-LAST:event_daftarMemberComponentAdded

    private void daftarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarButton1ActionPerformed
//        String username = usernameTXT.getText();
//        String passwordraw = passwordTXT.getText();
//        int password = Integer.parseInt(passwordraw);
        String namaLengkap = namaTXT.getText();
        String alamat = alamatTXT.getText();
        
        listMember[idxMember++] = new cMember(idxMember, namaLengkap, alamat);
        JOptionPane.showMessageDialog(rootPane, "Member" + namaLengkap + "berhasil terdaftar!");
        
        namaTXT.setText("");
        alamatTXT.setText("");
        refreshTableMember();
    }//GEN-LAST:event_daftarButton1ActionPerformed

    private void daftarMemberPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_daftarMemberPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_daftarMemberPropertyChange

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        namaTXT.setText("");
        alamatTXT.setText("");
    }//GEN-LAST:event_resetButtonActionPerformed

    private void tambahProdukTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahProdukTXTActionPerformed
        String namaProduk = namaProdukTXT.getText();
        String hp = hargaProdukTXT.getText();
        String sp = stokProdukTXT.getText();
        
        int hargaProduk = Integer.parseInt(hp);
        int stokProduk = Integer.parseInt(sp);
        
        listProduk[idxPrd++] = new cProduk(idxPrd, namaProduk, hargaProduk, stokProduk);
        
        namaProdukTXT.setText("");
        hargaProdukTXT.setText("");
        stokProdukTXT.setText("");
        refreshTableProduk();
    }//GEN-LAST:event_tambahProdukTXTActionPerformed

    private void resetProdukTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetProdukTXTActionPerformed
        namaProdukTXT.setText("");
        hargaProdukTXT.setText("");
        stokProdukTXT.setText("");
    }//GEN-LAST:event_resetProdukTXTActionPerformed

    private void cariProdukTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariProdukTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cariProdukTXTActionPerformed

    private void buttonHapusProdukTRXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusProdukTRXActionPerformed
        String idHapus = hapusProdukTRXTXT.getText();
        int idxhps = Integer.parseInt(idHapus);
        String kode = listProduk[idxhps - 1].getKode();
        
        for (int i = 0; i < produkDiKeranjang.length; i++) {
            if (produkDiKeranjang[i] != null) {
                if (produkDiKeranjang[i].getKode().equalsIgnoreCase(kode)) {
                    System.out.println("d");
                    tr.hapusProduk(kode);
                }
            }
        }
        
        refreshKeranjang();
        hapusProdukTRXTXT.setText("");
    }//GEN-LAST:event_buttonHapusProdukTRXActionPerformed

//    tr.hapusProduk (kode);

    private void namaProdukTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaProdukTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaProdukTXTActionPerformed

    private void hargaProdukTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaProdukTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaProdukTXTActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jScrollPaneKeranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPaneKeranjangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPaneKeranjangMouseClicked

    private void jListProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProdukMouseClicked
        int index = jListProduk.getSelectedIndex();
        if (index != -1) {
//            String produk = jListProduk.getSelectedValue();
            String kodeProduk = listProduk[index].getKode();
            System.out.println(kodeProduk);
            
            tr.tambahProduk(listProduk[index], 1);
            param = true;
            refreshKeranjang();
            
        }
    }//GEN-LAST:event_jListProdukMouseClicked

    private void resetTransaksiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetTransaksiButtonActionPerformed
        tr.reset();
        labelTotalHarga.setText("0");
        grandTotal = 0;
        produkDiKeranjang = tr.getObjekProduk();
        refreshKeranjang();
    }//GEN-LAST:event_resetTransaksiButtonActionPerformed

    private void buttonTambahProdukTRXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahProdukTRXActionPerformed
//        int nama = Integer.parseInt(cariProdukTXT.getText());
        String namaRaw = cariProdukTXT.getText();
        String jumlahRaw = jumlahProdukTXT.getText();
        int indexPrd = Integer.parseInt(namaRaw);
        int jumlahPrd = Integer.parseInt(jumlahRaw);
        
        int idx = 0;
        boolean ketemu = false;
//        System.out.println(jumlahPrd);
        for (int i = 0; i < listProduk.length; i++) {
            if (i == indexPrd && listProduk[i - 1].getStok() > jumlahPrd) {
                if (listProduk != null) {
                    ketemu = true;
                    idx = indexPrd - 1;
                }
            }
        }
        
        if (listProduk[idx].getStok() == 0) {
            JOptionPane.showMessageDialog(tabelKeranjang, "TIDAK BISA, PRODUK KOSONG");
        } else if (listProduk[idx].getStok() < jumlahPrd) {
            JOptionPane.showMessageDialog(tabelKeranjang, "TIDAK BISA, JUMLAH MELEBIHI STOK");
        } else if (ketemu || listProduk[idx].getStok() == jumlahPrd) {
            tr.tambahProduk(listProduk[idx], jumlahPrd);
        }
        
        refreshKeranjang();
        hargaTotal();
        
        cariProdukTXT.setText("");
        jumlahProdukTXT.setText("");
    }//GEN-LAST:event_buttonTambahProdukTRXActionPerformed

    private void hapusProdukTRXTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusProdukTRXTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusProdukTRXTXTActionPerformed

    private void buttonCetakBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCetakBayarActionPerformed
        panelTransaksi.setVisible(true);
    }//GEN-LAST:event_buttonCetakBayarActionPerformed

    private void bayarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarTXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarTXTActionPerformed

    private void buttonBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBayarActionPerformed
        int grandTotal = 0;
        
        for (int i = 0; i < produkDiKeranjang.length; i++) {
            if (produkDiKeranjang[i] != null) {
                grandTotal += tr.getTotal(i);
            }
        }
        String total = String.valueOf(grandTotal);
        
        labelTotalHarga.setText(total);
//        kembali
        String bayar = bayarTXT.getText();
        int uangBayar = Integer.parseInt(bayar);
        if (uangBayar < grandTotal) {
            JOptionPane.showMessageDialog(rootPane, "tidak cukup");
        } else {
            if (uangBayar == grandTotal) {
                JOptionPane.showMessageDialog(rootPane, "pas mas");
            } else {
                int kembalian = uangBayar - grandTotal;
                kembali.setText(String.valueOf(kembalian));
//                JOptionPane.showMessageDialog(rootPane, "pas mas" + kembalian);
            }
        }
    }//GEN-LAST:event_buttonBayarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LP_Pembeli;
    private javax.swing.JPanel LP_Produk;
    private javax.swing.JPanel PanelPilih;
    private javax.swing.JTextField alamatTXT;
    private javax.swing.JTextField bayarTXT;
    private javax.swing.JButton buttonBayar;
    private javax.swing.JButton buttonCetakBayar;
    private javax.swing.JButton buttonHapusProdukTRX;
    private javax.swing.JButton buttonTambahProdukTRX;
    private javax.swing.JTextField cariProdukTXT;
    private java.awt.Button daftarButton1;
    private javax.swing.JTable daftarMember;
    private javax.swing.JTable daftarProduk;
    private javax.swing.JTextField hapusProdukTRXTXT;
    private javax.swing.JTextField hargaProdukTXT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListProduk;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPaneKeranjang;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jumlahProdukTXT;
    private javax.swing.JLabel kembali;
    private javax.swing.JLabel labelTotalHarga;
    private javax.swing.JTextField namaProdukTXT;
    private javax.swing.JTextField namaTXT;
    private javax.swing.JPanel panelHistori;
    private javax.swing.JPanel panelMember;
    private javax.swing.JPanel panelProduk;
    private javax.swing.JPanel panelTransaksi;
    private java.awt.Button resetButton;
    private java.awt.Button resetProdukTXT;
    private javax.swing.JButton resetTransaksiButton;
    private javax.swing.JTextField stokProdukTXT;
    private javax.swing.JTabbedPane tabMaster;
    private javax.swing.JTabbedPane tabMasterHistori;
    private javax.swing.JTable tabelKeranjang;
    private javax.swing.JTable tabelStrukListProduk;
    private java.awt.Button tambahProdukTXT;
    // End of variables declaration//GEN-END:variables

}
