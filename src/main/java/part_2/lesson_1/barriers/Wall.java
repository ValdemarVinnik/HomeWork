package part_2.lesson_1.barriers;

public class Wall extends Jumper implements Barrier  {
    public Wall(int capacity) {
        super(capacity);
    }

    @Override
    public int getVolume() {
        return super.getHeight();
    }
}
