package part_3.lesson_5.stages;

import part_3.lesson_5.Car;
import part_3.lesson_5.MainClass;

import java.util.concurrent.CyclicBarrier;

public abstract class Stage {

    protected int length;
    protected String description;


    public abstract void go(Car c);
}
