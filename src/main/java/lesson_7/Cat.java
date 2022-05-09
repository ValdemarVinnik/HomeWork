package lesson_7;

public class Cat {
    private String name;
    private int appetite;
    private boolean wellFed;

    public boolean isWellFed() {
        return wellFed;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.getFood() < appetite){
            return;
        }
        p.decreaseFood(appetite);

        this.appetite = 0;
        wellFed = true;
    }

    public void printCatCondition(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("Кот %s - %s",name, wellFed? "сыт":"голоден");
    }
}
