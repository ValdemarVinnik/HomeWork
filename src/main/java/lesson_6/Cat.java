package lesson_6;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        this.runningRestriction = 200;
        this.swimmingRestriction = 0;
    }
}
