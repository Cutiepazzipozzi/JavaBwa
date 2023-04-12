class Thread2 extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName()+"이 작동 중입니다");
    }
}

class Main2 {
    public static void main(String[] args) {
        Thread th = new Thread();
        System.out.println("스레드 이름: "+Thread.currentThread().getName());
        
        for(int i = 0; i < 5; i++) {
            Thread2 th2 = new Thread2();
            th2.start();
        }
        
        for(int i = 0; i < 5; i++) {
            th = new Thread(()-> System.out.println("스레드 이름: "+Thread.currentThread().getName()));
            th.start(); //멀티스레드

            try {
                th.join();
            } catch(Exception e) {
                e.getStackTrace();
            }
        }
        
        for(int i = 0; i < 5; i++) {
            th = new Thread(()-> System.out.println("스레드 이름: "+Thread.currentThread().getName()));
            th.run();  //싱글스레드
        }
    }
}
