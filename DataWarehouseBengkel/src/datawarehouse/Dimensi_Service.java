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
public class Dimensi_Service extends javax.swing.JFrame {
    public static Connection con = null; 
    public static Statement st = null; 
    public static Statement st2 = null; 
    public static ResultSet rs;
    DefaultTableModel tb;
    /**
     * Creates new form Dimensi_Service
     */
    public Dimensi_Service() {
        initComponents();
        setLocationRelativeTo(null);
        koneksimysql();
        koneksimysql2();
        tampiltabel();   
    }

    public void koneksimysql(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/datawarehouse_bengkel_asikgen_otomotif", "root", "");
            st = con.createStatement();  
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Connection Failed!");
        }
    }
        public void koneksimysql2(){
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
        tb.addColumn("ID_SERVICE");
        tb.addColumn("JENIS_SERVICE");
        tb.addColumn("HARGA_SERVICE");
        tableOrder.setModel(tb); 
        try{
            String sql = ("select * from dimensi_SERVICE;");
            rs = st.executeQuery(sql);
            while (rs.next()){
                tb.addRow(new Object[]{
                    rs.getString("ID_SERVICE"),
                    rs.getString("JENIS_SERVICE"),
                    rs.getString("HARGA_SERVICE")
                });   
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Failed to show data! " +e.getMessage());
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
        jPanel2 = new javax.swing.JPanel();
        TReport3 = new javax.swing.JLabel();
        TReport4 = new javax.swing.JLabel();
        TReport5 = new javax.swing.JLabel();
        TReport6 = new javax.swing.JLabel();
        TReport7 = new javax.swing.JLabel();
        TReport8 = new javax.swing.JLabel();
        TReport9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        TReport6.setForeground(new java.awt.Color(204, 204, 204));
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
        TReport9.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(46, Short.MAX_VALUE)
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(69, 69, 69))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void TReport3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport3MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Barang().setVisible(true);
    }//GEN-LAST:event_TReport3MouseClicked

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

    private void TReport6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport6MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Service().setVisible(true);
    }//GEN-LAST:event_TReport6MouseClicked

    private void TReport7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport7MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Cabang().setVisible(true);
    }//GEN-LAST:event_TReport7MouseClicked

    private void TReport8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport8MouseClicked
        // TODO add your handling code here:
        dispose();
        new Dimensi_Waktu().setVisible(true);
    }//GEN-LAST:event_TReport8MouseClicked

    private void TReport9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TReport9MouseClicked
        // TODO add your handling code here:
        dispose();
        new Tabel_Fakta().setVisible(true);
    }//GEN-LAST:event_TReport9MouseClicked

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
            java.util.logging.Logger.getLogger(Dimensi_Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dimensi_Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dimensi_Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dimensi_Service.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dimensi_Service().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
