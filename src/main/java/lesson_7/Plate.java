package lesson_7;

import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NullType;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) throws Exception {
        if (food - n  < 0){
            System.out.println("food cannot be negative");
            return false;
        }
        food -= n;
        return true;
    }

    public void addFood(int anyFood) throws Exception {
        if (anyFood < 0){
            System.out.println("cannot be negative");
            return;
        }
            food +=anyFood;

    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
