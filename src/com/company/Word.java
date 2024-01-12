package com.company;

public class Word extends Letter{
    public Word(String word, int score){
        this.word = word;
        this.score = score;
        this.letter = 'n';
    }

    public String getWord(){
        return this.word;
    }

}
