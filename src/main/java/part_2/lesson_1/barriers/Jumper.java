package part_2.lesson_1.barriers;

public abstract class Jumper {
    private int height;

    public Jumper(int capacity) {
        this.height = capacity;
    }

    public int getHeight() {
        return height;
    }
}
