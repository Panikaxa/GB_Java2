package lesson1.animal;

public class Dog extends Animal {

    public Dog(String name, int age, int ... level){
        super(name, age, level[0], level[1], level[2]);
        super.type = "Dog";
    }
}