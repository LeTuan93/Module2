class Point {
    private float x;
    private float y;
    public Point() {
        this.x = 0.0f;
        this.y = 0.0f;
    }
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float[] getXY() {
        return new float[]{x, y};
    }
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
class MovablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MovablePoint() {
        super(); // Gọi constructor của Point
        this.xSpeed = 0.0f;
        this.ySpeed = 0.0f;
    }

    public MovablePoint(float xSpeed, float ySpeed) {
        super(); // Gọi constructor của Point
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y); // Gọi constructor của Point
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{xSpeed, ySpeed};
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "), speed=(" + xSpeed + "," + ySpeed + ")";
    }

    public MovablePoint move() {
        setXY(getX() + xSpeed, getY() + ySpeed);
        return this;
    }
}
public class PointMovablePoint {
    public static void main(String[] args) {
        // Kiểm thử lớp Point
        System.out.println("Testing Point:");
        Point p1 = new Point();
        Point p2 = new Point(3.5f, 4.5f);

        System.out.println("Default Point: " + p1);
        System.out.println("Custom Point: " + p2);

        // Kiểm thử lớp MovablePoint
        System.out.println("\nTesting MovablePoint:");
        MovablePoint mp1 = new MovablePoint();
        MovablePoint mp2 = new MovablePoint(2.0f, 3.0f);
        MovablePoint mp3 = new MovablePoint(1.0f, 1.0f, 2.0f, 3.0f);

        System.out.println("Default MovablePoint: " + mp1);
        System.out.println("MovablePoint with speed: " + mp2);
        System.out.println("Full parameter MovablePoint: " + mp3);

        // Di chuyển điểm mp3
        System.out.println("Moving mp3...");
        mp3.move();
        System.out.println("After move: " + mp3);
    }
}
