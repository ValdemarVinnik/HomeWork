package lesson_6;

public abstract class Animal {

    protected static int count;
    protected String name;
    protected int runningRestriction;
    protected int swimmingRestriction;

    public Animal(){}

    public Animal(String name) {

        this.name = name;
        ++count;
    }

    public void run(int distance){
        if (distance > runningRestriction){
            printFormatMessage("%s скорее издохнет чем пробежит %d m.",distance);
        }else {
            printFormatMessage("%s пробежал %d m.",distance);
        }
    }

    public void swim(int distance){
        if (distance > swimmingRestriction){
            printFormatMessage("%s скорее издохнет чем проплывёт %d m.",distance);
        }else {
            printFormatMessage("%s проплыл(а) %d m.",distance);
        }
    }

    protected void printFormatMessage(String message, int distance){
        System.out.println(String.format(message,name,distance));
    }

    public static int numberOfInstances(){return count;}
}
