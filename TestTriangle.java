import java.util.Scanner;


//        +---------------------------------+
//        |     Shape                       |
//        +---------------------------------+
//        | - color: String                 |
//        +---------------------------------+
//        | + Shape()                       |
//        | + Shape(color)                  |
//        | + getColor(): String            |
//        | + setColor(color: String): void |
//        | + toString(): String            |
//        +---------------------------------+
//              ▲
//              │
//              │ extends
//              │
//        +---------------------------------+
//        |       Triangle                  |
//        +----------------------+
//        | - side1: double                 |
//        | - side2: double                 |
//        | - side3: double                 |
//        +---------------------------------+
//        | + Triangle()                    |
//        | + Triangle(side1, side2, side3) |
//        | + getSide1(): double            |
//        | + getSide2(): double            |
//        | + getSide3(): double            |
//        | + getArea(): double             |
//        | + getPerimeter(): double        |
//        | + toString(): String            |
//        +---------------------------------+

class Shape {
    private String color;

    public Shape() {
        this.color = "white";
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape[color=" + color + "]";
    }
}
class Triangle extends Shape {
    private double side1, side2, side3;

    public Triangle() {
        this.side1 = 1.0;
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)); // Công thức Heron
    }

    @Override
    public String toString() {
        return "Triangle[side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + ", color=" + getColor() + "]";
    }
}

public class TestTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập độ dài ba cạnh
        System.out.print("Nhập cạnh 1: ");
        double side1 = scanner.nextDouble();
        System.out.print("Nhập cạnh 2: ");
        double side2 = scanner.nextDouble();
        System.out.print("Nhập cạnh 3: ");
        double side3 = scanner.nextDouble();

        // Nhập màu sắc
        System.out.print("Nhập màu sắc: ");
        scanner.nextLine(); // Đọc bỏ dòng trống sau nextDouble()
        String color = scanner.nextLine();

        // Tạo đối tượng Triangle
        Triangle triangle = new Triangle(side1, side2, side3);
        triangle.setColor(color);

        // Hiển thị thông tin tam giác
        System.out.println("\nThông tin tam giác:");
        System.out.println(triangle);
        System.out.println("Chu vi: " + triangle.getPerimeter());
        System.out.println("Diện tích: " + triangle.getArea());

        scanner.close();
    }
}
