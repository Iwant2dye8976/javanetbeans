/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Exam;
import java.net.ConnectException;
import java.sql.*;
/**
 *
 * @author binh
 */
public interface IXLDL {
    public Connection getCon();
    public ResultSet getCylinder(Connection cn);
    public void insertCylinder(Connection cn, String ID, float Radius, float Height, String Color);
}
