import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Collections;

//11-1
//근데 더 효율적인 풀이도 존재할 거 같음 **
// class Exercise1 {
//     public static void main(String[] args) {
//         ArrayList list1 = new ArrayList();
//         ArrayList list2 = new ArrayList();
//         ArrayList gyo = new ArrayList();
//         ArrayList cha = new ArrayList();
//         ArrayList hap = new ArrayList();

//         list1.add(1);
//         list1.add(2);
//         list1.add(3);
//         list1.add(4);

//         list2.add(3);
//         list2.add(4);
//         list2.add(5);
//         list2.add(6);

//         for(int i = 0; i < list1.size(); i++) {
//             if(list2.contains(list1.get(i))) {
//                 gyo.add(list1.get(i));
//             } else {
//                 cha.add(list1.get(i));
//                 hap.add(list1.get(i));
//             }
//         }

//         for(int i = 0; i < list2.size(); i++) {
//             hap.add(list2.get(i));
//         }

//         System.out.println(gyo);
//         System.out.println(cha);
//         System.out.println(hap);
//     }
// }

//11-2 ** 그냥 작은 값부터 불러오는 군...
//set => {3,6,2,7}
//tset => {2,3,6,7}
//실행결과 => 7 \n 6 \n 3 \n 2
// class Exercise2 {
//     public static void main(String[] args) {
//         ArrayList list = new ArrayList();
//         list.add(3);
//         list.add(6);
//         list.add(2);
//         list.add(2);
//         list.add(2);
//         list.add(7);

//         HashSet set = new HashSet(list);
//         TreeSet tset = new TreeSet(set);
//         Stack stack = new Stack();
//         stack.addAll(tset);

//         while(!stack.empty()) {
//             System.out.println(stack.pop());
//         }
//     }
// }

//11-3
//d. ArrayList는 선형 리스트 구조에 매우 유용함

//11-4
//11개 요소 바로 앞에 있는 원소
//(이중 원형 연결리스트면 바로 맨 뒤의 리스트 부분도 한번에 접근할 수 있어서..?)

//11-5
// class Student implements Comparable<Student> {
//     String name;
//     int ban, no;
//     int kor, eng, math;

//     Student(String name, int ban, int no, int kor, int eng, int math) {
//         this.name = name;
//         this.ban = ban;
//         this.no = no;
//         this.kor = kor;
//         this.eng = eng;
//         this.math = math;
//     }

//     int getTotal() {
//         return kor+eng+math;
//     }

//     float getAverage() {
//         return (int)((getTotal()/3f)*10+0.5)/10f;
//     }

//     @Override
//     public int compareTo(Student s) {
//         return this.name.compareTo(s.name);
//     }

//     public String toString() {
//         return name+" ,"+ban+" ,"+no+" ,"+kor+" ,"+eng+" ,"+math;
//     }
// }
// class Ex5 {
//     public static void main(String[] args) {
//         ArrayList list = new ArrayList();
//         list.add(new Student("홍길동", 1,1,100,100,100));
//         list.add(new Student("남궁성", 1,2,90,70,80));
//         list.add(new Student("김자바", 1,3,80,90,90));

//         Collections.sort(list);
//         Iterator it = list.iterator();
//         while(it.hasNext()) {
//             System.out.println(it.next());
//         }
//     }
// }

//11-6
// class Student implements Comparable {
//     String name;
//     int ban, no;
//     int kor, eng, math;

//     Student(String name, int ban, int no, int kor, int eng, int math) {
//         this.name = name;
//         this.ban = ban;
//         this.no = no;
//         this.kor = kor;
//         this.eng = eng;
//         this.math = math;
//     }

//     int getTotal() {
//         return kor+eng+math;
//     }

//     float getAverage() {
//         return (int)((getTotal()/3f)*10+0.5)/10f;
//     }

//     public String toString() {
//         return name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();
//     }

//     public int compareTo(Object o) {
//         if(o instanceof Student) {
//             Student tmp = (Student) o;
//             return name.compareTo(tmp.name);
//         }
//         else return -1;
//     }
// }
// class Ex6 {
//     static int getGroupCount(TreeSet tset, int from, int to) {
//         Student s1 = new Student("", 0, 0, from, from, from);
//         Student s2 = new Student("", 0, 0, to, to, to);
//         return tset.subSet(s1, s2).size();
//     }
//     public static void main(String[] args) {
//         TreeSet set = new TreeSet(new Comparator() {
//             public int compare(Object o1, Object o2) {
//                 if(o1 instanceof Student & o2 instanceof Student) {
//                     Student s1 = (Student) o1;
//                     Student s2 = (Student) o2;
//                     return (int)(s1.getAverage()-s2.getAverage());
//                 }
//                 return -1;
//             }
//         });

//         set.add(new Student("홍길동",1,1,100,100,100));
//         set.add(new Student("남궁성",1,2,90,70,80));
//         set.add(new Student("김자바",1,3,80,80,90));
//         set.add(new Student("이자바",1,4,70,90,70));
//         set.add(new Student("안자바",1,5,60,100,80));

//         Iterator it = set.iterator();
//         while(it.hasNext())
//         System.out.println(it.next());
//         System.out.println("[60~69] :"+getGroupCount(set,60,70));
//         System.out.println("[70~79] :"+getGroupCount(set,70,80));
//         System.out.println("[80~89] :"+getGroupCount(set,80,90));
//         System.out.println("[90~100] :"+getGroupCount(set,90,101));
//     }
// }

//11-7
// class Student {
//     String name;
//     int ban, no;
//     int kor, eng, math;

//     Student(String name, int ban, int no, int kor, int eng, int math) {
//         this.name = name;
//         this.ban = ban;
//         this.no = no;
//         this.kor = kor;
//         this.eng = eng;
//         this.math = math;
//     }

//     int getTotal() {
//         return kor+eng+math;
//     }
        
//     float getAverage() {
//         return (int)((getTotal()/3f)*10+0.5)/10f;
//     }
       
//     public String toString() {
//         return name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();
//     }
// }
// class BanNoAscending implements Comparator {
//     public int compare(Object o1, Object o2) {
//         if(o1 instanceof Student && o2 instanceof Student) {
//             Student s1 = (Student) o1;
//             Student s2 = (Student) o2;
//             if(s1.ban == s2.ban) return s1.no-s2.no;
//             return s1.ban-s2.ban;
//         }
//         return -1;
//     }
// }
// class Exercise7 {
//     public static void main(String[] args) {
//         ArrayList<Student> list = new ArrayList();
//         list.add(new Student("이자바",2,1,70,90,70));
//         list.add(new Student("안자바",2,2,60,100,80));
//         list.add(new Student("홍길동",1,3,100,100,100));
//         list.add(new Student("남궁성",1,1,90,70,80));
//         list.add(new Student("김자바",1,2,80,80,90));
//         list.sort(new BanNoAscending());
//         Iterator it = list.iterator();
//         while(it.hasNext()) {
//             System.out.println(it.next());
//         }
//     }
// }

//11-8 ** Collections.sort(list)가 실행이 안됨 ㅠㅠ
// class Student {
//     String name;
//     int ban, no;
//     int kor, eng, math;
//     int total, schoolRank;

//     Student(String name, int ban, int no, int kor, int eng, int math) {
//         this.name = name;
//         this.ban = ban;
//         this.no = no;
//         this.kor = kor;
//         this.eng = eng;
//         this.math = math;
        
//         this.total = kor+eng+math;
//     }

//     int getTotal() {
//         return total;
//     }
        
//     float getAverage() {
//         return (int)((getTotal()/3f)*10+0.5)/10f;
//     }
       
//     public String toString() {
//         return name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage()+", "+schoolRank;
//     }

//     public int compareTo(Object o) {
//         if(o instanceof Student) {
//             Student s = (Student) o;
//             return s.total-this.total;
//         }
//         return -1;
//     }
// }
// class Ex8 {
//     public static void calculateSchoolRank(List list) {
//         //Collections.sort(list); //이거 왜 Collections.sort(list)가 안돼ㅠㅠ 이것만 되면 돌아갈 것 같은데
//         Collections.sort(list);

//         int prevRank = 0;
//         int prevTotal = -1;
//         int length = list.size();

//         for(int i = 0; i < length; i++) {
//             Student s1 = (Student) list.get(i);
//             if(s1.total == prevTotal) {s1.schoolRank = prevRank; prevRank++;}
//             else {
//                 s1.schoolRank = ++prevRank;
//                 prevTotal = s1.total;
//                 prevRank = s1.schoolRank;
//             }
//         }
//     }
//     public static void main(String[] args) {
//         ArrayList list = new ArrayList();
//         list.add(new Student("이자바",2,1,70,90,70));
//         list.add(new Student("안자바",2,2,60,100,80));
//         list.add(new Student("홍길동",1,3,100,100,100));
//         list.add(new Student("남궁성",1,1,90,70,80));
//         list.add(new Student("김자바",1,2,80,80,90));
//         calculateSchoolRank(list);
//         Iterator it = list.iterator();
//         while(it.hasNext()) {
//             System.out.println(it.next());
//         }
//     }
// }

// 11-9
// class Student implements Comparable {
//     String name;
//     int ban;
//     int no;
//     int kor;
//     int eng;
//     int math;   
//     int total;
//     int schoolRank; // 전교등수
//     int classRank; // 반등수

//     Student(String name, int ban, int no, int kor, int eng, int math) {
//         this.name = name;
//         this.ban = ban;
//         this.no = no;
//         this.kor = kor;
//         this.eng = eng;
//         this.math = math;
//         total = kor+eng+math;
//     }

//     int getTotal() {
//         return total;
//     }

//     float getAverage() {
//         return (int)((getTotal()/ 3f)*10+0.5)/10f;
//     }

//     public int compareTo(Object o) {
//         if(o instanceof Student) {
//             Student tmp = (Student)o;
//             return tmp.total - this.total;
//         } 
//         else {
//             return -1;
//         }
//     }

//     public String toString() {
//         return name
//         +","+ban
//         +","+no
//         +","+kor
//         +","+eng
//         +","+math+", "+getTotal()+", "+getAverage()+", "+schoolRank+", "+classRank;
//     }
// }

// class ClassTotalComparator implements Comparator { 
//     public int compare(Object o1, Object o2) { 
//         if(o1 instanceof Student && o2 instanceof Student) {
//             Student s1 = (Student) o1;
//             Student s2 = (Student) o2;
//             int result = s1.ban-s2.ban;
//             if(result == 0) result = s2.total-s1.total;
//             return result; 
//         }
//         return -1;
//     } 
// } 

// class Exercise11_9 {
//     public static void calculateClassRank(List list) { 
//         // 먼저 반별 총점기준 내림차순으로 정렬한다.
//         list.sort(new ClassTotalComparator()); 

//         int prevBan = -1; 
//         int prevRank = -1; 
//         int prevTotal = -1; 
//         int length = list.size(); 

//         for(int i = 0, n = 0; i < length; i++, n++) {
//             Student s = (Student) list.get(i);
//             if(s.ban != prevBan) {
//                 prevRank = -1;
//                 prevTotal = -1;
//                 n = 0;
//             } if(s.total == prevTotal) {
//                 s.schoolRank = prevRank;
//             } else {
//                 s.classRank = n+1;
//             }
//             prevBan = s.ban;
//             prevRank = s.classRank;
//             prevTotal = s.total;
//         }
//     } 
//     public static void calculateSchoolRank(List list) { 
//         Collections.sort(list); // 먼저 list를 총점기준 내림차순으로 정렬한다.
//         int prevRank = -1; // 이전 전교등수
//         int prevTotal = -1; // 이전 총점
//         int length = list.size(); 
//         for(int i = 0; i < length; i++) { 
//             Student s = (Student)list.get(i); 
//             if(s.total==prevTotal) {
//                 s.schoolRank = prevRank; 
//             } else { 
//                 s.schoolRank = i + 1; 
//             } 
//             prevRank = s.schoolRank; 
//             prevTotal = s.total; 
//         } // for
//     }
//     public static void main(String[] args) {
//         ArrayList list = new ArrayList();
//         list.add(new Student("이자바",2,1,70,90,70));
//         list.add(new Student("안자바",2,2,60,100,80));
//         list.add(new Student("홍길동",1,3,100,100,100));
//         list.add(new Student("남궁성",1,1,90,70,80));
//         list.add(new Student("김자바",1,2,80,80,90));

//         calculateSchoolRank(list);
//         calculateClassRank(list);
//         Iterator it = list.iterator();
//         while(it.hasNext()) {
//             System.out.println(it.next());
//         }
//     }
// }

//11-10
//HashSet은 순서가 유지되면서 중복을 허용하지 않기 때문.
//HashSet대신 ArrayList를 사용하자!

//11-11
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
        } else {
            return false;
        }
    }

    public String toString() {
        return num + (isKwang ? "K" : "");
    }

    //아니 근데 내꺼는 왜 얘를 추가해도 중복처리가 될까ㅠㅠ
    public int hashCode() {
        return toString().hashCode();
    }
}

// class Exercise11 {
//     public static void main(String[] args) {
//         SutdaCard c1 = new SutdaCard(3, true);
//         SutdaCard c2 = new SutdaCard(3, true);
//         SutdaCard c3 = new SutdaCard(1, true);

//         HashSet set = new HashSet();
//         set.add(c1);
//         set.add(c2);
//         set.add(c3);

//         System.out.println(set);
//     }
// }

// class Player {
//     String name;
//     SutdaCard c1;
//     SutdaCard c2;

//     int point;

//     Player(String name, SutdaCard c1, SutdaCard c2) {
//         this.name = name;
//         this.c1 = c1;
//         this.c2 = c2;
//     }

//     public String toString() {
//         return "["+name+"]"+c1.toString()+","+c2.toString();
//     }
// }
// class SutdaDeck {
//     final int CARD_NUM = 20;
//     SutdaCard[] cards = new SutdaCard[CARD_NUM];

//     int pos = 0;
//     HashMap jokbo = new HashMap();

//     SutdaDeck() {
//         for(int i = 0; i < cards.length; i++) {
//             int num = i%10+1;
//             boolean isKwang = i < 10 && (num == 1 || num == 3 || num == 8);

//             cards[i] = new SutdaCard(num, isKwang);
//         }
//         registerJokbo();
//     }

//     void registerJokbo() {
//         //책에 제시된 족보들을 집어넣어줌
//         jokbo.put("KK", 4000);
//         jokbo.put("1010", 3100);
//         jokbo.put("99", 3090);
//         jokbo.put("88", 3080);
//         jokbo.put("77", 3070);
//         jokbo.put("66", 3060);
//         jokbo.put("55", 3050);
//         jokbo.put("44", 3040);
//         jokbo.put("33", 3030);
//         jokbo.put("22", 3020);
//         jokbo.put("11", 3010);

//         jokbo.put("12", 2060);
//         jokbo.put("21", 2060);
//         jokbo.put("14", 2050);
//         jokbo.put("41", 2050);
//         jokbo.put("19", 2040);
//         jokbo.put("91", 2040);
//         jokbo.put("110", 2030);
//         jokbo.put("101", 2030);
//         jokbo.put("410", 2020);
//         jokbo.put("104", 2020);
//         jokbo.put("46", 2010);
//         jokbo.put("64", 2010);
//     }

//     int getPoint(Player p) {
//         if(p==null) return 0;

//         SutdaCard c1 = p.c1;
//         SutdaCard c2 = p.c2;

//         Integer result = 0;

//         if(c1.isKwang && c2.isKwang) {
//             result = (Integer) jokbo.get("KK");
//         } else {
//             result = (Integer) jokbo.get(""+c1.num+c2.num);

//             if(result == null) {
//                 result = (c1.num+c2.num)%10+1000;
//             }
//         }

//         p.point = result;

//         return result.intValue();
//     }

//     SutdaCard pick() throws Exception {
//         SutdaCard c = null;

//         if(0<=pos && pos < CARD_NUM) {
//             c = cards[pos];
//             cards[pos++] = null;
//         } else throw new Exception("남아있는 카드가 없습니다.");

//         return c;
//     }

//     void shuffle() {
//         for(int i = 0; i < CARD_NUM * 2; i++) {
//             int x = (int) Math.random()*CARD_NUM;
//             int y = (int) Math.random()*CARD_NUM;

//             SutdaCard tmp = cards[x];
//             cards[x] = cards[y];
//             cards[y] = tmp;
//         }
//     }
// }
// class Exercise12 {
//     public static void main(String[] args) throws Exception {
//         SutdaDeck deck = new SutdaDeck();

//         deck.shuffle();
//         Player p1 = new Player("타짜", deck.pick(), deck.pick());
//         Player p2 = new Player("고수", deck.pick(), deck.pick());

//         System.out.println(p1+" "+deck.getPoint(p1));
//         System.out.println(p2+" "+deck.getPoint(p2));
//     }
// }

//11-14
class Ex14 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010, 0, 1);
        for(int i = 0; i < 12; i++) {
            int week = calendar.get(Calendar.DAY_OF_WEEK);
            //1일이 일요일이면 두 번째 일요일은 8일임
            //1일이 다른 요일이면 16에서 1일의 요일을 빼면 알 수 있음!
            int secondSunday = (week == 1) ? 8 : 16-week;
            calendar.set(Calendar.DAY_OF_MONTH, secondSunday);
            Date date = calendar.getTime();
            System.out.println(new SimpleDateFormat("yyyy-MM-dd은 2번째 일요일입니다.").format(date));
        
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
        } 
    }
}