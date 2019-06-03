package class14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo01 {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\a.txt");
        int b=0;
        while (true) {
            b=fis.read();
            if (b == -1) {
                break;
            }
            System.out.println((char)b);
        }

        FileOutputStream out = new FileOutputStream("example.txt");
        String str ="王逸楠";
        byte[] c = str.getBytes();
        for (int i=0;i<c.length;i++){

        }
    }
}
