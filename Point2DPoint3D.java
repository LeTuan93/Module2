class Point2D {
    private float x;
    private float y;

    // Constructor mặc định
    public Point2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    // Constructor có tham số
    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Getter & Setter cho x
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    // Getter & Setter cho y
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    // Đặt cả x và y
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Lấy mảng chứa x và y
    public float[] getXY() {
        return new float[]{x, y};
    }

    // Ghi đè phương thức toString
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
class Point3D extends Point2D {
    private float z;

    // Constructor mặc định
    public Point3D() {
        super(); // Gọi constructor của Point2D
        this.z = 0.0f;
    }

    // Constructor có tham số
    public Point3D(float x, float y, float z) {
        super(x, y); // Gọi constructor của Point2D
        this.z = z;
    }

    // Getter & Setter cho z
    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    // Đặt cả x, y và z
    public void setXYZ(float x, float y, float z) {
        setXY(x, y); // Gọi phương thức setXY của lớp cha
        this.z = z;
    }

    // Lấy mảng chứa x, y và z
    public float[] getXYZ() {
        return new float[]{getX(), getY(), z};
    }

    // Ghi đè phương thức toString
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + z + ")";
    }
}
public class Point2DPoint3D {
    public static void main(String[] args) {
        // Kiểm thử lớp Point2D
        System.out.println("Testing Point2D:");
        Point2D p2d_1 = new Point2D();
        Point2D p2d_2 = new Point2D(3.5f, 4.5f);

        System.out.println("Default Point2D: " + p2d_1);
        System.out.println("Custom Point2D: " + p2d_2);

        // Kiểm thử lớp Point3D
        System.out.println("\nTesting Point3D:");
        Point3D p3d_1 = new Point3D();
        Point3D p3d_2 = new Point3D(1.2f, 3.4f, 5.6f);

        System.out.println("Default Point3D: " + p3d_1);
        System.out.println("Custom Point3D: " + p3d_2);

        // Thay đổi giá trị của p3d_2
        p3d_2.setXYZ(7.8f, 9.0f, 10.2f);
        System.out.println("Updated Point3D: " + p3d_2);
    }
}
