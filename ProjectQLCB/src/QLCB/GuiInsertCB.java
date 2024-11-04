package QLCB;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GuiInsertCB extends javax.swing.JFrame {

    /**
     * Creates new form GuiInsertCB
     */
    public GuiInsertCB() {
        initComponents();
        LoadBang();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void LoadBang() {
        QLCB qlcb = new QLCB();
        Connection cn = qlcb.getCon();
        String sql = "SELECT * FROM CanBo";
        String[] columns = {"Số tài khoản", "Họ tên", "Giới tính", "Địa chỉ", "Lương"};
        ResultSet rs;
        try {
            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            while (rs.next()) {
                Canbo cb = new Canbo(rs.getString(1), rs.getString(2), rs.getString(4), rs.getBoolean(3), rs.getInt(5));
                Object[] row = {
                    cb.getSoTk(),
                    cb.getHoten(),
                    cb.getGT() ? "Nam" : "Nữ",
                    cb.getDiachi(),
                    cb.getLuong()
                };
                model.addRow(row);
            }
            tbl_Canbo.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(GuiInsertCB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_GT = new javax.swing.ButtonGroup();
        pm_Test = new javax.swing.JPopupMenu();
        M1 = new javax.swing.JMenuItem();
        M2 = new javax.swing.JMenuItem();
        M3 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        tf_SoTK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_Hoten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_Luong = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_Diachi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Canbo = new javax.swing.JTable();
        rb_GTNu = new javax.swing.JRadioButton();
        rb_GTNam = new javax.swing.JRadioButton();
        btn_Them = new javax.swing.JButton();

        M1.setText("M1");
        pm_Test.add(M1);

        M2.setText("M2");
        pm_Test.add(M2);

        M3.setText("M3");
        pm_Test.add(M3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Số tài khoản");
        jLabel1.setToolTipText("");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Họ tên");
        jLabel2.setToolTipText("");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Giới tính");
        jLabel3.setToolTipText("");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lương");
        jLabel4.setToolTipText("");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Địa chỉ");
        jLabel5.setToolTipText("");

        tbl_Canbo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_Canbo.setComponentPopupMenu(pm_Test);
        jScrollPane1.setViewportView(tbl_Canbo);

        bg_GT.add(rb_GTNu);
        rb_GTNu.setText("Nữ");

        bg_GT.add(rb_GTNam);
        rb_GTNam.setSelected(true);
        rb_GTNam.setText("Nam");

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(tf_SoTK))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rb_GTNam)
                                .addGap(18, 18, 18)
                                .addComponent(rb_GTNu))
                            .addComponent(tf_Hoten, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))))
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(tf_Diachi))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_Luong, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(82, 82, 82))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_SoTK, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Luong, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Hoten, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rb_GTNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rb_GTNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18))
        );

        setSize(new java.awt.Dimension(872, 569));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        QLCB qlcb = new QLCB();
        Connection cn = qlcb.getCon();
        String sql = "INSERT INTO CanBo VALUES(?,?,?,?,?)";
        String SoTK = tf_SoTK.getText().trim();
        String Hoten = tf_Hoten.getText().trim();
        Boolean GT = rb_GTNam.isSelected() ? true : rb_GTNu.isSelected() ? false : null;
        String Diachi = tf_Diachi.getText().trim();
        int Luong = 0;
        try {
            Luong = Integer.parseInt(tf_Luong.getText().trim());
        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "Lương phải là số nguyên!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            tf_Luong.requestFocus();
        }
        if (!SoTK.isEmpty() && !Hoten.isEmpty() && !Diachi.isEmpty() && Luong > 0) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, SoTK);
                ps.setString(2, Hoten);
                ps.setBoolean(3, GT);
                ps.setString(4, Diachi);
                ps.setInt(5, Luong);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công", null, JOptionPane.INFORMATION_MESSAGE);
                LoadBang();
            }
            
            catch (SQLServerException ex) {
                if(ex.getErrorCode() == 2627){
                    JOptionPane.showMessageDialog(rootPane, "Số tài khoản đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    tf_SoTK.requestFocus();
                }
            }
            catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Xảy ra lỗi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Thông tin nhập vào chưa hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

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
            java.util.logging.Logger.getLogger(GuiInsertCB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiInsertCB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiInsertCB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiInsertCB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiInsertCB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem M1;
    private javax.swing.JMenuItem M2;
    private javax.swing.JMenuItem M3;
    private javax.swing.ButtonGroup bg_GT;
    private javax.swing.JButton btn_Them;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu pm_Test;
    private javax.swing.JRadioButton rb_GTNam;
    private javax.swing.JRadioButton rb_GTNu;
    private javax.swing.JTable tbl_Canbo;
    private javax.swing.JTextField tf_Diachi;
    private javax.swing.JTextField tf_Hoten;
    private javax.swing.JTextField tf_Luong;
    private javax.swing.JTextField tf_SoTK;
    // End of variables declaration//GEN-END:variables
}