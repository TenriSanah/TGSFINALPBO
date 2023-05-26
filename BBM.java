package koneksi;

import gambar.Background;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BBM extends javax.swing.JFrame {
    private SimpleDateFormat dateFormat;
    private int hargaPerLiter = 0;

    private String getCurrentDate() {
    Date currentDate = new Date();
    return dateFormat.format(currentDate);
}
    
    private void tampilData(){
        
        DefaultTableModel model = new DefaultTableModel(); //Object yang digunakan untuk menampilkan data pada tabel
        model.addColumn("No. ");
        model.addColumn("Nama Pemesan");
        model.addColumn("No.Telp Aktif ");
        model.addColumn("Jenis Produk ");
        model.addColumn("Alamat Pengantaran ");
        model.addColumn("Jumlah satuan Liter ");
        model.addColumn("Jenis Pembayaran ");
        model.addColumn("Harga ");
        model.addColumn("Tanggal ");
        model.addColumn("Status ");
        model.addColumn("Rating ");
        
        try {
            int  no = 1;
            String sql = "SELECT * FROM tb_pesanan";//menampilkan data yang ada pada tb_pesanan dan menyimpan dalam variabel
            java.sql.Connection connection = (Connection)KoneksiDB.DBConnection(); //mengkoneksikan nya ke database
            java.sql.Statement stm = connection.createStatement();
            java.sql.ResultSet result = stm.executeQuery(sql);
            while(result.next()){
//                String status = "Proses"; // Ubah indeks menjadi 9 sesuai dengan kolom "Status"
                model.addRow(new Object[]{
                    no++,
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7),
                    result.getString(8),
                    result.getString(9),
                    result.getString(10),
                    result.getString(11)});
                }
                tblRiwayat.setModel(model);
        } catch (SQLException exc) {
            System.out.println("Error : " + exc.getMessage());
        }
    }
    
    private void updateStatus() {
     try {
         String sql = "UPDATE tb_pesanan SET status = ? WHERE status = ?";
         Connection connection = KoneksiDB.DBConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         statement.setString(1, "Selesai");
         statement.setString(2, "Proses");
         statement.executeUpdate();
         statement.close();
         connection.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
    

    private void simpanRating(String rating) {
    try {
        String sql = "UPDATE tb_pesanan SET Rating = ? WHERE status = ? ORDER BY id_pemesan DESC LIMIT 1 ";
        Connection connection = KoneksiDB.DBConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, rating);
        statement.setString(2, "Selesai");
        statement.executeUpdate();
        statement.close();
        connection.close();

        JOptionPane.showMessageDialog(null, "Rating berhasil disimpan!");
           // Update tabel riwayat
        tampilData();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public BBM() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        btnKonfirmasiClicked = false;
        tampilData();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
        // Menyembunyikan tabel dan label pada awalnya
        tblRiwayat.setVisible(false);
        lblRiwayatTransaksi.setVisible(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new Background();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRiwayat = new javax.swing.JTable();
        lblRiwayatTransaksi = new javax.swing.JLabel();
        btnKeluar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnKonfirmasi = new javax.swing.JButton();
        btnPesan = new javax.swing.JButton();
        btnLihatTransaksi = new javax.swing.JButton();
        txtStatus = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        btnTanggal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTanggal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        cbPembayaran = new javax.swing.JComboBox<>();
        cbRating = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTelp = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbJenisProduk = new javax.swing.JComboBox<>();
        txtAlamat = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Program BBM Berjalan");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblRiwayat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblRiwayat);

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(390, 440, 900, 260);

        lblRiwayatTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRiwayatTransaksi.setText("Riwayat Transaksi");
        jDesktopPane1.add(lblRiwayatTransaksi);
        lblRiwayatTransaksi.setBounds(390, 410, 900, 26);

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnKeluar);
        btnKeluar.setBounds(300, 650, 72, 23);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        jLabel1.setText("Program BBM Berjalan");
        jDesktopPane1.add(jLabel1);
        jLabel1.setBounds(230, 0, 294, 33);

        btnKonfirmasi.setText("Pesanan Telah Diterima");
        btnKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnKonfirmasi);
        btnKonfirmasi.setBounds(10, 650, 260, 40);

        btnPesan.setBackground(new java.awt.Color(102, 255, 102));
        btnPesan.setText("Pesan");
        btnPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesanActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnPesan);
        btnPesan.setBounds(20, 610, 72, 23);

        btnLihatTransaksi.setBackground(new java.awt.Color(51, 51, 255));
        btnLihatTransaksi.setText("Lihat Transaksi");
        btnLihatTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLihatTransaksiActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnLihatTransaksi);
        btnLihatTransaksi.setBounds(100, 610, 160, 23);

        txtStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStatusActionPerformed(evt);
            }
        });
        jDesktopPane1.add(txtStatus);
        txtStatus.setBounds(190, 530, 191, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Status Pesanan");
        jDesktopPane1.add(jLabel11);
        jLabel11.setBounds(30, 530, 144, 30);

        btnTanggal.setText("Klik Tanggal Hari Ini");
        btnTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTanggalActionPerformed(evt);
            }
        });
        jDesktopPane1.add(btnTanggal);
        btnTanggal.setBounds(30, 500, 350, 23);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Tanggal Pemesanan");
        jDesktopPane1.add(jLabel3);
        jLabel3.setBounds(30, 470, 150, 20);

        txtTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTanggalActionPerformed(evt);
            }
        });
        jDesktopPane1.add(txtTanggal);
        txtTanggal.setBounds(190, 470, 191, 22);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Rating                      ");
        jDesktopPane1.add(jLabel8);
        jLabel8.setBounds(30, 570, 110, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Pilih Pembayaran      ");
        jDesktopPane1.add(jLabel7);
        jLabel7.setBounds(30, 410, 138, 17);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Jumlah                      ");
        jDesktopPane1.add(jLabel6);
        jLabel6.setBounds(30, 380, 144, 17);

        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });
        jDesktopPane1.add(txtJumlah);
        txtJumlah.setBounds(190, 380, 191, 22);

        cbPembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "ATM", "PayLater" }));
        cbPembayaran.setName("jenis_product"); // NOI18N
        cbPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPembayaranActionPerformed(evt);
            }
        });
        jDesktopPane1.add(cbPembayaran);
        cbPembayaran.setBounds(190, 410, 191, 22);

        cbRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "\t", "Cukup ", "Puas", "Sangat Puas", "Tidak Puas" }));
        cbRating.setName("jenis_product"); // NOI18N
        cbRating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRatingActionPerformed(evt);
            }
        });
        jDesktopPane1.add(cbRating);
        cbRating.setBounds(190, 570, 191, 22);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Nama Pemesan         ");
        jDesktopPane1.add(jLabel15);
        jLabel15.setBounds(30, 200, 140, 17);

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });
        jDesktopPane1.add(txtNama);
        txtNama.setBounds(190, 200, 188, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("No. Telp Aktif            ");
        jDesktopPane1.add(jLabel2);
        jLabel2.setBounds(30, 230, 140, 17);

        txtTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelpActionPerformed(evt);
            }
        });
        jDesktopPane1.add(txtTelp);
        txtTelp.setBounds(190, 230, 188, 22);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Jenis Produk             ");
        jDesktopPane1.add(jLabel10);
        jLabel10.setBounds(30, 260, 140, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Alamat Pengantaran ");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(30, 290, 144, 17);

        cbJenisProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pertamax", "Pertalite", "BioSolar", "Dexlite" }));
        cbJenisProduk.setName("jenis_product"); // NOI18N
        cbJenisProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisProdukActionPerformed(evt);
            }
        });
        jDesktopPane1.add(cbJenisProduk);
        cbJenisProduk.setBounds(190, 260, 188, 22);

        txtAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAlamatActionPerformed(evt);
            }
        });
        jDesktopPane1.add(txtAlamat);
        txtAlamat.setBounds(190, 290, 280, 80);

        txtHarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHargaActionPerformed(evt);
            }
        });
        jDesktopPane1.add(txtHarga);
        txtHarga.setBounds(190, 440, 190, 22);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Harga yang harus dibayar  ");
        jDesktopPane1.add(jLabel4);
        jLabel4.setBounds(30, 440, 200, 20);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/dexlite.png"))); // NOI18N
        jLabel9.setText("jLabel9");
        jDesktopPane1.add(jLabel9);
        jLabel9.setBounds(1000, 30, 340, 140);

        jLabel12.setForeground(new java.awt.Color(51, 255, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/pertamax.png"))); // NOI18N
        jLabel12.setText("jLabel9");
        jDesktopPane1.add(jLabel12);
        jLabel12.setBounds(20, 20, 250, 150);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/BioSolar.png"))); // NOI18N
        jLabel13.setText("jLabel9");
        jDesktopPane1.add(jLabel13);
        jLabel13.setBounds(310, 30, 340, 140);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/images.jpg"))); // NOI18N
        jDesktopPane1.add(jLabel14);
        jLabel14.setBounds(690, 30, 280, 140);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("13950/Liter");
        jDesktopPane1.add(jLabel16);
        jLabel16.setBounds(1000, 160, 330, 30);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("15.000/Liter");
        jDesktopPane1.add(jLabel17);
        jLabel17.setBounds(20, 160, 250, 30);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("15.000/Liter");
        jDesktopPane1.add(jLabel18);
        jLabel18.setBounds(310, 170, 340, 30);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("10000/Liter");
        jDesktopPane1.add(jLabel19);
        jLabel19.setBounds(680, 160, 300, 30);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Nama : Tenri Sa'nah");
        jDesktopPane1.add(jLabel20);
        jLabel20.setBounds(670, 10, 150, 17);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setText("Nim : 13020210164");
        jDesktopPane1.add(jLabel21);
        jLabel21.setBounds(810, 10, 120, 17);

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHargaActionPerformed

    private void txtAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAlamatActionPerformed

    private void cbJenisProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisProdukActionPerformed
        // TODO add your handling code here:
        String jenisProduk = (String) cbJenisProduk.getSelectedItem();
        if (jenisProduk.equals("Pertamax")) {
            hargaPerLiter = 13550;
        } else if (jenisProduk.equals("Pertalite")) {
            hargaPerLiter = 10000;
        } else if (jenisProduk.equals("BioSolar")) {
            hargaPerLiter = 6800;
        } else if (jenisProduk.equals("Dexlite")) {
            hargaPerLiter = 13950;
        }

        //String jumlahText = txtJumlah.getText();
        //
        // if (!jumlahText.isEmpty()) {
            //            try {
                //                int jumlah = Integer.parseInt(jumlahText);
                //                int harga = jumlah * hargaPerLiter;
                //
                //                txtHarga.setText(Integer.toString(harga));
                //            } catch (NumberFormatException e) {
                //                e.printStackTrace();
                //            }
            //
            //        }
        updateHarga();
    }//GEN-LAST:event_cbJenisProdukActionPerformed

    private void txtTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelpActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNamaActionPerformed

    private void cbRatingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRatingActionPerformed
        String rating = (String) cbRating.getSelectedItem();
        simpanRating(rating);
    }//GEN-LAST:event_cbRatingActionPerformed

    private void cbPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPembayaranActionPerformed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed

        updateHarga();
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void txtTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTanggalActionPerformed

    private void btnTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTanggalActionPerformed
        // TODO add your handling code here:
        String tanggal = getCurrentDate();
        txtTanggal.setText(tanggal);
    }//GEN-LAST:event_btnTanggalActionPerformed

    private void txtStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStatusActionPerformed

    private void btnLihatTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLihatTransaksiActionPerformed
        // TODO add your handling code here:
        // Menampilkan tabel dan label ketika tombol diklik
        tblRiwayat.setVisible(true);
        lblRiwayatTransaksi.setVisible(true);
    }//GEN-LAST:event_btnLihatTransaksiActionPerformed

    private void btnPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesanActionPerformed

        // Mengambil nilai-nilai input dari pengguna
        String nama = txtNama.getText();
        String telp = txtTelp.getText();
        String jenisProduk = (String) cbJenisProduk.getSelectedItem();
        String alamat = txtAlamat.getText();

        String jumlah = txtJumlah.getText();
        String pembayaran = (String) cbPembayaran.getSelectedItem();
        String tanggal = txtTanggal.getText();
        String status = "Proses";
        String rating = (String) cbRating.getSelectedItem();

        // Memeriksa apakah semua teks telah diisi
        if (nama.isEmpty() || telp.isEmpty() || alamat.isEmpty() || jumlah.isEmpty() || tanggal.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Harap isi semua data!");
            return; // Menghentikan eksekusi selanjutnya jika data belum lengkap
        }

        // Memeriksa apakah jumlah hanya terdiri dari angka
        for (char c : jumlah.toCharArray()) {
            if (!Character.isDigit(c)) {
                JOptionPane.showMessageDialog(this, "Jumlah hanya boleh terdiri dari angka!");
                return; // Menghentikan eksekusi selanjutnya jika jumlah mengandung karakter selain angka
            }
        }

        if (!telp.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Nomor telepon hanya dapat memasukkan angka saja.", "Validasi Nomor Telepon", JOptionPane.WARNING_MESSAGE);
        } else if (telp.length() > 12) {
            JOptionPane.showMessageDialog(this, "Nomor telepon tidak boleh lebih dari 12 karakter.", "Validasi Nomor Telepon", JOptionPane.WARNING_MESSAGE);
        } else {
            try {// Menyimpan data ke dalam database
                int Jumlah = Integer.parseInt(jumlah);
                int harga = Jumlah * hargaPerLiter;

                txtHarga.setText(Integer.toString(harga));
                String sql = "INSERT INTO tb_pesanan (Nama_Pemesan, No_Telp, Jenis_product, Alamat, Jumlah, Jenis_Pembayaran,Harga, Tanggal, Status, Rating) VALUES (?, ?, ?, ?,?, ?, ?, ?, ?, null)";
                Connection connection = KoneksiDB.DBConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, nama);
                statement.setString(2, telp);
                statement.setString(3, jenisProduk);
                statement.setString(4, alamat);
                statement.setString(5, jumlah);
                statement.setString(6, pembayaran);
                statement.setInt(7, harga);
                statement.setString(8, tanggal);
                statement.setString(9, status);
                //        statement.setString(10, rating);
                statement.executeUpdate();
                statement.close();
                JOptionPane.showMessageDialog(this, "Pesanan Berhasil dilakukan");

                // Kosongkan field input setelah pesanan berhasil disimpan
                txtNama.setText("");
                txtTelp.setText("");
                txtAlamat.setText("");
                txtJumlah.setText("");
                cbPembayaran.setSelectedIndex(0);
                cbRating.setSelectedIndex(0);
                txtHarga.setText("");
                txtTanggal.setText("");
                //    txtStatus.setText("");

            // Setelah menyimpan data ke dalam database, tambahkan kode berikut:
            status = "Proses"; // Atur status kembali ke "Proses"
            txtStatus.setText(status); // Perbarui teks pada txtStatus
            // Menampilkan data pada tabel
            tampilData();
            } catch (SQLException exc) {
                System.out.println("Error: " + exc.getMessage());
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat menyimpan data!");
            }


        }
    }//GEN-LAST:event_btnPesanActionPerformed

    private void btnKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiActionPerformed
        updateStatus();
        txtStatus.setText("Selesai");
        tampilData();

        int dialogResult = JOptionPane.showOptionDialog(this, "Apakah anda ingin memberikan Rating pada program kami?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (dialogResult == JOptionPane.YES_OPTION) {
            String rating = (String) cbRating.getSelectedItem();
            if (rating.isEmpty() || rating.equals("\t")) {
                JOptionPane.showMessageDialog(this, "Harap pilih rating!");
                return;
            }
            //simpan pembaharuan
            simpanRating(rating);
            updateStatus();
            tampilData();
        }
    }//GEN-LAST:event_btnKonfirmasiActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void updateHarga(){
    String jumlahText = txtJumlah.getText();

 if (!jumlahText.isEmpty()) {
            try {
                int jumlah = Integer.parseInt(jumlahText);
                int harga = jumlah * hargaPerLiter;
                
                txtHarga.setText(Integer.toString(harga));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        
        }
    }
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
            java.util.logging.Logger.getLogger(BBM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BBM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BBM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BBM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BBM().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKonfirmasi;
    private javax.swing.JButton btnLihatTransaksi;
    private javax.swing.JButton btnPesan;
    private javax.swing.JButton btnTanggal;
    private javax.swing.JComboBox<String> cbJenisProduk;
    private javax.swing.JComboBox<String> cbPembayaran;
    private javax.swing.JComboBox<String> cbRating;
    private javax.swing.JDesktopPane jDesktopPane1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRiwayatTransaksi;
    private javax.swing.JTable tblRiwayat;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTelp;
    // End of variables declaration//GEN-END:variables
}

/*
permasalahan saya, dari kode dibawah ini, coba buatkan agar ketika saya usai mengisi semua data pada txt nya(kecuali txtStatus), dan mengKlik btnPesan, maka pada txtStatus muncul  tulisan "Proses", dan tersimpan di database, namun ketika saya mengklik tombol btnKonfirmasi, maka tulisan pada txtStatus akan berubah menjadi "Selesai" dan di database akan berubah menjadi "Selesai".


informasi tambahan:
1. saya sudah membuat database dengan nama db_pbo dan tabel nya dengan nama tb_pesanan.
2. dalam tb_pesanan terdapat 10 kolom, yaitu, id_pemesan,Nama_Pemesan,No_Telp, Jenis_product,Alamat,Jumlah,Jenis_Pembayaran,Tanggal,Status,Rating.
3. semua kode sudah berfungsi dengan baik, saya hanya ingin menambah fitur saja yaitu terdapat pada permasalahan saya diatas
*/