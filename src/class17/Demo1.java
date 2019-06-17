package class17;

public class Demo1 {
    public static void main(String[] args) throws Exception{
       new Thread(new Task()).start();
       for (int i =1;i<=10;i++){
           if (i == 5) {
               Thread.sleep(2000);
           }else{
               Thread.sleep(500);
           }
           System.out.println("主线程一正在输出:"+i);
       }
    }
}

class Task implements Runnable{
    @Override
    public void run(){
        for (int i=0;i<=10;i++){
            try{
                if (i == 3) {
                    Thread.sleep(2000);
                }else{
                    Thread.sleep(500);
                }
                System.out.println("线程一正在输出:"+i);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
