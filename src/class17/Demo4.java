package class17;

public class Demo4 {
    public static void main(String[] args) {
        TicketWindows3 task = new TicketWindows3();
        new Thread(task, "窗口1").start();
        new Thread(task, "窗口2").start();
        new Thread(task, "窗口3").start();
        new Thread(task, "窗口4").start();

    }
}

class TicketWindows3 implements Runnable {
    private int tickets = 10;

    public void run() {
        while (true) {
            sendTicket();
        }
    }

    public synchronized void sendTicket() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (tickets > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出的票" + tickets--);
        } else {
            System.exit(0);
        }
    }
}
