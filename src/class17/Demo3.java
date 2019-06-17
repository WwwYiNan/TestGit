package class17;

public class Demo3 {
    public static void main(String[] args) {
        TicketWindows2 task = new TicketWindows2();
        new Thread(task, "窗口1").start();
        new Thread(task, "窗口2").start();
        new Thread(task, "窗口3").start();
        new Thread(task, "窗口4").start();

    }
}

class TicketWindows2 implements Runnable {
    private int tickets = 10;
    Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (tickets > 0) {
                    System.out.println(Thread.currentThread().getName() + "卖出的票" + tickets--);
                } else {
                    break;
                }
            }
        }
    }
}

