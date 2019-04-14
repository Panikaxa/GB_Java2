package lesson1.animal;

public class Human extends Animal {

    private Sex sex;

    public Human(String name, int age, Sex sex, int ... level){
        super(name, age, level[0], level[1], level[2]);
        this.sex = sex;
        super.type = "Human";
    }

    @Override
    public void info(){
        System.out.println(type + " - Name: " + name + ", Age: " + age + ", Sex: " + sex);
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}