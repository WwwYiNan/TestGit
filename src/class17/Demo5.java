package class17;

class Bank{
    private int sum;
    public void add(int num){
        synchronized (this){
            sum = sum+num;
            System.out.println("账号的余额为："+sum);
        }
    }
}

class Customer implements Runnable{
    private Bank bank = new Bank();
    public void run(){
        for (int i =0;i<3;i++){
            bank.add(100);
        }
    }
}
public class Demo5 {
    public static void main(String[] args) {
        Customer customer= new Customer();
        Thread t1 =new Thread(customer);
        Thread t2 =new Thread(customer);
        Thread t3 =new Thread(customer);
        t1.start();
        t2.start();
        t3.start();
    }

}
