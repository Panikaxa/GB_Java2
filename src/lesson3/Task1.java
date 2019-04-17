package lesson3;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        String[] wordArray = {"Apricot", "Avocado", "Pineapple", "Orange", "Banana", "Grape", "Cherry", "Pear", "Melon",
                "Kiwi", "Apricot", "Avocado", "Orange", "Apricot", "Avocado", "Apricot", "Apricot", "Avocado", "Lemon"};

        System.out.println("***********Display original array*****************");
        for (String element : wordArray) {
            System.out.print(element + " ");
        }

        System.out.println();
        System.out.println("***********Display unique words*****************");
        Set<String> uniqueList = new TreeSet<>(Arrays.asList(wordArray));
        for (String uniqueElement : uniqueList) {
            System.out.print(uniqueElement + " ");
        }

        System.out.println();
        System.out.println("***********Display the number of duplicates*****************");
        Map<String, Integer> hashMap = new HashMap<>();
        for (String word : wordArray) {
            hashMap.put(word, hashMap.get(word) == null ? 1 : hashMap.get(word) + 1);
        }
        System.out.println(hashMap);
    }
}
