package QLCB;
public class Canbo {
    private String SoTk, Hoten, Diachi;
    private Boolean GT;
    private int Luong;

    public Canbo() {
    }

    public Canbo(String SoTk, String Hoten, String Diachi, Boolean GT, int Luong) {
        this.SoTk = SoTk;
        this.Hoten = Hoten;
        this.Diachi = Diachi;
        this.GT = GT;
        this.Luong = Luong;
    }

    public String getSoTk() {
        return SoTk;
    }

    public String getHoten() {
        return Hoten;
    }

    public String getDiachi() {
        return Diachi;
    }

    public Boolean getGT() {
        return GT;
    }

    public int getLuong() {
        return Luong;
    }

    public void setSoTk(String SoTk) {
        this.SoTk = SoTk;
    }

    public void setHoten(String Hoten) {
        this.Hoten = Hoten;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public void setGT(Boolean GT) {
        this.GT = GT;
    }

    public void setLuong(int Luong) {
        this.Luong = Luong;
    }
}
