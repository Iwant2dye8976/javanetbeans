package GDiem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GUI_findHV extends javax.swing.JFrame {

    private XLDiem xlDiem = new XLDiem();

    /**
     * Creates new form GUI_findHV
     */
    public GUI_findHV() {
        initComponents();
        rb_GTNam.setEnabled(false);
        rb_GTNu.setEnabled(false);
    }

    public void LoadBang() throws SQLException {
        Connection cn = xlDiem.getCon();
        ResultSet rs = null;
        String[] columns = {"Mã học viên", "Họ tên", "Lớp", "Giới tính", "Điểm", "Kết quả"};
        if (!rb_GTNam.isEnabled() && !rb_GTNu.isEnabled()) {
            String Lop = Cbbx_Lop.getSelectedItem().toString().trim();
            rs = xlDiem.getHVbyLop(Lop);
        } else {
            String Lop = Cbbx_Lop.getSelectedItem().toString().trim();
            Boolean GT = rb_GTNam.isSelected() ? true : rb_GTNu.isSelected() ? false : null;
            rs = xlDiem.getHVbyLopGT(Lop, GT);
        }
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        while (rs.next()) {
            Hocvien hv = new Hocvien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getFloat(5));
            String KQ = hv.Ketqua(rs.getFloat(5));
            Object[] row = {
                rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4) ? "Nam" : "Nữ", rs.getFloat(5), KQ
            };
            model.addRow(row);
        }
        Data_tbl.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        Cbbx_Lop = new javax.swing.JComboBox<>();
        rb_GTNam = new javax.swing.JRadioButton();
        rb_GTNu = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Data_tbl = new javax.swing.JTable();
        btn_find = new javax.swing.JButton();
        cbx_GT = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quan Ly Diem");
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lớp");

        Cbbx_Lop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "63PM1", "63PM2", "63TH1", "63TH2" }));

        buttonGroup1.add(rb_GTNam);
        rb_GTNam.setText("Nam");

        buttonGroup1.add(rb_GTNu);
        rb_GTNu.setText("Nữ");

        Data_tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Data_tbl);

        btn_find.setText("Tìm");
        btn_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findActionPerformed(evt);
            }
        });

        cbx_GT.setText("Giới tính");
        cbx_GT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_GTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Cbbx_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbx_GT)
                .addGap(18, 18, 18)
                .addComponent(rb_GTNam, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rb_GTNu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addComponent(btn_find)
                .addGap(380, 380, 380))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cbbx_Lop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_GTNam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_GTNu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_GT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btn_find)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findActionPerformed
        try {
            LoadBang();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Lỗi khi tải dữ liệu", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_findActionPerformed

    private void cbx_GTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_GTActionPerformed
        boolean isSelected = cbx_GT.isSelected();
        rb_GTNam.setEnabled(isSelected);
        rb_GTNu.setEnabled(isSelected);
        if (isSelected) {
            rb_GTNam.setSelected(true);
        } else {
            buttonGroup1.clearSelection();
        }
    }//GEN-LAST:event_cbx_GTActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_findHV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_findHV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_findHV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_findHV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_findHV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Cbbx_Lop;
    private javax.swing.JTable Data_tbl;
    private javax.swing.JButton btn_find;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cbx_GT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rb_GTNam;
    private javax.swing.JRadioButton rb_GTNu;
    // End of variables declaration//GEN-END:variables
}
