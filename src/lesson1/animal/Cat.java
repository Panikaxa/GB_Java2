package lesson1.animal;

public class Cat extends Animal {

    public Cat(String name, int age, int ... level){
        super(name, age, level[0], level[1], 0);
        super.type = "Cat";
    }
}