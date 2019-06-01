package demo;

public class Demo02 {
    public static void main(String[] args) {
        int[] ia = new int[10];
        String[] a = new String[10];
        for (int i=0 ;i<ia.length;i++){
            ia[i]=i;
        }
        for (int k :ia){
            System.out.println(k);
        }
for (int i=0;i<a.length;i++){
    a[i]=""+i;
}

        String s =null;
        System.out.println();
    }
}
