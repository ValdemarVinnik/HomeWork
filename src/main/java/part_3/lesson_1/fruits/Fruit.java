package part_3.lesson_1.fruits;

 public abstract class Fruit {
    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getWeight(){
        return this.weight;
    }
}
