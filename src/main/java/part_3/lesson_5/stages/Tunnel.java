package part_3.lesson_5.stages;

import part_3.lesson_5.Car;
import part_3.lesson_5.MainClass;
import part_3.lesson_5.stages.Stage;

import java.util.concurrent.CountDownLatch;

public class Tunnel extends Stage {

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {

        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " +

                        description);
                c.getRace().getSemaphore().acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " +

                        description);
                c.getRace().getSemaphore().release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

