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
            for (Map.Entry<String, List<String>> item : hashMap.entrySet()) {
                if (item.getKey().equals(name)) System.out.println(name + ": " + item.getValue());
            }
        } else {
            System.out.println(name + " is not in the phonebook");
        }
    }
}
