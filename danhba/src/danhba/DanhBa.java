package danhba;

import java.io.Serializable;
import java.util.Scanner;

public class DanhBa implements Serializable {
    private String ten;
    private String sdt;

    Scanner sc = new Scanner(System.in);

    public DanhBa() {
    }

    public DanhBa(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void nhap() {
        System.out.println("Nhap ten : ");
        ten = sc.nextLine();
        capnhat();
    }

    public void xuat(){
        System.out.println(toString());
    }

    public void capnhat() {
        System.out.println("Nhap sdt : ");
        sdt = sc.nextLine();
    }
    @Override
    public String toString() {
        return "DanhBa{" +
                "ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
