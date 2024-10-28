package com.shteydle.top.homeWorkDictionary;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

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


    public void setTranslations(List<String> translations) {
        this.translations = translations;
    }

    public void setCount() {
        count++;
    }

    @Override
    public String toString() {
        return word + ": " + translations + " (" + count + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary that = (Dictionary) o;
        return count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(count);
    }
}
