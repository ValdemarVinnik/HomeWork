package part_3.lesson_1.fruits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Box <T extends Fruit>{
   private List<T> list = new ArrayList<>();

    public Box(T...fruit) {
        Collections.addAll(list, fruit);
    }

    public Box() {
    }

    public  void putInABox(T ... fruit){
         Arrays.stream(fruit).forEach(e -> list.add(e));
    }

    public float getWeight(){

        return (float)list.stream().map(Fruit::getWeight).count();
    }
}
