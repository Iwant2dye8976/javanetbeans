/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package GSach;
import java.sql.*;
/**
 *
 * @author binh
 */
public interface ISach {
    public Connection getCon();
    public ResultSet getSA(Connection cn);
    public ResultSet getSAbyNXBGB(Connection cn, String NhaXB, int NamXB);
}
