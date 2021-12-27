package Homework4;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){
        System.out.println("1. Уникальные слова:");
        String[] strings = {"Кино", "Слон", "День", "Кино", "Слон", "Кино", "День", "Окно", "Кино"};
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < strings.length; i++){
            if(!hashMap.containsKey(strings[i])){
                hashMap.put(strings[i], 1);
            }else hashMap.put(strings[i], hashMap.get(strings[i])+ 1);
        }
        System.out.println(hashMap);
        System.out.println();

        System.out.println("2. Телефонный спаровчник:");
        Phonebook phonebook = new Phonebook();
        phonebook.add("Rick", "123452354");
        phonebook.add("Morty", "9765865453");
        phonebook.add("Sam", "90128347");
        phonebook.add("Deil", "12764");
        phonebook.add("Rick", "098237");
        phonebook.add("Cat", "012398");
        phonebook.add("Rick", "198237419874");

        System.out.println(phonebook.get("Rick"));
    }
}
