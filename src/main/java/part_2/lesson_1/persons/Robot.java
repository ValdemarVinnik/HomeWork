package part_2.lesson_1.persons;

import part_2.lesson_1.barriers.Barrier;
import part_2.lesson_1.barriers.Jumper;
import part_2.lesson_1.barriers.Runner;

import static java.lang.StrictMath.abs;

public class Robot implements Movable {
    private String model;
    private boolean isScrewUp;
    private Barrier barrier;

    private final int RUNNING_LIMIT;
    private final int JUMPING_LIMIT;

    public Robot(String model, int RUNNING_LIMIT, int JUMPING_LIMIT) {
        this.model = model;
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
        String message = null;

        if (isScrewUp || barrier == null) {
            return;
        }

        if (barrier instanceof Runner){
            message = barrier.getVolume() <= RUNNING_LIMIT? SUCCESSFUL_RUNNING_INFORMATION
                    : UNSUCCESSFUL_RUNNING_INFORMATION;

            printResult(message);
        }

        if (message.equals(UNSUCCESSFUL_RUNNING_INFORMATION)) {
            isScrewUp = true;
        }
    }

    @Override
    public void jump() {
        String message;

        if (isScrewUp || barrier == null) {
            return;
        }

        if (barrier instanceof Jumper){
            message = barrier.getVolume() <= JUMPING_LIMIT? SUCCESSFUL_JUMPING_INFORMATION
                    : UNSUCCESSFUL_JUMPING_INFORMATION;

            printResult(message);
        }
    }
    private void printResult(String message){
        System.out.println(String.format("Робот  %s %s ", model, message));
    }
}
