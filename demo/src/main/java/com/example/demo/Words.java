package com.example.demo;

import java.util.Objects;

public class Words {

    private String word;
    private Integer count;

    public Words(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public void incrementCount()
    {
        this.count++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Words words = (Words) o;
        return Objects.equals(word, words.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, count);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
