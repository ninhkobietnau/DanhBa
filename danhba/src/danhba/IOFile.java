package danhba;

import java.io.*;
import java.util.List;

public class IOFile {

    public static void writeFile(List objectList, String fileName){
        try {
            FileOutputStream f = new FileOutputStream(fileName);
            ObjectOutputStream output = new ObjectOutputStream(f);
            for (Object object : objectList){
                output.writeObject(object);
            }
            output.close();
            f.close();
        }catch (Exception e) {
            System.err.println(e);
        }
    }    /*danhBas.clear();               IOFile.readFile(danhBas, fileDB);*/
    public static void readFile(List objectList, String fileName){
        try {
            FileInputStream f = new FileInputStream(fileName);
            ObjectInputStream input = new ObjectInputStream(f);
            try {
                Object object ;
                while((object = input.readObject()) != null){
                    objectList.add(object);
                }
                input.close();
                f.close();
            }catch (Exception e){
                System.err.println(e);
            }
        }catch (Exception e){
            System.err.println(e);  /*IOFile.writeFile(danhBas, fileDB);*/
        }
    }

}
