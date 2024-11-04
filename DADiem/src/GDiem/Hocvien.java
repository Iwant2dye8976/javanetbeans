package GDiem;

import java.sql.Connection;
import java.sql.ResultSet;

public class Hocvien{

    private String MaHV, Hoten, Lop;
    private Boolean GT;
    private float Diem;

    public Hocvien() {
    }

    public Hocvien(String MaHV, String Hoten, String Lop, Boolean GT, float Diem) {
        this.MaHV = MaHV;
        this.Hoten = Hoten;
        this.Lop = Lop;
        this.GT = GT;
        this.Diem = Diem;
    }

    public String Ketqua(float Diem) {
        if (Diem >= 20) {
            return "Đỗ";
        } else {
            return "Trượt";
        }
    }

    public String getMaHV() {
        return MaHV;
    }

    public String getHoten() {
        return Hoten;
    }

    public String getLop() {
        return Lop;
    }

    public Boolean getGT() {
        return GT;
    }

    public float getDiem() {
        return Diem;
    }

    public void setMaHV(String MaHV) {
        this.MaHV = MaHV;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setLop(String Lop) {
        this.Lop = Lop;
    }

    public void setGT(Boolean GT) {
        this.GT = GT;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }
}
