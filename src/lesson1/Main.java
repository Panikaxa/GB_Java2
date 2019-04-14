package lesson1;

import lesson1.animal.*;

public class Main {

    public static void main(String[] args) {
        Animal cat = new Cat("Vasya", 5, 100, 1);
        Animal dog = new Dog("Petya", 3, 500, 2, 100);
        Animal human1 = new Human("Kolya", 18, Sex.MALE, 1000, 2, 500);
        Animal human2 = new Human("Dasha", 25, Sex.FEMALE, 800, 1, 400);

        Team team = new Team("Animals", cat, dog, human1, human2);
        team.infoTeamMember();

        Course course = new Course();
        course.doIt(team);
        course.showResult(team);
    }
}