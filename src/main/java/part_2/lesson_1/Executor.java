package part_2.lesson_1;
/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий.
4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
препятствий не идет.
 */

import part_2.lesson_1.barriers.*;
import part_2.lesson_1.persons.Cat;
import part_2.lesson_1.persons.Human;
import part_2.lesson_1.persons.Movable;
import part_2.lesson_1.persons.Robot;

public class Executor {

    public void movabelePersonsPassBarriers(Movable[] persons, Barrier[] barriers) {

        if (persons == null || barriers == null || persons.length == 0 || barriers.length == 0) {
            throw new NullPointerException("Wrong parameters");
        }

        for (Barrier barrier : barriers) {
            for (Movable person : persons) {

                person.setBarrier(barrier);
                personAction(person);
            }
        }
    }

    private void personAction(Movable person) {
        if (person.getBarrier() instanceof Runner) {
            person.run();
            return;
        }

        if (person.getBarrier() instanceof Jumper) {
            person.jump();
        }
    }

    public static void main(String[] args) {

        Movable[] persons = {
                new Human("Vladzimir", "Vinnik", 81, 1, 2),
                new Cat("Barsik", -5, -3),
                new Robot("Terminator",30, 40)
        };

        Barrier[] barriers = {
                new Wall(1),
                new RunningTrack(2),
                new Wall(2),
                new RunningTrack(3),
                new Wall(3),
                new RunningTrack(4),
                new Wall(6),
                new RunningTrack(6),
                new Wall(10),
                new RunningTrack(14),
        };

        new Executor().movabelePersonsPassBarriers(persons,barriers);
    }
}
