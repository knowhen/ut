package when.ut.unpredictable.multithreading;

/**
 * @author: when
 * @create: 2020-02-11  19:18
 **/
public class BlackMarket {
    private boolean blocked = true;

    public synchronized void buyTicket() throws InterruptedException {
        while (blocked) {
            System.out.println("wait");
            wait();
        }
    }

    public synchronized void setBlocked(boolean blocked) {
        this.blocked = blocked;
        notify();
    }
}
