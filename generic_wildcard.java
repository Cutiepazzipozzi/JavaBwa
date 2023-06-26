import java.util.*;
public class generic_wildcard {
    class Student<T> {
        T name;
        Student(T name) {
            this.name = name;
        }
    }
    class Animal {};
    class Dog extends Animal {};
    class Cat extends Animal {};
    public static void main(String[] args) {
        //안되는 예시
        List<Object> list = new ArrayList<String>();
        Student<Object> student = new Student<String>("안녕");

        //그래서 공변성을 가능하게끔 하는 와일드카드를 사용한 예시
        List<? extends Object> list2 = new ArrayList<String>(); 
        List<? super String> list3 = new ArrayList<Object>();

        List<? extends Animal> ani1 = new ArrayList<Dog>();
        List<? extends Animal> ani2 = new ArrayList<Cat>();

        //만약 배열이라면, 공변이 가능 (아래처럼 다형성의 이점을 살리기 위함)
        Object[] arr = {"안녕", 0.1, 5};
        Object[] arr2 = new String[3];

        //제네릭이 불공변인 이유 (아래의 코드는 잘못됨)
        List<Dog> dogs = new ArrayList<>();
        List<Animal> animals = dogs; //불공변하므로 List<Animal> != List<Dog>
        animals.add(new Cat());  //그러나 Animal이 Cat의 상위 타입이므로 list에 넣어지긴 함
        Dog dog = dogs.get(0); //만약 공변이라면 ClassCastException 발생

        //와일드카드
        List<?> wild = new ArrayList<Integer>();
        wild.add(1);
    }
}
