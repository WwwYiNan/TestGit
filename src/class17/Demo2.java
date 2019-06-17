package class17;

public class Demo2 {
    public static void main(String[] args) {
        TicketWindows task = new TicketWindows();
        new Thread(task,"窗口1").start();
        new Thread(task,"窗口2").start();
        new Thread(task,"窗口3").start();
        new Thread(task,"窗口4").start();

    }
}

class TicketWindows implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出的票" + tickets--);
        }
    }
}