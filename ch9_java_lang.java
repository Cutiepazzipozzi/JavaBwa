import java.util.*;
class Exercise9_1 {
    
    public static String format(String str, int length, int alignment) {
        // 0 왼쪽 1 가운데 2 오른쪽 정렬
        if(length < str.length()) return str.substring(0, length);
        char[] src = str.toCharArray();
        char[] arr = new char[length];
        Arrays.fill(arr, ' ');
        switch(alignment) {
            case 0:
                System.arraycopy(src, 0, arr, 0, src.length);
                break;
            case 1:
                System.arraycopy(src, 0, arr, (length-str.length())/2, src.length);
                break;
            case 2:
                System.arraycopy(src, 0, arr, length-str.length(), src.length);
                break;
        }
        return new String(arr);
    }
    public static String delChar(String src, String delCh) {
        StringBuffer sb = new StringBuffer(src.length());
        for(int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            //c가 delCh에 포함돼 있지 않으면 sb에 추가
            if(delCh.indexOf(c) == -1) sb.append(c);
        }
        return sb.toString();
    }
    public static double round(double d, int n) {
        return Math.round(d*Math.pow(10, n))/Math.pow(10, n);
    }
    public static boolean contains(String src, String target) {
        return src.contains(target);
    }
    public static int count(String src, String target) {
        int count = 0;
        int pos = 0;

        for(int i = 0; i < src.length(); i++) {
            pos = src.indexOf(target, pos);
            if(pos != -1) {
                count++;
                pos += target.length();
            } else return count;
        }

        return count;
    }
    public static void printGraph(int[] dataArr, char ch) {
        for(int i = 0; i < dataArr.length; i++) {
            for(int j = 0; j < dataArr[i]; j++) {
                System.out.print(ch);
            }
            System.out.print(dataArr[i]);
            System.out.println();
        }
    }
    public static String fillZero(String src, int length) {
        if(src.equals(null) || src.length() == length) {
            return src;
        }
        if(length <= 0) return "";
        if(src.length() > length) return src.substring(0, length);
        char[] arr =  new char[length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = '0';
        }
        System.arraycopy(src.toCharArray(), 0, arr, length-src.length(), src.length());

        return new String(arr);
    }
    public static void main(String[] args) {
        //1번
        // SutdaCard c1 = new SutdaCard(3,true);
        // SutdaCard c2 = new SutdaCard(3,true);
        
        // System.out.println("c1="+c1); 
        // System.out.println("c2="+c2); 
        // System.out.println("c1.equals(c2):"+c1.equals(c2)); 

        //2번
        // Point3D p1 = new Point3D(1,2,3);
        // Point3D p2 = new Point3D(1,2,3);

        // System.out.println("p1==p2?"+(p1==p2));
        // System.out.println("p1.equals(p2)?"+(p1.equals(p2)));

        //3번 이거 모지 어케 바꿈;
        String fullPath = "c:\\jdk1.5\\work\\PathSeparateTest.java";
        String path = "";
        String fileName = "";

        int pos = fullPath.lastIndexOf("\\");

        if(pos != -1) {
            path = fullPath.substring(0, pos);
            fileName = fullPath.substring(pos+1);
        }

        System.out.println("fullPath:"+fullPath);
        System.out.println("path:"+path);
        System.out.println("fileName:"+fileName);

        //4번
        // printGraph(new int[]{3,7,1,4}, '*');

        //5번
        // System.out.println(count("12345AB12AB345AB", "AB"));
        // System.out.println(count("12345", "AB"));

        //6번 **
        // String src = "12345";
        // System.out.println(fillZero(src, 10));
        // System.out.println(fillZero(src, -1));
        // System.out.println(fillZero(src, 3));

        //7번
        // System.out.println(contains("12345","23"));
        // System.out.println(contains("12345","67"));

        //8번
        // System.out.println(round(3.1415,1));
        // System.out.println(round(3.1415,2));
        // System.out.println(round(3.1415,3));
        // System.out.println(round(3.1415,4));
        // System.out.println(round(3.1415,5));

        //9번 ** 특수기호 어케 처리해야돼
        // System.out.println("(1!2@3^4~5)"+" -> " 
        // + delChar("(1!2@3^4~5)","~!@#$%^&*()"));
        // System.out.println("(1 2 3 4\t5)"+" -> "
        // + delChar("(1 2 3 4\t5)"," \t"));

        //10번
        // String str = "가나다";
        // System.out.println(format(str,7,0)); // 왼쪽 정렬
        // System.out.println(format(str,7,1)); // 가운데 정렬
        // System.out.println(format(str,7,2)); // 오른쪽 정렬
    }
}

class SutdaCard {
    int num;
    boolean isKwang;

    SutdaCard() {
        this(1, true);
    }

    SutdaCard(int num, boolean isKwang) {
        this.num = num;
        this.isKwang = isKwang;
    }

    public boolean equals(Object obj) {
        if(obj instanceof SutdaCard) {
            SutdaCard c = (SutdaCard) obj;
            return num == c.num && isKwang == c.isKwang;
        }
        return false;
    }

    public String toString() {
        return num + ( isKwang ? "K":"");
    }
}

class Point3D {
    int x, y, z;

    Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Point3D() {
        this(0, 0, 0);
    }

    public boolean equals(Object obj) {
        if(obj instanceof Point3D) {
            Point3D p = (Point3D) obj;
            return x == (p.x) && y == p.y && z == p.z; 
        }
        return false;
    }
}