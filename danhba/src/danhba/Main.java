package danhba;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        int lc;
        Scanner sc = new Scanner(System.in);
        List<DanhBa> danhBas = new ArrayList<>();

        do {
            showMenu();
            System.out.println("Nhap lua chon : ");
            lc = sc.nextInt();

            switch (lc) {
                case 1:
                    int n;
                    System.out.println("Nhap so danh ba can them : ");
                    n = sc.nextInt();
                    for (int i = 0; i < n; i++){
                        DanhBa danhBa = new DanhBa();
                        danhBa.nhap();
                        danhBas.add(danhBa);
                    }
                    break;
                case 2:
                    String ten;
                    sc.nextLine();
                    System.out.println("Nhap ten can tim : ");
                    ten = sc.nextLine();
                    for (int i = 0; i < danhBas.size(); i++){
                        if(danhBas.get(i).getTen().equals(ten)){
                            danhBas.get(i).xuat();
                        }
                    }
                    break;
                case 3:
                    String ten1;
                    sc.nextLine();
                    System.out.println("Nhap ten can tim : ");
                    ten1 = sc.nextLine();
                    for (int i = 0; i < danhBas.size(); i++){
                        if(danhBas.get(i).getTen().equals(ten1)){
                            danhBas.get(i).capnhat();
                        }
                    }
                    break;
                case 4:
                    String ten2;
                    sc.nextLine();
                    System.out.println("Nhap ten can tim : ");
                    ten2 = sc.nextLine();
                    for (int i = 0; i < danhBas.size(); i++){
                        if(danhBas.get(i).getTen().equals(ten2)){
                            danhBas.remove(i);
                        }
                    }
                    break;
                case 5:
                    Collections.sort(danhBas, new Comparator<DanhBa>() {
                        @Override
                        public int compare(DanhBa t1, DanhBa t2) {
                            int cmp = t1.getTen().compareTo(t2.getTen());
                            if(cmp >= 0) {
                                return 1;
                            }
                            return -1;
                        }
                    });
                    break;
                case 6:
                    System.out.println("Danh sach sdt trong danh ba :");
                    for (int i = 0; i < danhBas.size(); i++) {
                        danhBas.get(i).xuat();
                    }
                    break;
                case 7:
                    FileOutputStream fos = null;
                    ObjectOutputStream oos = null;

                    try{
                        fos = new FileOutputStream("danhba.dat");
                        oos = new ObjectOutputStream(fos);

                            oos.writeObject(danhBas);


                        System.out.println("Ghi ra file thanh cong !");
                        oos.close();

                    }catch (Exception e) {
                    } finally {
                        try {
                            if (fos!=null) {
                                fos.close();
                            }
                            if (oos!=null) {
                                oos.close();
                            }
                        }catch (Exception e){}
                    }
                    break;
                case 8:
                    FileInputStream fis = null;
                    ObjectInputStream ois = null;

                    try {
                        fis = new FileInputStream("danhba.dat");
                        ois = new ObjectInputStream(fis);

                        danhBas = (List<DanhBa>) ois.readObject();

                    }catch (Exception e) {
                    } finally {
                        try {
                            if (fis!=null) {
                                fis.close();
                            }
                            if (ois!=null) {
                                ois.close();
                            }
                        }catch (Exception e){}
                    }
                    break;
                case 9:
                    System.out.println("goodbye!");
                    break;
                default:
                    System.err.println("Nhap sai");
                    break;
            }

        } while (lc != 9);

    }

    static void showMenu() {
        System.out.println("-------------menu------------");
        System.out.println("1. Nhap so danh ba");
        System.out.println("2. Tim kiem");
        System.out.println("3. Cap nhat");
        System.out.println("4. Xoa");
        System.out.println("5. Sap xep theo ten");
        System.out.println("6. Hien thi");
        System.out.println("7. Luu danh ba");
        System.out.println("8. Doc danh ba");
        System.out.println("9. Exit");
    }
}
