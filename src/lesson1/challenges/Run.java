package lesson1.challenges;

import lesson1.animal.Animal;

public class Run extends Challenge{
    public Run(int level) {
        super("Run", level);
    }

    public void start(Animal animal){
        checkPass = animal.run(level);
    }
}