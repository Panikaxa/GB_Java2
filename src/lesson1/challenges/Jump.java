package lesson1.challenges;

import lesson1.animal.Animal;

public class Jump extends Challenge{
    public Jump(int level) {
        super("Jump", level);
    }

    public void start(Animal animal){
        checkPass = animal.jump(level);
    }
}