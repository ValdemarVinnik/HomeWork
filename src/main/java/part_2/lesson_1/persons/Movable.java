package part_2.lesson_1.persons;

import part_2.lesson_1.barriers.Barrier;

public interface Movable {
    String SUCCESSFUL_RUNNING_INFORMATION = "успешно пробежал";
    String UNSUCCESSFUL_RUNNING_INFORMATION = "не смог пробежать";
    String SUCCESSFUL_JUMPING_INFORMATION = "успешно прыгнул";
    String UNSUCCESSFUL_JUMPING_INFORMATION = "не смог прыгнуть";

    void setBarrier(Barrier barrier);

    Barrier getBarrier();

    void run();

    void jump();
}
