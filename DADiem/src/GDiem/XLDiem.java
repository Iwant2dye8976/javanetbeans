package GDiem;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XLDiem implements IHocvien {

    private Connection cn;

    public XLDiem() {
    }
    
    @Override
    public Connection getCon() {
        try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TEST;encrypt=true;trustServerCertificate=true";
            cn = DriverManager.getConnection(url, "sa", "123456789");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(XLDiem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(XLDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cn;
    }

    @Override
    public ResultSet getHVbyLop(String Lop) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM HocVien WHERE LOP = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, Lop);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(XLDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    @Override
    public ResultSet getHVbyLopGT(String Lop, Boolean GT) {
         ResultSet rs = null;
        try {
            String sql = "SELECT * FROM HocVien WHERE LOP = ? AND GT = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, Lop);
            ps.setBoolean(2, GT);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(XLDiem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
