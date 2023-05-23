import java.awt.*;
import java.awt.event.*;

class Outer {
    static class Inner {
        int iv = 100;
    }
}

class Outer2 {
    int value = 10;

    class Inner {
        int value = 20;
        void method1() {
            int value = 30;

            System.out.println(value);
            System.out.println(this.value);
            System.out.println(new Outer2().value);
            //마지막꺼 Outer2.this.value 가능!
        }
    }
}

public class ch10_inner_class {
    public static void main(String[] args) {
        //10-1
        // Outer o = new Outer();
        // System.out.println(o.new Inner().iv);

        //10-2 **
        //1번과 2번의 차이는 외부 클래스 인스턴스의 생성 여부
        // Outer.Inner ii = new Outer.Inner();
        // System.out.println(ii.iv);

        //10-3
        // Outer2.Inner inner = new Outer2().new Inner();
        // inner.method1();

        //10-4
        // Frame f = new Frame();
        // f.addWindowListener(new WindowAdapter() {
        //     public void windowClosing(WindowEvent e) {
        //         e.getWindow().setVisible(false);
        //         e.getWindow().dispose();
        //         System.exit(0);
        //     }
        // });

        //10-5
        //메서드가 수행을 마쳐 지역변수가 소멸된 시점에도 이 지역변수를 참조하려는 경우를 방지하기 위해
    }
}
