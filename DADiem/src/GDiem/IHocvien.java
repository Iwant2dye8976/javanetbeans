package GDiem;

import java.sql.*;

public interface IHocvien {

    public Connection getCon();
    public ResultSet getHVbyLop(String Lop);
    public ResultSet getHVbyLopGT(String Lop, Boolean GT);
}
