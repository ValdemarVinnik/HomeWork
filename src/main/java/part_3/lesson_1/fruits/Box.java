package part_3.lesson_1.fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> list = new ArrayList<>();

    public Box(T... fruit) {
        list.addAll(Arrays.asList(fruit));

    }

    public Box() {
    }

    public void putInABox(T... fruit) {
        Arrays.stream(fruit).forEach(e -> list.add(e));
    }

    public float getWeight() {
        float count = 0f;
        for (T each : list) {
            count = count + each.getFruitWeight();
        }
        return count;
    }


    public boolean compare(Box box) {
        return (this.getWeight() == box.getWeight());
    }

    public boolean cleanTheBox() {
        list.clear();
        return list.isEmpty();
    }

    public void pourFruitIntoAnotherBox(Box box) {
        if (box.cleanTheBox()) {
            this.giveContent().forEach(e -> {
                box.putInABox((T) e);
            });
        }
        this.cleanTheBox();
    }

    public List<T> giveContent() {
        return list;
    }
}
