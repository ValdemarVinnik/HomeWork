package part_2.lesson_1;

import part_2.lesson_1.barriers.Barrier;
import part_2.lesson_1.barriers.Runner;

public class Human implements Rush {
    private final String firstName;
    private final String lastName;
    private final int age;
    private boolean isScrewUp;
    private Barrier barrier;

    private final int RUNNING_LIMIT = 10;
    private final int JUMPING_LIMIT = 5;

    private final String SUCCESSFUL_RUNNING_INFORMATION = "успешно пробежал";
    private final String UNSUCCESSFUL_RUNNING_INFORMATION = "не смог пробежать";
    private final String SUCCESSFUL_JUMPING_INFORMATION = "успешно прыгнул";
    private final String UNSUCCESSFUL_JUMPING_INFORMATION = "не смог прыгнуть";


    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        isScrewUp = false;
    }

    public void setBarrier(Barrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        String message;

        if (isScrewUp) {
            return;
        }

        if (barrier instanceof Runner){
            message = barrier.getVolume() <= RUNNING_LIMIT? SUCCESSFUL_RUNNING_INFORMATION
                    : UNSUCCESSFUL_RUNNING_INFORMATION;

            System.out.println(String.format("Человек %s %s %s", firstName, lastName,message));
        }
    }

    @Override
    public void jump() {

    }

}
