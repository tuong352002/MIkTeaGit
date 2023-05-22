package MIktea;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XFile {


        public  static void writeObject(String path,Object o)
        {
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
                oos.writeObject(o);
                oos.close();
            }catch (Exception e){
                System.err.println(e);
            }
        }
        public  static Object readObject(String path)
        {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
                Object o = ois.readObject();
                ois.close();
                return o ;
            }catch (Exception e){
                System.err.println(e);
                return null;

            }

        }
        public static void main(String[] args) {
            String pathName = "Candidate.dat";
            List<Customer> c = new ArrayList<>();
            writeObject(pathName,c);


        }
    }


