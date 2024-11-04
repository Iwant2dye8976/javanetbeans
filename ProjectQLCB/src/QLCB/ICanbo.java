package QLCB;

import java.sql.*;
public interface ICanbo {
    public Connection getCon();
    public void insertCB(Connection cn, String SoTK, String Hoten, Boolean GT, String Diachi, int Luong);
}
