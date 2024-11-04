package QLCB;

import java.sql.*;
import java.util.*;

public class Test_insertCb {
    public Test_insertCb() {
    }

    public static void doInsertCB(){
        QLCB qlcb = new QLCB();
        Connection cn = qlcb.getCon();
        qlcb.insertCB(cn, "001", "Nguyễn Văn A", Boolean.TRUE, "Haiphong", 20000);
    }

    public static void main(String[] args) {
//        doInsertCB();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tài khoản:");
        String SoTK = sc.nextLine();
        System.out.println("Họ và tên:");
        String Hoten = sc.nextLine();
        System.err.println("Giới tính(1: Nam || 0: Nữ): ");
        Boolean GT = sc.nextLine().equalsIgnoreCase("1");
        System.out.println("Địa chỉ: ");
        String Diachi = sc.nextLine();
        while (true) {
            try {
                System.out.println("Lương: ");
                int Luong = sc.nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Lương phải là số nguyên");
                sc.nextLine();
            }
        }
        
    }
}
