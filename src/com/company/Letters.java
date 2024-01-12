package com.company;

public class Letters {
    // jesus christ, please fix this
    public final static Letter[] letters = {
            new Letter('a', 1),
            new Letter('b', 3),
            new Letter('c', 3),
            new Letter('d', 2),
            new Letter('e', 1),
            new Letter('f', 4),
            new Letter('g', 2),
            new Letter('h', 4),
            new Letter('i', 1),
            new Letter('j', 8),
            new Letter('k', 5),
            new Letter('l', 1),
            new Letter('m', 3),
            new Letter('n', 1),
            new Letter('o', 1),
            new Letter('p', 3),
            new Letter('q', 10),
            new Letter('r', 1),
            new Letter('s', 1),
            new Letter('t', 1),
            new Letter('u', 1),
            new Letter('v', 4),
            new Letter('w', 4),
            new Letter('x', 8),
            new Letter('y', 4),
            new Letter('z', 10),
    };

    private static int scoreLetter(char c){
        for(int i = 0; i < letters.length;i++){
            if (letters[i].getLetter() == c){
                return letters[i].getScore();
            }
        }
        return 0;
    }


    public static int scoreWord(String word){
        int score = 0;
        for(int i = 0; i < word.length(); i++){
            score += scoreLetter(word.charAt(i));
        }
        return score;
    }
}
