/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package datawarehouse;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException; 

/**
 *
 * @author user
 */
public class Tabel_Fakta extends javax.swing.JFrame {
    public static Connection con = null; 
    public static Statement st = null; 
    public static Statement st2 = null; 
    public static ResultSet rs;
    
    //BARANG 
    public static String nama_barang_cabang1;
    public static String stok_barang_cabang1;
    public static String satuan_cabang1;
    public static String harga_jual_cabang1;
    public static String harga_beli_cabang1; 
    
    //WAKTU 
    public static String tahun;
    public static String bulan;
    public static String tanggal; 
    
    //MEKANIK
    public static String nama_mekanik;
    public static String alamat_mekanik;
    public static String no_telp_mekanik;
    
    //CABANG
    public static String nama_cabang;
    public static String alamat_cabang;
    public static String telp_cabang;
    
    //PELANGGAN
    public static String nama_pelanggan;
    public static String alamat_pelanggan;
    public static String no_telp_pelanggan;
    
    //SERVICE
    public static String jenis_service;
    public static String harga_service;
    
    //FAKTA
    public static String id_waktu;
    public static String id_pelanggan;
    public static String id_mekanik; 
    public static String id_service;
    public static String id_barang;
    public static String jumlah_barang;
    public static String jumlah_service;
    
    DefaultTableModel tb;
    /**
     * Creates new form Tabel_Fakta
     */
    public Tabel_Fakta() {
        initComponents();
        setLocationRelativeTo(null);
        koneksimysql();
        koneksimysql2();
        tampiltabel();  
    }
    public void koneksimysql(){//DATAWAREHOUSE
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
            st = con.createStatement();  
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Connection Failed!");
        }
    }
    public void koneksimysql2(){//DATABASE1
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_bengkel_asikgen_otomotif", "root", "");
            st2 = con.createStatement();  
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Connection Failed!");
        }
    }
    
    public void tampiltabel(){
        DefaultTableModel tb = new DefaultTableModel();
        tb.addColumn("ID_FAKTA_PENJUALAN");
        tb.addColumn("ID_PELANGGAN");
        tb.addColumn("ID_WAKTU");
        tb.addColumn("ID_BARANG");
        tb.addColumn("ID_SERVICE");
        tb.addColumn("ID_CABANG");
        tb.addColumn("JUMLAH_SERVICE");
        tb.addColumn("JUMLAH_BARANG");
        tb.addColumn("TOTAL_PENJUALAN");
        tableOrder.setModel(tb); 
        try{
            String sql = ("select * from fakta_penjualan;");
            rs = st.executeQuery(sql);
            while (rs.next()){
                tb.addRow(new Object[]{
                    rs.getString("ID_FAKTA_PENJUALAN"),
                    rs.getString("ID_PELANGGAN"),
                    rs.getString("ID_WAKTU"), 
                    rs.getString("ID_BARANG"),
                    rs.getString("ID_MEKANIK"),
                    rs.getString("ID_SERVICE"),
                    rs.getString("ID_CABANG"), 
                    rs.getString("JUMLAH_SERVICE"),
                    rs.getString("JUMLAH_BARANG"), 
                    rs.getString("TOTAL_PENJUALAN")
                });   
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data! " +e.getMessage());
        }
    }
    
    public void insert_barang(){
        //EXTRACT
        try{
            String sql = ("select NAMA_BARANG,STOK,SATUAN,HARGA_BELI,HARGA_JUAL " +
                " from barang join detail_jual_barang" +
                " on detail_jual_barang.ID_BARANG=barang.ID_BARANG" +
                " join penjualan" +
                " on detail_jual_barang.ID_PENJUALAN=penjualan.ID_PENJUALAN");
            rs = st2.executeQuery(sql);
            while (rs.next()){
                nama_barang_cabang1= rs.getString(1);
                stok_barang_cabang1=rs.getString(2);
                satuan_cabang1=rs.getString(3);
                harga_jual_cabang1=rs.getString(4);
                harga_beli_cabang1=rs.getString(5);
                //TRANSFORM
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
                    con.createStatement().executeUpdate("insert into DIMENSI_BARANG (NAMA_BARANG,STOK_BARANG,SATUAN,HARGA_JUAL,HARGA_BELI)"
                        + " values('"+nama_barang_cabang1+"','"+stok_barang_cabang1+"','"+satuan_cabang1+"', '"+harga_jual_cabang1+"','"+harga_beli_cabang1+"');");
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Failed to insert data" +e.getMessage());
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failedd to show data" +e.getMessage());
        }
    
    }
    
    public void insert_pelanggan(){
    //EXTRACT
        try{
            String sql = ("SELECT `NAMA_PELANGGAN`,ALAMAT_PELANGGAN, `NO_TELP_PELANGGAN` " +
"FROM `pelanggan` JOIN `penjualan` " +
"ON `pelanggan`.`ID_PELANGGAN`=penjualan.`ID_PELANGGAN`;");
            rs = st2.executeQuery(sql);
            while (rs.next()){
                nama_pelanggan= rs.getString(1);
                alamat_pelanggan=rs.getString(2);
                no_telp_pelanggan=rs.getString(3);
                //TRANSFORM
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
                    con.createStatement().executeUpdate("insert into DIMENSI_PELANGGAN (NAMA_PELANGGAN,ALAMAT_PELANGGAN,TELP_PELANGGAN)"
                        + " values('"+nama_pelanggan+"','"+alamat_pelanggan+"','"+no_telp_pelanggan+"');");
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Failed to insert data" +e.getMessage());
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
        }
    }

    public void insert_mekanik(){
    //EXTRACT
        try{
            String sql = (" SELECT `NAMA_MEKANIK`,`ALAMAT_MEKANIK`,`TELP_MEKANIK` " +
" from `mekanik` join service " +
" on mekanik.`ID_MEKANIK`=service.`ID_MEKANIK` " +
" join `detail_jual_service` " +
" on `service`.`ID_SERVICE`=`detail_jual_service`.`ID_SERVICE` " +
" join `penjualan` " +
" on `detail_jual_service`.`ID_PENJUALAN`=`penjualan`.`ID_PENJUALAN`;");
            rs = st2.executeQuery(sql);
            while (rs.next()){
                nama_mekanik= rs.getString(1);
                alamat_mekanik=rs.getString(2);
                no_telp_mekanik=rs.getString(3);
                //TRANSFORM
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
                    con.createStatement().executeUpdate("insert into DIMENSI_MEKANIK (NAMA_MEKANIK,ALAMAT_MEKANIK,TELP_MEKANIK)"
                        + " values('"+nama_mekanik+"','"+alamat_mekanik+"','"+no_telp_mekanik+"');");
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Failed to insert data" +e.getMessage());
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
        }
    }
    
     public void insert_service(){
    //EXTRACT
        try{
            String sql = ("select nama_service,harga_service from jenis_service "
                    + "join service on jenis_service.id_jenis_service=service.id_jenis_service "
                    + "join detail_jual_service on service.id_service=detail_jual_service.id_service "
                    + "join penjualan on detail_jual_service.id_penjualan=penjualan.id_penjualan;");
            rs = st2.executeQuery(sql);
            while (rs.next()){
                jenis_service= rs.getString(1);
                harga_service=rs.getString(2);
                //TRANSFORM
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
                    con.createStatement().executeUpdate("insert into DIMENSI_SERVICE (NAMA_SERVICE,HARGA_SERVICE)"
                        + " values('"+jenis_service+"','"+harga_service+"');");
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Failed to insert data" +e.getMessage());
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
        }
    }
     
    public void insert_cabang(){
    //EXTRACT
        try{
            String sql = ("select cabang.`ID_CABANG`,`ALAMAT_CABANG`,`TELP_CABANG` " +
" from `cabang` join penjualan " +
" on `cabang`.`ID_CABANG`=penjualan.`ID_CABANG`; ");
            rs = st2.executeQuery(sql);
            while (rs.next()){
                nama_cabang= rs.getString(1);
                alamat_cabang=rs.getString(2);
                telp_cabang=rs.getString(3);
                //TRANSFORM
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
                    con.createStatement().executeUpdate("insert into DIMENSI_CABANG (NAMA_CABANG,ALAMAT_CABANG,TELP_CABANG) "
                        + " values('"+nama_cabang+"','"+alamat_cabang+"','"+telp_cabang+"');");
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Failed to insert data" +e.getMessage());
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOrder = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ETLButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        TReport3 = new javax.swing.JLabel();
        TReport4 = new javax.swing.JLabel();
        TReport5 = new javax.swing.JLabel();
        TReport6 = new javax.swing.JLabel();
        TReport7 = new javax.swing.JLabel();
        TReport8 = new javax.swing.JLabel();
        TReport9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(730, 430));
        jPanel1.setPreferredSize(new java.awt.Dimension(750, 400));

        tableOrder.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 12)); // NOI18N
        tableOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(tableOrder);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 18)); // NOI18N
        jLabel1.setText("x");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        ETLButton.setBackground(new java.awt.Color(255, 255, 255));
        ETLButton.setFont(new java.awt.Font("Mermaid", 0, 14)); // NOI18N
        ETLButton.setText("ETL");
        ETLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ETLButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        TReport3.setBackground(new java.awt.Color(255, 255, 255));
        TReport3.setFont(new java.awt.Font("Mermaid", 0, 14)); // NOI18N
        TReport3.setForeground(new java.awt.Color(255, 255, 255));
        TReport3.setText("<html>Dimensi<br>Barang");
        TReport3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TReport3MouseClicked(evt);
            }
        });

        TReport4.setBackground(new java.awt.Color(255, 255, 255));
        TReport4.setFont(new java.awt.Font("Mermaid", 0, 14)); // NOI18N
        TReport4.setForeground(new java.awt.Color(255, 255, 255));
        TReport4.setText("<html>Dimensi<br>Mekanik");
        TReport4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TReport4MouseClicked(evt);
            }
        });

        TReport5.setBackground(new java.awt.Color(255, 255, 255));
        TReport5.setFont(new java.awt.Font("Mermaid", 0, 14)); // NOI18N
        TReport5.setForeground(new java.awt.Color(255, 255, 255));
        TReport5.setText("<html>Dimensi<br>Pelanggan");
        TReport5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TReport5MouseClicked(evt);
            }
        });

        TReport6.setBackground(new java.awt.Color(255, 255, 255));
        TReport6.setFont(new java.awt.Font("Mermaid", 0, 14)); // NOI18N
        TReport6.setForeground(new java.awt.Color(255, 255, 255));
        TReport6.setText("<html>Dimensi<br>Service");
        TReport6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TReport6MouseClicked(evt);
            }
        });

        TReport7.setBackground(new java.awt.Color(255, 255, 255));
        TReport7.setFont(new java.awt.Font("Mermaid", 0, 14)); // NOI18N
        TReport7.setForeground(new java.awt.Color(255, 255, 255));
        TReport7.setText("<html>Dimensi<br>Cabang");
        TReport7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TReport7MouseClicked(evt);
            }
        });

        TReport8.setBackground(new java.awt.Color(255, 255, 255));
        TReport8.setFont(new java.awt.Font("Mermaid", 0, 14)); // NOI18N
        TReport8.setForeground(new java.awt.Color(255, 255, 255));
        TReport8.setText("<html>Dimensi<br>Waktu");
        TReport8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TReport8MouseClicked(evt);
            }
        });

        TReport9.setBackground(new java.awt.Color(255, 255, 255));
        TReport9.setFont(new java.awt.Font("Mermaid", 0, 14)); // NOI18N
        TReport9.setForeground(new java.awt.Color(204, 204, 204));
        TReport9.setText("<html>Tabel<br>Fakta");
        TReport9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TReport9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TReport5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TReport9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TReport3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TReport4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(TReport6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(TReport7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TReport8))
                        .addGap(43, 43, 43))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TReport9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TReport3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TReport4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TReport5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TReport6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TReport7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TReport8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ETLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ETLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void ETLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ETLButtonActionPerformed
        
        insert_barang();
        insert_pelanggan(); 
        insert_mekanik();
        insert_cabang();
        insert_service();
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
            con.createStatement().executeUpdate(" INSERT INTO `dimensi_waktu` (`TAHUN`,`BULAN`,`TANGGAL`) " +
" VALUES(EXTRACT(YEAR FROM CURRENT_TIMESTAMP), EXTRACT(MONTH FROM CURRENT_TIMESTAMP), EXTRACT(day FROM CURRENT_TIMESTAMP));");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Failed to insert data" +e.getMessage());
        }
        try{
            String sql = ("select count(`ID_SERVICE`) from `detail_jual_service`;");
            rs = st2.executeQuery(sql);
            while (rs.next()){
                jumlah_service= rs.getString(1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
        }
        try{
            String sql = ("SELECT SUM(`TOTAL_BARANG`) FROM `penjualan`; ");
            rs = st2.executeQuery(sql);
            while (rs.next()){
                jumlah_barang= rs.getString(1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
        }
        try{
            String sql = ("SELECT MAX(ID_WAKTU) FROM DIMENSI_WAKTU; ");
            rs = st.executeQuery(sql);
            while (rs.next()){
                id_waktu= rs.getString(1);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
        }
        try{
            String sql = ("SELECT penjualan.`ID_PENJUALAN`,`pelanggan`.`ID_PELANGGAN`,`mekanik`.`ID_MEKANIK`,`service`.`ID_SERVICE`, barang.`ID_BARANG` FROM `pelanggan`  join penjualan " +
"ON `pelanggan`.`ID_PELANGGAN`=penjualan.`ID_PELANGGAN` left join `detail_jual_service`on `detail_jual_service`.`ID_PENJUALAN`=`penjualan`.`ID_PENJUALAN` left join service " +
"on `service`.`ID_SERVICE`=`detail_jual_service`.`ID_SERVICE` left join mekanik on mekanik.`ID_MEKANIK`=service.`ID_MEKANIK`  left join detail_jual_barang " +
"on detail_jual_barang.`ID_PENJUALAN`=penjualan.`ID_PENJUALAN`  left join barang on `detail_jual_barang`.`ID_BARANG`=barang.`ID_BARANG`;");
            rs = st2.executeQuery(sql);
            while (rs.next()){
                id_pelanggan= rs.getString(2);
                id_mekanik= rs.getString(3);
                if (rs.getString(3)==null){
                    id_mekanik="0";
                }
                id_service= rs.getString(4);
                if (rs.getString(4)==null){
                    id_service="0";
                }
                id_barang= rs.getString(5);
                if (rs.getString(5)==null){
                    id_barang="0";
                }
               
                //TRANSFORM
                
                try{
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
                    con.createStatement().executeUpdate("INSERT INTO `fakta_penjualan`(`ID_PELANGGAN`,`ID_MEKANIK`,`ID_WAKTU`,`ID_BARANG`,`ID_SERVICE`,`ID_CABANG`,`JUMLAH_SERVICE`,`JUMLAH_BARANG`)"
                        + " values('"+id_pelanggan+"','"+id_mekanik+"','"+id_waktu+"','"+id_barang+"','"+id_service+"','"+nama_cabang+"','"+jumlah_service+"','"+jumlah_barang+"');");
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null,"Failed to insert data" +e.getMessage());
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
        }
        
        
        
        
        //CLEANING NANTIAN 
//        try{
//            String sql = ("TRUNCATE TABLE `detail_jual_barang`;delete from penjualan where id_cabang=1;");
//            rs = st2.executeQuery(sql);
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,"Failed to show data" +e.getMessage());
//        }
        
        
        //LOAD
        tampiltabel();

    }//GEN-LAST:event_ETLButtonActionPerformed

    private void TReport3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport3MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Barang().setVisible(true);
    }//GEN-LAST:event_TReport3MouseClicked

    private void TReport9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport9MouseClicked
        // TODO add your handling code here:
        dispose();
        new Tabel_Fakta().setVisible(true);
    }//GEN-LAST:event_TReport9MouseClicked

    private void TReport4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport4MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Mekanik().setVisible(true);
    }//GEN-LAST:event_TReport4MouseClicked

    private void TReport5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport5MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Pelanggan().setVisible(true);
    }//GEN-LAST:event_TReport5MouseClicked

    private void TReport8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport8MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Waktu().setVisible(true);
    }//GEN-LAST:event_TReport8MouseClicked

    private void TReport7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport7MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Cabang().setVisible(true);
    }//GEN-LAST:event_TReport7MouseClicked

    private void TReport6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport6MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Service().setVisible(true);
    }//GEN-LAST:event_TReport6MouseClicked

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
            java.util.logging.Logger.getLogger(Tabel_Fakta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabel_Fakta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabel_Fakta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabel_Fakta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabel_Fakta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ETLButton;
    private javax.swing.JLabel TReport3;
    private javax.swing.JLabel TReport4;
    private javax.swing.JLabel TReport5;
    private javax.swing.JLabel TReport6;
    private javax.swing.JLabel TReport7;
    private javax.swing.JLabel TReport8;
    private javax.swing.JLabel TReport9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableOrder;
    // End of variables declaration//GEN-END:variables
}
