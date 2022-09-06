package part_3.lesson_5;

import part_3.lesson_5.stages.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Race {

    private int CARS_COUNT;


    protected CountDownLatch cdl;
    protected ReentrantLock reentrantLock;
    protected CyclicBarrier cyclicBarrier;
    protected Semaphore semaphore;
    private ArrayList<Stage> stages;

    public Race(int CARS_COUNT, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.CARS_COUNT = CARS_COUNT;
        cdl = new CountDownLatch(CARS_COUNT);
        reentrantLock = new ReentrantLock();
        cyclicBarrier = new CyclicBarrier(CARS_COUNT + 1);
        semaphore = new Semaphore(CARS_COUNT / 2);
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public CyclicBarrier getCyclicBarrier() {
        return cyclicBarrier;
    }

    public CountDownLatch getCdl() {
        return cdl;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public ReentrantLock getReentrantLock() {
        return reentrantLock;
    }
}