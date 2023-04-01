class Ex1 extends Thread {
    private int num;
    public Ex1(int num) {
        this.num = num;
    }
    public void thread2() {
        System.out.println("2번째 시작");
    }
    public void run() {
        System.out.println(num+"이 시작");
        thread2();
    }
}

class Ex2 implements Runnable {
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        } 
    } 
}

class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Ex2());
        t1.start();
        // System.out.println("끝");
        try {
            t1.join();
            System.out.println("끝!");
        } catch(Exception e) {
            System.out.println("에러어어");
        }
            
        // for(int i = 1; i <= 10; i++) {
        //     Thread th = new Ex1(i);
        //     th.start();
        // }
        // Thread th2 = new Thread(new Ex2());
        // th2.start();
    }
}