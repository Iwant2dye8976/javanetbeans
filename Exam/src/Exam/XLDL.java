/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exam;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;

/**
 *
 * @author binh
 */
public class XLDL implements IXLDL {

    private Connection cn;

    @Override
    public Connection getCon() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=TEST;encrypt=true;trustServerCertificate=true";
            cn = DriverManager.getConnection(url, "sa", "123456789");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cn;
    }

    @Override
    public ResultSet getCylinder(Connection cn) {
        ResultSet rs = null;
        try {
            String sql = "SELECT * FROM Cylinder";
            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    @Override
    public void insertCylinder(Connection cn, String ID, float Radius, float Height, String Color) {
        try {
            String sql = "INSERT INTO Cylinder VALUES(?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, ID);
            ps.setFloat(2, Radius);
            ps.setFloat(3, Height);
            ps.setString(4, Color);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
