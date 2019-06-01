package demo;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        for (int i=1;i<=5;i++){
            if (i%2==1)
                System.out.print("*");
            else
                continue;
            System.out.print("#");
        }

    }
}

