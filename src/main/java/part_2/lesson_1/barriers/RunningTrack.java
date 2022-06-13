package part_2.lesson_1.barriers;

import javax.print.DocFlavor;

public class RunningTrack extends Runner implements Barrier{

    public RunningTrack(int length) {
        super(length);
    }

    @Override
    public int getVolume() {
        return super.getLength();
    }
}
