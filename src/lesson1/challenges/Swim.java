package lesson1.challenges;

import lesson1.animal.Animal;

public class Swim extends Challenge{

    public Swim(int level) {
        super("Swim", level);
    }

    public void start(Animal animal){
        checkPass = animal.swim(level);
    }
}