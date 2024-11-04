/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QLNN;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author binh
 */
public class GUI_Language extends javax.swing.JFrame {

    private XLNN xlnn = new XLNN();
    private Connection cn = xlnn.getCon();

    /**
     * Creates new form GUI_Language
     */
    public GUI_Language() {
        initComponents();
        LoadBang();
    }

    public void LoadBang() {
        try {
            ClearText();
            String[] columns = {};
            ResultSet rs = null;
            String table = cbx_Type.getSelectedItem().toString();
            rs = xlnn.getLang(cn, table);
            if (cbx_Type.getSelectedIndex() == 0) {
                lbl_Other.setText("Jdk version");
                columns = new String[]{"ID", "Name", "Release year", "Author", "Usage", "Jdk version"};
            } else {
                lbl_Other.setText("Dynamic typed");
                columns = new String[]{"ID", "Name", "Release year", "Author", "Usage", "Dynamic typed"};
            }
            DefaultTableModel model = new DefaultTableModel(columns, 0);
            while (rs.next()) {
                if (cbx_Type.getSelectedIndex() == 0) {
                    JavaLanguage javaLanguage = new JavaLanguage(rs.getString(6), rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                    Object[] row = {
                        javaLanguage.getID(),
                        javaLanguage.getName(),
                        javaLanguage.getRealeaseYear(),
                        javaLanguage.getAuthor(),
                        javaLanguage.getUsage(),
                        javaLanguage.getJdkVersion()
                    };
                    model.addRow(row);
                } else {
                    PythonLanguage pythonLanguage = new PythonLanguage(rs.getBoolean(6), rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                    Object[] row = {
                        pythonLanguage.getID(),
                        pythonLanguage.getName(),
                        pythonLanguage.getRealeaseYear(),
                        pythonLanguage.getAuthor(),
                        pythonLanguage.getUsage(),
                        pythonLanguage.getDynamicTyped()
                    };
                    model.addRow(row);
                }
            }
            tbl_NgonNgu.setModel(model);

            tbl_NgonNgu.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = tbl_NgonNgu.getSelectedRow();
                        if (selectedRow != -1) {
                            tf_ID.setText(tbl_NgonNgu.getValueAt(selectedRow, 0).toString().trim());
                            tf_Name.setText(tbl_NgonNgu.getValueAt(selectedRow, 1).toString().trim());
                            tf_ReleaseYear.setText(tbl_NgonNgu.getValueAt(selectedRow, 2).toString().trim());
                            tf_Author.setText(tbl_NgonNgu.getValueAt(selectedRow, 3).toString().trim());
                            tf_Usage.setText(tbl_NgonNgu.getValueAt(selectedRow, 4).toString().trim());
                            tf_Other.setText(tbl_NgonNgu.getValueAt(selectedRow, 5).toString().trim());
                        }
                    }
                }
            });
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Language.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Them() {
       try {
            String table = cbx_Type.getSelectedIndex() == 0 ? "Java" : "Pyhon";
            int ID = Integer.parseInt(tf_ID.getText().trim());
            String Name = tf_Name.getText().trim();
            int ReleaseYear = Integer.parseInt(tf_ReleaseYear.getText().trim());
            String Author = tf_Author.getText().trim();
            String Usage = tf_Usage.getText().trim();
            String Other = tf_Other.getText().trim();
            if (!Name.isEmpty() && ReleaseYear > 0 && !Author.isEmpty() && !Usage.isEmpty() && !Other.isEmpty()) {
                xlnn.insertLang(cn, table, ID, Name, ReleaseYear, Author, Usage, Other);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thông tin nhập vào không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(rootPane, "ID hoặc Release year phải là số!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void Xoa() {
        String table = cbx_Type.getSelectedIndex() == 0 ? "Java" : "Pyhon";
        int ID = Integer.parseInt(tf_ID.getText().trim());
        xlnn.deleteLang(cn, table, ID);
    }

    public void Sua() {
        try {
            String table = cbx_Type.getSelectedIndex() == 0 ? "Java" : "Pyhon";
            int ID = Integer.parseInt(tf_ID.getText().trim());
            String Name = tf_Name.getText().trim();
            int ReleaseYear = Integer.parseInt(tf_ReleaseYear.getText().trim());
            String Author = tf_Author.getText().trim();
            String Usage = tf_Usage.getText().trim();
            String Other = tf_Other.getText().trim();
            if (!Name.isEmpty() && ReleaseYear > 0 && !Author.isEmpty() && !Usage.isEmpty() && !Other.isEmpty()) {
                xlnn.updateLang(cn, table, ID, Name, ReleaseYear, Author, Usage, Other);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thông tin nhập vào không hợp lệ!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(rootPane, "ID hoặc Release year phải là số!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ClearText() {
        tf_ID.setText(null);
        tf_Name.setText(null);
        tf_ReleaseYear.setText(null);
        tf_Author.setText(null);
        tf_Usage.setText(null);
        tf_Other.setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tf_ID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf_Name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tf_ReleaseYear = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tf_Author = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf_Usage = new javax.swing.JTextField();
        lbl_Other = new javax.swing.JLabel();
        tf_Other = new javax.swing.JTextField();
        cbx_Type = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NgonNgu = new javax.swing.JTable();
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("ID");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Release year");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Author");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Usage");

        lbl_Other.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_Other.setText("JDK Version");

        cbx_Type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Java", "Python" }));
        cbx_Type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_TypeActionPerformed(evt);
            }
        });

        tbl_NgonNgu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_NgonNgu.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbl_NgonNgu.setShowHorizontalLines(true);
        tbl_NgonNgu.setShowVerticalLines(true);
        jScrollPane1.setViewportView(tbl_NgonNgu);

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_ID)
                    .addComponent(tf_Name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_Type, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_ReleaseYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(228, 228, 228)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Them)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Xoa)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Sua)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_Other, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_Author, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(tf_Usage, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(tf_Other, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Author, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Usage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_ReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_Other, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_Other, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_Type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Them)
                    .addComponent(btn_Xoa)
                    .addComponent(btn_Sua))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbx_TypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_TypeActionPerformed
        LoadBang();
    }//GEN-LAST:event_cbx_TypeActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        int selectedRow = tbl_NgonNgu.getSelectedRowCount();
        if (selectedRow < 1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để xóa", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Xoa();
            JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "", JOptionPane.INFORMATION_MESSAGE);
            LoadBang();
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        int selectedRow = tbl_NgonNgu.getSelectedRowCount();
        if (selectedRow < 1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng để sửa", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Sua();
            JOptionPane.showMessageDialog(rootPane, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
            LoadBang();
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        Them();
        LoadBang();
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
            java.util.logging.Logger.getLogger(GUI_Language.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Language.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Language.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Language.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Language().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbx_Type;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Other;
    private javax.swing.JTable tbl_NgonNgu;
    private javax.swing.JTextField tf_Author;
    private javax.swing.JTextField tf_ID;
    private javax.swing.JTextField tf_Name;
    private javax.swing.JTextField tf_Other;
    private javax.swing.JTextField tf_ReleaseYear;
    private javax.swing.JTextField tf_Usage;
    // End of variables declaration//GEN-END:variables
}
