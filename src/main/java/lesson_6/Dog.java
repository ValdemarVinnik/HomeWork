package lesson_6;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        this.runningRestriction = 500;
        this.swimmingRestriction = 10;
    }
}
