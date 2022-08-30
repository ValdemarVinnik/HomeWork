package part_3.lesson_5.stages;

import part_3.lesson_5.Car;
import part_3.lesson_5.MainClass;
import part_3.lesson_5.stages.Stage;

import java.util.concurrent.CountDownLatch;

public class Tunnel extends Stage {
    private final int CAPACITY = MainClass.CARS_COUNT/2;
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        final CountDownLatch cdl = new CountDownLatch(CAPACITY);
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " +

                        description);

                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " +

                        description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

