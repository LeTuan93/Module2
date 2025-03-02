package practise.colorable;

public class Square extends Shape{
    private double canh = 1.0;

    public Square() {}
    public Square(double canh) {
        this.canh = canh;
    }

    public double getArea()
    {
        return canh*canh;
    }

    public void howToColor(){
        System.out.println("Color all four sides");
    }
}
