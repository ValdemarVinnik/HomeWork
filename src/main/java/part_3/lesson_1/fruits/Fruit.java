package part_3.lesson_1.fruits;

 public abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getFruitWeight(){
        return this.weight;
    }
}
