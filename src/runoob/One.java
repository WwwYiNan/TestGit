package runoob;

import java.util.StringTokenizer;

public class One {
    public static void main(String[] args) {
        String str="This is a Test if you want to over it , please call me daddy!";
        StringTokenizer st = new StringTokenizer(str);
        System.out.println("————————————分割————————————");
        while (st.hasMoreElements()){
            System.out.println(st.nextElement());
        }
        System.out.println("————————————分割————————————");
        StringTokenizer st2 = new StringTokenizer(str,",");//通过,分割
        while (st2.hasMoreElements()){
            System.out.println(st2.nextElement());
        }
        System.out.println("————————————分割————————————");
        for(String temp:str.split("an")){
            System.out.print(temp+"  ");
        }
    }
}
