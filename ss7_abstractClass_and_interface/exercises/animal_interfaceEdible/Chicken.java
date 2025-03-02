package exercises.animal_interfaceEdible;

public class Chicken  extends Animal implements IEdible {
    public String howtoEat(){
        return "Thóc";
    }
    public String makeSound(){
        return "I'm a chicken";
    }
}