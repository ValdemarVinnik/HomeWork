package part_2.lesson_5;

public class MyThreadArrayExecutor extends Thread {
    private float[] array;

    public void setArray(float[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i
                    / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
