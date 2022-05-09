package lesson_7;

public class Plate {
    private int food;

    public int getFood() {
        return food;
    }

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void addFood(int anyFood){
        food +=anyFood;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
