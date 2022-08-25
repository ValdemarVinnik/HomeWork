package part_3.lesson_1.fruits;

public class Main {

    /**
     *
     *
     *  Задача:
     * a. Даны классы abstract Fruit, Apple extends Fruit, Orange extends Fruit;
     * b. Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу
     * фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
     * c. Для хранения фруктов внутри коробки можно использовать ArrayList;
     * d. Сделать в классе Box метод getWeight(), который высчитывает вес коробки по содержимому:
     *          вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
     * e. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую
     * коробку с той, которую подадут в compare() в качестве параметра. true – если их массы
     * равны, false в противоположном случае. Можно сравнивать коробки с яблоками и
     * апельсинами;
     * f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
     * Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
     * Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются
     * объекты, которые были в первой;
     * f*. Для усложнения, создать класс GoldenApple extends Apple
     * g. Не забываем про метод добавления фрукта в коробку.
     * g*. Метод из g должен принимать varargs: ...
     */

    public static void main(String[] args) {
        Box<Apple> box1 = new Box (new Apple(), new Apple(), new Apple(), new Orange());
       // box1.putInABox(new Orange());
        box1.putInABox(new GoldenApple());
        Box<Orange>box2 = new Box (new Orange(), new Orange() ,new Orange(),new Apple());
        //box2.putInABox(new Apple());

        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());

        System.out.println(box1.compare(box2));
        box1.pourFruitIntoAnotherBox(box2);
        System.out.println(box1.getWeight());
        System.out.println(box2.getWeight());
    }
}
