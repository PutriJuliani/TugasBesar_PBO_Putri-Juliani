
package putriprojek;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class KasirUtama extends Akasir implements IKasir {
     Color defaultColor, ClickedColor;

    String Tanggal;
    private DefaultTableModel model;

    public void totalBiaya() {
        int jumlahBaris = jTable1.getRowCount();
        int totalBiaya = 0;
        int jumlahBarang, hargaBarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahBarang = Integer.parseInt(jTable1.getValueAt(i, 7).toString());
            hargaBarang = Integer.parseInt(jTable1.getValueAt(i, 8).toString());
            totalBiaya = totalBiaya + (jumlahBarang * hargaBarang);
        }
        txtTotalBayar.setText(String.valueOf(totalBiaya));
        txtTampil.setText("Rp " + totalBiaya + ",00");
    }

    private void autonumber() {

        try {

            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM bakery ORDER BY NoFaktur DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                String NoFaktur = r.getString("NoFaktur").substring(2);
                String BKR = "" + (Integer.parseInt(NoFaktur) + 1);
                String Nol = "";

                if (BKR.length() == 1) {
                    Nol = "000";
                } else if (BKR.length() == 2) {
                    Nol = "00";
                } else if (BKR.length() == 3) {
                    Nol = "0";
                } else if (BKR.length() == 4) {
                    Nol = "";
                }
                TxtTransaksi.setText("BKR" + Nol + BKR);
            } else {

                TxtTransaksi.setText("BKR001");
            }
            r.close();
            s.close();

        } catch (Exception e) {
            System.out.println("AutoNumber Eror");

        }

    }
    
      public void dataEntry() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            TxtTransaksi.getText(),
            TxtTanggalPesan.getText(),
            TxtIDBarang.getText(),
            TxtCustomer.getText(),
            TxtNamaBarang.getText(),
            TxtMetodePembayaran.getSelectedItem(),
            TxtOrders.getSelectedItem(),
            txtJumlah.getText(),
            TxtHarga.getText(),
            txtTotalBayar.getText()

        });

    }

    public void kosong() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        while (model.getRowCount() > 0) {
            model.removeRow(0);

        }

    }

    public void utama() {
        TxtTransaksi.setText("");
        TxtTanggalPesan.setText("");
        TxtIDBarang.setText("");
        TxtCustomer.setText("");
        TxtNamaBarang.setText("");
        TxtMetodePembayaran.setSelectedItem("");
        TxtOrders.setSelectedItem("");
        txtJumlah.setText("");
        TxtHarga.setText("");
        autonumber();
    }

    public void setPembayaran() {

  
        TxtIDCustomer.setSelectedItem("");
        txtTotalBayar.setText("0");
        txtBayar.setText("0");
        txtKembalian.setText("0");
        txtTampil.setText("0");

    }

    public void setItem() {
         
        TxtTanggalPesan.setText("");
        TxtIDBarang.setText("");
        TxtCustomer.setText("");
        TxtNamaBarang.setText("");
        TxtMetodePembayaran.setSelectedItem("");
        TxtOrders.setSelectedItem("");
        TxtHarga.setText("");
        txtJumlah.setText("");
        

    }

    public void Transaksi() {
        int jumlah, harga, total;

        jumlah = Integer.valueOf(txtJumlah.getText());
        harga = Integer.valueOf(TxtHarga.getText());
        total = jumlah * harga;

        txtTotalBayar.setText(String.valueOf(total));

        dataEntry();
        totalBiaya();
        setItem();
        TxtIDBarang.requestFocus();

    }
    
   
    public KasirUtama() {
        initComponents();
        
        model = new DefaultTableModel();
        jTable1.setModel(model);

        model.addColumn("No Transaksi");
        model.addColumn("Tanggal Pesan");
        model.addColumn("Id Barang");
        model.addColumn("Customer");
        model.addColumn("Nama Barang");
        model.addColumn("Metode Pembayaran");
        model.addColumn("Orders");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");

        utama();
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        txTanggal.setText(currentDate.format(formatter));
        txtTotalBayar.setText("0");
        txtBayar.setText("0");
        txtKembalian.setText("0");
        TxtIDCustomer.requestFocus();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TxtTransaksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtTanggalPesan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtIDBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtCustomer = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtIDCustomer = new javax.swing.JComboBox<>();
        TxtNamaBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txTanggal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TxtMetodePembayaran = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TxtOrders = new javax.swing.JComboBox<>();
        txtJumlah = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TxtHarga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSimpan = new javax.swing.JButton();
        txtTampil = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTotalBayar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtBayar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtKembalian = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("No Transaksi");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID Customer");

        TxtTanggalPesan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        TxtTanggalPesan.setText("yyy-mm-dd");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Tanggal Pesan");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("ID Barang");

        TxtCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TxtCustomer.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Customer");

        TxtIDCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BA9375", "BA2133" }));
        TxtIDCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIDCustomerActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Nama Barang");

        txTanggal.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tanggal");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Metode Pembayaran");

        TxtMetodePembayaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kredit", "Cash", "Transfer" }));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Orders");

        TxtOrders.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Onnline", "Offline" }));

        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Jumlah");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Harga");

        jButton1.setText("Data Barang");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtIDCustomer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtTanggalPesan)
                            .addComponent(TxtTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(TxtNamaBarang))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtMetodePembayaran, 0, 215, Short.MAX_VALUE)
                                    .addComponent(TxtOrders, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtHarga)
                                    .addComponent(txtJumlah))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TxtIDCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(TxtTanggalPesan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(TxtIDBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TxtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel15)
                                    .addComponent(TxtHarga, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TxtMetodePembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(TxtOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KASIR");

        txtSimpan.setText("Simpan");
        txtSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSimpanActionPerformed(evt);
            }
        });

        txtTampil.setBackground(new java.awt.Color(255, 0, 0));
        txtTampil.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtTampil.setForeground(new java.awt.Color(204, 204, 204));
        txtTampil.setText("RP.0");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total Bayar");

        txtTotalBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Bayar");

        txtBayar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBayarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Kembalian");

        jButton2.setText("HOME");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                            .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(txtSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(txtTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKembalian)
                            .addComponent(txtTotalBayar)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(394, 394, 394))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTotalBayar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTampil, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void TxtIDCustomerActionPerformed(java.awt.event.ActionEvent evt) {                                              
       String Angka,customer = null;
       
       Angka = String.valueOf(TxtIDCustomer.getSelectedItem());
       
       if(Angka.equals("BA9375")){
           customer = "Members";
           
       }else if(Angka.equals("BA2133")){
           customer = "NonMembers";
           
       }
       
       TxtCustomer.setText(customer);
       
    }                                             

    private void txtBayarActionPerformed(java.awt.event.ActionEvent evt) {                                         
         int total, bayar, kembalian;

        total = Integer.valueOf(txtTotalBayar.getText());
        bayar = Integer.valueOf(txtBayar.getText());

        if (total > bayar) {
            JOptionPane.showMessageDialog(null, "Uang tidak cukup untuk melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            txtKembalian.setText(String.valueOf(kembalian));
        }
    }                                        

    private void txtSimpanActionPerformed(java.awt.event.ActionEvent evt) {                                          
          DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        String noTransaksi = TxtTransaksi.getText();
        String noTanggal = txTanggal.getText();
        String Customer = (String) TxtIDCustomer.getSelectedItem();
        String Total = txtTotalBayar.getText();

        try {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO kasirteknik VALUES (?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);

            p.setString(1, noTransaksi);
            p.setString(2, noTanggal);
            p.setString(3, Customer);
            p.setString(4, Total);
            p.executeUpdate();
            p.close();

        } catch (Exception e) {
            System.out.println("Simpan Penjualan Eror");
        }

        try {
            Connection c = Koneksi.getKoneksi();
            int baris = jTable1.getRowCount();

            for (int i = 0; i < baris; i++) {
                String sql = "INSERT INTO pbakery (NoFaktur, Tanggal_Pesan, id_Barang,Customer,NamaBarang,Metode_Pembayaran,Orders, Jumlah, Harga, Total) "
                        + "VALUES ('"
                + jTable1.getValueAt(i, 0) + "','" + jTable1.getValueAt(i, 1) + "','" + jTable1.getValueAt(i, 2) + "','"
                + jTable1.getValueAt(i, 3) + "','" + jTable1.getValueAt(i, 4) + "','" + jTable1.getValueAt(i, 5) + "','" +
                jTable1.getValueAt(i, 6)+ "','" + jTable1.getValueAt(i, 7)+ "','" + jTable1.getValueAt(i, 8)+ 
                        "','" + jTable1.getValueAt(i, 9)+"')";

                PreparedStatement p = c.prepareStatement(sql);
                p.executeUpdate();
                p.close();
            }

        } catch (Exception e) {
            System.out.println("Sistem Penjualan Rinci Eror");
        }
        setPembayaran();
        utama();
        autonumber();
        kosong();
        txtTampil.setText("RP 0");
    }                                         

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Transaksi();
    }                                         

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {                                         
       DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();
        model.removeRow(row);
        totalBiaya();
        txtBayar.setText("0");
        txtKembalian.setText("0");
    }                                        

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Transaksi();
    }                                         

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
       Barang_Masuk M = new Barang_Masuk();
        M.setVisible(true);
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        HomePage home = new HomePage();
    home.setVisible(true);
    home.pack();
    home.setLocationRelativeTo(null);
    this.dispose();
    }                                        

  
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KasirBakery().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField TxtCustomer;
    private javax.swing.JTextField TxtHarga;
    private javax.swing.JTextField TxtIDBarang;
    private javax.swing.JComboBox<String> TxtIDCustomer;
    private javax.swing.JComboBox<String> TxtMetodePembayaran;
    private javax.swing.JTextField TxtNamaBarang;
    private javax.swing.JComboBox<String> TxtOrders;
    private javax.swing.JTextField TxtTanggalPesan;
    private javax.swing.JTextField TxtTransaksi;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txtBayar;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKembalian;
    private javax.swing.JButton txtSimpan;
    private javax.swing.JTextField txtTampil;
    private javax.swing.JTextField txtTotalBayar;
    // End of variables declaration                   
}
