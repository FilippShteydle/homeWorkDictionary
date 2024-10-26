package com.shteydle.top.homeWorkDictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryRepository {

    private static Map<String, Dictionary> dictionaryMap = new HashMap<>();

    public void saveWorld (String word, List<String> translations) {
        dictionaryMap.put(word, new Dictionary(word, translations));
    }

    public void printAllWorlds () {
        for (Dictionary dictionary : dictionaryMap.values()) {
            System.out.println(dictionary);
            dictionary.setCount();
        }
    }

    public void printWorld (String word) {
        System.out.println(dictionaryMap.get(word));
        getDictionary(word).setCount();
    }

    public Dictionary getDictionary (String word) {
        return dictionaryMap.get(word);
    }

}
