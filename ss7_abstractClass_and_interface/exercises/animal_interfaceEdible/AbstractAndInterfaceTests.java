package exercises.animal_interfaceEdible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Orange o = new Orange();
        System.out.println(o.howtoEat());
        Apple apple = new Apple();
        System.out.println(apple.howtoEat());
        Chicken chicken = new Chicken();
        System.out.println(chicken.howtoEat());
        System.out.println(chicken.makeSound());
        Tiger tiger = new Tiger();
        System.out.println(tiger.makeSound());
    }
}