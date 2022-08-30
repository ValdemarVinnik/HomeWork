package part_3.lesson_5.stages;

import part_3.lesson_5.Car;

import java.util.concurrent.CyclicBarrier;

public abstract class Stage {
    protected int COUNT_OF_RACERS;
    protected int length;
    protected String description;
    protected CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT_OF_RACERS);
    public String getDescription() {
        return description;

    }
    public abstract void go(Car c);
}
