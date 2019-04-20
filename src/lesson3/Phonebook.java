package lesson3;

import java.util.*;

public class Phonebook {
    private Map<String, List<String>> hashMap;

    public Phonebook(){
        hashMap = new HashMap<>();
    }

    public void add(String name, String phone){
        hashMap.computeIfAbsent(name, k -> new ArrayList<>()).add(phone);
    }

    public void get(String name){
        if (hashMap.containsKey(name)) {
            System.out.println(name + " " + hashMap.get(name).toString());
        } else {
            System.out.println(name + " is not in the phonebook");
        }
    }
}
