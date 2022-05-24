package part_2.lesson_1.persons;

import part_2.lesson_1.barriers.Barrier;
import part_2.lesson_1.barriers.Jumper;
import part_2.lesson_1.barriers.Runner;

import static java.lang.StrictMath.abs;

public class Human implements Movable {
    private final String firstName;
    private final String lastName;
    private final int age;
    private boolean isScrewUp;
    private Barrier barrier;

    private final int RUNNING_LIMIT;
    private final int JUMPING_LIMIT;

    public Human(String firstName, String lastName, int age, int RUNNING_LIMIT, int JUMPING_LIMIT) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.RUNNING_LIMIT = abs(RUNNING_LIMIT);
        this.JUMPING_LIMIT = abs(JUMPING_LIMIT);
    }

    @Override
    public void setBarrier(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public Barrier getBarrier() {
        return barrier;
    }

    @Override
    public void run() {
        boolean isHeCan = barrier.getVolume() <= RUNNING_LIMIT;
        String message = null;

        if (isScrewUp || barrier == null) {
            return;
        }

        if (barrier instanceof Runner) {
            message = isHeCan ? SUCCESSFUL_RUNNING_INFORMATION
                    : UNSUCCESSFUL_RUNNING_INFORMATION;

            printResult(message);
        }

        if (!isHeCan) {
            isScrewUp = true;
        }
    }

    @Override
    public void jump() {

        String message = null;
        boolean isHeCan = barrier.getVolume() <= JUMPING_LIMIT;

        if (isScrewUp || barrier == null) {
            return;
        }

        if (barrier instanceof Jumper) {
            message = isHeCan ? SUCCESSFUL_JUMPING_INFORMATION
                    : UNSUCCESSFUL_JUMPING_INFORMATION;

            printResult(message);
        }

        if (!isHeCan) {
            isScrewUp = true;
        }
    }

    private void printResult(String message) {
        System.out.println(String.format("Человек %s %s %s ", firstName, lastName, message));
    }
}


