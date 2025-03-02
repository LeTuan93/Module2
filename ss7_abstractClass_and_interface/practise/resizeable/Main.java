package practise.resizeable;

public class Main {

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle.toString());
        circle.resize(15.2);
        System.out.println(circle.toString());

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle.toString());
        rectangle.resize(25.2);
        System.out.println(rectangle.toString());
    }
}
