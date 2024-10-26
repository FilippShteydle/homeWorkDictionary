package com.shteydle.top.homeWorkDictionary;

import java.util.List;

public class Dictionary {
    private String word;
    private List<String> translations;
    private int count;

    public Dictionary(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
        count = 0;
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return word + ": " + translations;
    }

    public void setCount() {
        count++;
    }

    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }
}
