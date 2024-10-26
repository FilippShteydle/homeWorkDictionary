package com.shteydle.top.homeWorkDictionary;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        DictionaryRepository repository = new DictionaryRepository();
        DictionaryService service = new DictionaryService();

        service.addWord("Spring", List.of("Весна", "Лето", "Зима"));
        service.addTranslationWord("Spring", List.of("Весна2", "Лето2", "Зима2"));
        service.addWord("Summer", List.of("Весна", "Лето", "Зима"));
        service.addWord("Winter", List.of("Весна", "Лето", "Зима"));

        repository.printWorld("Spring");

        System.out.println(repository.getDictionary("Spring").getCount());
        System.out.println(repository.getDictionary("Summer").getCount());

        service.replaceTranslationWord("Spring", "Весна2", "Весна3");
        repository.printWorld("Spring");
        service.removeTranslationWord("Spring", "Зима2");
        service.removeTranslationWord("Spring", List.of("Лето", "Лето2"));

        repository.printWorld("Spring");
    }
}