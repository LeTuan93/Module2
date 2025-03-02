package exercises.animal_interfaceEdible;

public class Orange extends Fruit{
    public String howtoEat(){
        return "Orange";
    }
}

//Dynamic binding là cơ chế gọi nội dung lớp con khi mà lớp con ghi đè lại phương thức lớp cha