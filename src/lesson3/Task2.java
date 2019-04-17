package lesson3;

public class Task2 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add("Ivanov", "11-22-33");
        phonebook.add("Ivanov", "11-22-44");
        phonebook.add("Ivanov", "11-22-66");
        phonebook.add("Petrov", "11-22-55");

        phonebook.get("Ivanov");
        phonebook.get("Petrov");
        phonebook.get("Sidorov");
    }
}
