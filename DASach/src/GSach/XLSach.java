/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GSach;

import java.sql.*;

/**
 *
 * @author binh
 */
public class XLSach implements ISach {

    private Connection cn;

    @Override
    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TEST;encrypt=true;trustServerCertificate=true";
            cn = DriverManager.getConnection(url, "sa", "123456789");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }

    @Override
    public ResultSet getSA(Connection cn) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Sach";
            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    @Override
    public ResultSet getSAbyNXBGB(Connection cn, String NhaXB, int NamXB) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Sach WHERE NhaXB = ? AND NamXB = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, NhaXB);
            ps.setInt(2, NamXB);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

}
