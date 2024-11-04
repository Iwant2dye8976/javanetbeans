package QLCB;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import javax.swing.JOptionPane;

public class QLCB implements ICanbo {

    private Connection cn;

    public QLCB() {
    }

    @Override
    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TEST;encrypt=true;trustServerCertificate=true";
            cn = DriverManager.getConnection(url, "sa", "123456789");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLCB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QLCB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    @Override
    public void insertCB(Connection cn ,String SoTK, String Hoten, Boolean GT, String Diachi, int Luong) {
        try {
            String sql = "INSERT INTO CanBo VALUES (?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, SoTK);
            ps.setString(2, Hoten);
            ps.setBoolean(3, GT);
            ps.setString(4, Diachi);
            ps.setInt(5, Luong);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công!", null, JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Xảy ra lỗi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(QLCB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
