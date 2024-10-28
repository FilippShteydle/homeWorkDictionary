package com.shteydle.top.homeWorkDictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DictionaryRepository {

    public static Map<String, Dictionary> dictionaryMap = new HashMap<>();

    /**
     * Сохраняет слово в словаре
     * @param word
     * @param translations
     */
    public void saveWorld (String word, List<String> translations) {
        dictionaryMap.put(word, new Dictionary(word, translations));
    }

    /**
     * Печатает весь словарь
     */
    public void printAllWorlds () {
        for (Dictionary dictionary : dictionaryMap.values()) {
            System.out.println(dictionary);
            dictionary.setCount();
        }
    }

    /**
     * Печетает перевод заданного слова
     * @param word слово, переод которого нужен
     */
    public void printWorld (String word) {
        System.out.println(dictionaryMap.get(word));
        getDictionary(word).setCount();
    }

    /**
     * возвращает слово и его перевод
     * @param word
     * @return
     */
    public Dictionary getDictionary (String word) {
        return dictionaryMap.get(word);
    }

}
