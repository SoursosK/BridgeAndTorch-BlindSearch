
public class Person {
    String name;
    Side side;
    int timeToCross;

    public Person(String name, int timeToCross) {
        this.timeToCross = timeToCross;
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}