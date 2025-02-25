class Cirble {
    private double radius = 1.0;
    private String color = "red";
    public void Cirble() {}
    public void Circle(double r){
        this.radius = r;
    }
    public double getRadius(){
        return radius;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }
}


public class TestCircle {
    public static void main(String[] args) {
        Cirble c = new Cirble();
        System.out.println(c.getArea());
    }
}
