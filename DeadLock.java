import java.util.concurrent.locks.*;

//lock을 활용
//Lock은 인터페이스이기 때문에 3가지의 종류를 활용해 인스턴스로 만들어주는듯,,?
class LockEx1 {
    private final ReentrantLock lock = new ReentrantLock();
    public void outer() {
        lock.lock();
        inner();
        lock.unlock();
    }
    public synchronized void inner() {
        lock.lock();
        System.out.println("lock된 상태입니다");
        lock.unlock();
    }
}
class LockEx2 {
    private ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void count() {
        lock.lock();
        int newC = ++count;
        lock.unlock();
        System.out.println("newC의 값입니다: "+newC);
    }
}
public class DeadLock {
    public static void main(String[] args) {
        //synchronized 키워드 활용
        // final String s1 = "hi";
        // final String s2 = "hello";

        // Thread th1 = new Thread() {
        //     public void run() {
        //         synchronized(s1) {
        //             System.out.println("Thread1: locked s1");

        //             try {
        //                 Thread.sleep(100);
        //             } catch(Exception e) {}

        //             synchronized(s2) {
        //                 System.out.println("Thread1: locked s2");
        //             }
        //         }
        //     }
        // };

        // Thread th2 = new Thread() {
        //     public void run() {
        //         synchronized(s2) {
        //             System.out.println("Thread2: locked s2");
        //         }

        //         try {
        //             Thread.sleep(100);
        //         } catch(Exception e) {}

        //         synchronized(s1) {
        //             System.out.println("Thread2: locked s1");
        //         }
        //     }
        // };

        // th1.start();
        // th2.start();

        LockEx1 lock1 = new LockEx1();
        lock1.outer();
        LockEx2 lock2 = new LockEx2();
        lock2.count();
    }
}
