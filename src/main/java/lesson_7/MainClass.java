package lesson_7;


public class MainClass {
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{
                new Cat("Pushok", 4),
                new Cat("Begemot", 7),
                new Cat("Barsik", 5),
                new Cat("Murka", 3),
                new Cat("Kampot", 1)
        };

        Plate plate = new Plate(12);
        plate.info();

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.printCatCondition();
        }

        plate.info();
    }
}
