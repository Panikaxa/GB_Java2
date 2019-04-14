package lesson1.animal;

public enum Sex {
    MALE("male"), FEMALE;

    private String name;

    Sex(String name) {
        this.name = name;
    }

    Sex() {
    }

    public String getName() {
        return name;
    }
}