package class14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    }
}
