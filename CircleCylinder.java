//        +-----------------------------------------+
//        |   Circle                                |
//        +-----------------------------------------+
//        | - radius: double                        |
//        | - color: String                         |
//        +-----------------------------------------+
//        | + Circle()                              |
//        | + Circle(radius: double, color: String) |
//        | + getRadius(): double                   |
//        | + setRadius(radius: double): void       |
//        | + getColor(): String                    |
//        | + setColor(color: String): void         |
//        | + toString(): String                    |
//        +-----------------------------------------+
//                         ▲
//                         │ (extends)
//        +-----------------------------------------------------------+
//        |   Cylinder                                                |
//        +-----------------------------------------------------------+
//        | - height: double                                          |
//        +-----------------------------------------------------------+
//        | + Cylinder()                                              |
//        | + Cylinder(radius: double, color: String, height: double) |
//        | + getHeight(): double                                     |
//        | + setHeight(height: double): void                         |
//        | + getVolume(): double                                     |
//        | + toString(): String                                      |
//        +-----------------------------------------------------------+

class Circle {
    private double radius;
    private String color;
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
    }
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color;
    }
}

class Cylinder extends Circle {
    private double height;

    public Cylinder() {
        super(); // Gọi constructor của Circle
        this.height = 1.0;
    }
    public Cylinder(double radius, String color, double height) {
        super(radius, color); // Gọi constructor của Circle
        this.height = height;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return Math.PI * Math.pow(getRadius(), 2) * Math.pow(getHeight(), 2);
    }

    // Ghi đè toString()
    @Override
    public String toString() {
        return "Cylinder[radius=" + getRadius() + ", color=" + getColor() +
                ", height=" + height + ", volume=" + getVolume() + "]";
    }
}

public class CircleCylinder {
    public static void main(String[] args) {
        // Kiểm thử lớp Circle
        Circle c1 = new Circle();
        Circle c2 = new Circle(5.5, "blue");

        System.out.println("Testing Circle:");
        System.out.println(c1);
        System.out.println(c2);

        // Kiểm thử lớp Cylinder
        Cylinder cy1 = new Cylinder();
        Cylinder cy2 = new Cylinder(4.0, "green", 10.0);

        System.out.println("\nTesting Cylinder:");
        System.out.println(cy1);
        System.out.println(cy2);
    }
}

