package com.shteydle.top.homeWorkDictionary;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

public class DictionaryService {

    DictionaryRepository dictionaryRepository = new DictionaryRepository();

    public void addWord(String word, List<String> translation) {

        dictionaryRepository.saveWorld(word, translation);
    }

    public void addTranslationWord(String word, List<String> translation) {
        List<String> list = new ArrayList<String>();
        list.addAll(dictionaryRepository.getDictionary(word).getTranslations());
        list.addAll(translation);
        dictionaryRepository.getDictionary(word).setTranslations(list);
        dictionaryRepository.getDictionary(word).setCount();
    }

    public void replaceTranslationWord(String word, String oldTranslation, String newTranslation) {
        List<String> translation = dictionaryRepository.getDictionary(word).getTranslations();
        for (int i  = 0; i < translation.size(); i++) {
            if (translation.get(i).equals(oldTranslation)) {
                translation.set(i, newTranslation);
            }
        }
        dictionaryRepository.getDictionary(word).setCount();
    }

    public void removeTranslationWord(String word, String translation) {
        List<String> translat = dictionaryRepository.getDictionary(word).getTranslations();
        translat.remove(translation);
        dictionaryRepository.getDictionary(word).setCount();
    }

    public void removeTranslationWord(String word, List<String> translation) {
        List<String> translat = dictionaryRepository.getDictionary(word).getTranslations();

        for (int i  = 0; i < translation.size(); i++) {
            if (translat.contains(translation.get(i))) {
                translat.remove(translation.get(i));
            }
        }
        dictionaryRepository.getDictionary(word).setCount();
    }

}
