package danhba;

import java.io.Serializable;
import java.util.Scanner;

public class DanhBa implements Serializable {
    private String ten;
    private String sdt;

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
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten : ");
        ten = sc.nextLine();
        System.out.println("Nhap sdt : ");
        sdt = sc.nextLine();
    }

    public void xuat(){
        System.out.println(toString());
    }


    @Override
    public String toString() {
        return "DanhBa{" +
                "ten='" + ten + '\'' +
                ", sdt='" + sdt + '\'' +
                '}';
    }
}
