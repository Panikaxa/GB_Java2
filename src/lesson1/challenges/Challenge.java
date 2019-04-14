package lesson1.challenges;

import lesson1.animal.Animal;

public abstract class Challenge {
    protected String name;
    protected int level;
    protected  boolean checkPass;

    public Challenge(String name, int level) {
        this.name = name;
        this.level = level;
        checkPass = false;
    }

    public String getName() {
        return name;
    }

    public boolean isCheckPass() {
        return checkPass;
    }

    public abstract void start(Animal animal);
}