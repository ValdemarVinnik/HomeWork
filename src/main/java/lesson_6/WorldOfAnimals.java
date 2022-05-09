package lesson_6;

import java.util.Arrays;

public class WorldOfAnimals {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
                new Cat ("Murka"),
                new Dog ("Tuzic"),
                new Cat ("Pushok"),
                new Dog ("Tuman")
        };

        Arrays.stream(animals).forEach((e)->e.run(250));
        Arrays.stream(animals).forEach((e)->e.swim(9));

        System.out.printf("Созданно %d животных душ...",Animal.numberOfInstances());

    }
}
