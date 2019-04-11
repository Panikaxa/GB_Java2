package lesson1.animal;

import lesson1.interfaces.Jumpable;
import lesson1.interfaces.Runable;
import lesson1.interfaces.Swimable;

public abstract class Animal implements Runable, Jumpable, Swimable {
    protected String name;
    protected String type;
    protected int age;
    protected int levelRun;
    protected int levelJump;
    protected int levelSwim;

    public Animal (String name, int age, int ... level){
        this.name = name;
        this.age = age;
        this.levelRun = level[0];
        this.levelJump = level[1];
        this.levelSwim = level[2];
    }

    @Override
    public boolean run(int level) {
        return level <= levelRun;
    }

    @Override
    public boolean jump(int level) {
        return level <= levelJump;
    }

    @Override
    public boolean swim(int level) {
        return level <= levelSwim;
    }

    public void info(){
        System.out.println(type + " - Name: " + name + ", Age: " + age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }
}