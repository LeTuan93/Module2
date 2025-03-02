package practise.colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[10];
        shapes[0] = new Circle(45);
        shapes[1] = new Rectangle(45,14);
        shapes[2] = new Square(12);
        shapes[3] = new Circle(5);
        shapes[4] = new Rectangle(45,54);
        shapes[5] = new Square(2);
        shapes[6] = new Circle(8);
        shapes[7] = new Rectangle(74,5);
        shapes[8] = new Square(7);
        shapes[9] = new Square(10);
        for (Shape shape : shapes) {

            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            }
            System.out.println(shape.getArea()+"\n");
        }
    }
}