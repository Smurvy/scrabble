package com.company;

public class Letter {
    protected char letter;
    protected int score;
    protected String word;

    public Letter(char letter, int score){
        this.letter = letter;
        this.score = score;
        this.word = "null";
    }

    public Letter(){
        this.letter = 'n';
        this.score = 0;
        this.word = null;
    }



    public char getLetter(){
        return this.letter;
    }

    public int getScore(){
        return this.score;
    }

}
