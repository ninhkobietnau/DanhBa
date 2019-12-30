package danhba;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)  throws IOException {
        int lc;
        Scanner sc = new Scanner(System.in);
        List<DanhBa> danhBas = new ArrayList<>();

        String fileDB = "/home/ninhkobietnau/Desktop/DanhBa/danhba/src/danhba/DANHBA.DAT";

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
                    System.out.println("Nhap ten can sua : ");
                    ten1 = sc.nextLine();
                    for (int i = 0; i < danhBas.size(); i++){
                        if(danhBas.get(i).getTen().equals(ten1)){
                            danhBas.get(i).setSdt(ten1);
                        }
                    }
                    break;
                case 4:
                    String ten2;
                    sc.nextLine();
                    System.out.println("Nhap ten can xoa : ");
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

                    danhBas.clear();
                    IOFile.readFile(danhBas, fileDB);

                    System.out.println("done");
                    break;
                case 8:
                    IOFile.writeFile(danhBas, fileDB);
                    System.out.println("Done");
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
        System.out.println("7. doc danh ba");
        System.out.println("8. ghi danh ba");
        System.out.println("9. Exit");
    }
}
