package com.shteydle.top.homeWorkDictionary;

import java.util.*;

public class DictionaryService {

    DictionaryRepository dictionaryRepository = new DictionaryRepository();

    /**
     * Обеспечивает начальный ввод данных для словаря.
     * @param word
     * @param translation
     */
    public void addWord(String word, List<String> translation) {
        dictionaryRepository.saveWorld(word, translation);
    }

    /**
     * Позволяет добавить переводы слова.
     * @param word начальное слово
     * @param translation перевод преданного слова
     */
    public void addTranslationWord(String word, List<String> translation) {
        List<String> list = new ArrayList<String>();
        list.addAll(dictionaryRepository.getDictionary(word).getTranslations());
        list.addAll(translation);
        dictionaryRepository.getDictionary(word).setTranslations(list);
        dictionaryRepository.getDictionary(word).setCount();
    }

    /**
     * Позволяет заменить переводы слова
     * @param word слово, у которого необходимо заменить перевод
     * @param oldTranslation старое слово
     * @param newTranslation новое слово
     */
    public void replaceTranslationWord(String word, String oldTranslation, String newTranslation) {
        List<String> translation = dictionaryRepository.getDictionary(word).getTranslations();
        for (int i  = 0; i < translation.size(); i++) {
            if (translation.get(i).equals(oldTranslation)) {
                translation.set(i, newTranslation);
            }
        }
        dictionaryRepository.getDictionary(word).setCount();
    }

    /**
     * Позволяет удалить переводы слова
     * @param word слово, у которого надо удалить перевод
     * @param translation слово перевода, уоторое необходимо удалить
     */
    public void removeTranslationWord(String word, String translation) {
        List<String> translat = dictionaryRepository.getDictionary(word).getTranslations();
        translat.remove(translation);
        dictionaryRepository.getDictionary(word).setCount();
    }

    /**
     * Позволяет удалить переводы слова
     * @param word слово, у которого надо удалить перевод
     * @param translation слова перевода, уоторое необходимо удалить
     */
    public void removeTranslationWord(String word, List<String> translation) {
        List<String> translat = dictionaryRepository.getDictionary(word).getTranslations();

        for (int i  = 0; i < translation.size(); i++) {
            if (translat.contains(translation.get(i))) {
                translat.remove(translation.get(i));
            }
        }
        dictionaryRepository.getDictionary(word).setCount();
    }

    /**
     * Позволяет удалить слово.
     * @param word слово, которое надо удалить
     */
    public void removeWord(String word) {
        DictionaryRepository.dictionaryMap.remove(word);
    }

    /**
     * Позволяет заменить слово.
     * @param oldWord старое слово
     * @param newWord новое слово
     */
    public void replaceWord(String oldWord, String newWord) {
        List<String> translation = dictionaryRepository.getDictionary(oldWord).getTranslations();
        DictionaryRepository.dictionaryMap.remove(oldWord);
        addWord(newWord, translation);
    }

    private List<String> sortWords() {
        List<String> words = new ArrayList<>();
        List<Dictionary> dictionaries = new ArrayList<>();
        words.addAll(DictionaryRepository.dictionaryMap.keySet());
        for (int i = 0; i < words.size(); i++) {
            dictionaries.add(dictionaryRepository.getDictionary(words.get(i)));
        }
        for (int i = 0; i < dictionaries.size(); i++) {
            int value = dictionaries.get(i).getCount();
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < dictionaries.get(j).getCount()) {
                    words.set(j + 1, dictionaries.get(j).getWord());
                } else {
                    break;
                }
            }
            words.set(j + 1, dictionaries.get(i).getWord());
        }
        return words;
    }

    /**
     * Отображает топ-10 самых популярных слов
     */
    public void showTop10() {
        List<String> words = sortWords();
        int n = 10;
        if (words.size() < 10) {
            n = words.size();
        }
        System.out.println("Топ популярных слов");
        for (int i = 0; i < n; i++) {
            System.out.println(words.get(i));
        }
    }

    /**
     * Отображает топ-10 самых непопулярных слов
     */
    public void showNotPopulatedWords() {
        List<String> words = sortWords();
        int n = 10;
        if (words.size() < 10) {
            n = words.size();
        }
        System.out.println("Топ не популярных слов");
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(words.get(i));
        }
    }

}
