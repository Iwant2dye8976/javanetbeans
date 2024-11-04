/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package QLNN;
import java.sql.*;
/**
 *
 * @author binh
 */
public interface IXLNN {
    public Connection getCon();
    public ResultSet getLang(Connection cn, String table);
    public void insertLang(Connection cn, String table, int ID, String Name, int ReleaseYear, String Author, String Usage, String other);
    public void deleteLang(Connection cn, String table, int ID);
    public void updateLang(Connection cn, String table, int ID, String Name, int ReleaseYear, String Author, String Usage, String other);
    public ResultSet findLang(Connection cn, String table, int ID);
}
