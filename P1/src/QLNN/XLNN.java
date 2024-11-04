/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLNN;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author binh
 */
public class XLNN implements IXLNN {

    private Connection cn;

    @Override
    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=Language;encrypt=true;trustServerCertificate=true";
            cn = DriverManager.getConnection(url, "sa", "123456789");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi kết nối CSDL!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return cn;
    }

    @Override
    public ResultSet getLang(Connection cn, String table) {
        ResultSet rs = null;
        try {
            String tableName = table.contains("Java") ? "JavaLanguage" : "PythonLanguage";
            String sql = "SELECT * FROM " + tableName;

            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi load NN!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    @Override
    public void insertLang(Connection cn, String table, int ID, String Name, int ReleaseYear, String Author, String Usage, String Other) {
        try {
            String tablename = table.contains("Java") ? "JavaLanguage" : "PythonLanguage";
            String sql = "INSERT INTO " + tablename + " VALUES(?,?,?,?,?,?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.setString(2, Name);
            ps.setInt(3, ReleaseYear);
            ps.setString(4, Author);
            ps.setString(5, Usage);
            if (table.contains("Java")) {
                ps.setString(6, Other);
            } else {
                ps.setBoolean(6, Other.equalsIgnoreCase("yes"));
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm NN!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteLang(Connection cn, String table, int ID) {
        try {
            String tablename = table.contains("Java") ? "JavaLanguage" : "PythonLanguage";
            String sql = "DELETE FROM " + tablename + " WHERE ID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi load NN!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void updateLang(Connection cn, String table, int ID, String Name, int ReleaseYear, String Author, String Usage, String Other) {
        try {
            String tablename = table.contains("Java") ? "JavaLanguage" : "PythonLanguage";
            String sql = "UPDATE " + tablename + " SET Name = ?, ReleaseYear = ?, Author = ?, Usage = ?, ";
            PreparedStatement ps;
            if (table.contains("Java")) {
                sql += "JdkVersion = ? WHERE ID = ?";
                ps = cn.prepareStatement(sql);
                ps.setInt(6, ID);
                ps.setString(1, Name);
                ps.setInt(2, ReleaseYear);
                ps.setString(3, Author);
                ps.setString(4, Usage);
                ps.setString(5, Other);
            } else {
                sql += "DynamicTyped = ? WHERE ID = ?";
                ps = cn.prepareStatement(sql);
                ps.setInt(6, ID);
                ps.setString(1, Name);
                ps.setInt(2, ReleaseYear);
                ps.setString(3, Author);
                ps.setString(4, Usage);
                ps.setBoolean(5, Other.equalsIgnoreCase("true"));
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi load NN!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public ResultSet findLang(Connection cn, String table, int ID) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM ? WHERE ID = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, table);
            ps.setInt(2, ID);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi load NN!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
}
