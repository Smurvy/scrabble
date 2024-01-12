package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        prepareFile();




        String testSentence = "pactoun";

        String newSentence = "";


        ArrayList<Word> words = findWords(testSentence);

        for(int i =0; i < words.size();i++){
            System.out.println(words.get(i).getWord());
        }


    }




    public static ArrayList<Word> findWords(String hand){
        BufferedReader reader;
        ArrayList<Word> words = new ArrayList<>();
        // why did I write this
        // I have to seed the list a beginning value
        words.add(new Word("null", Integer.MIN_VALUE));


        try {
            reader = new BufferedReader(new FileReader("/Users/rileymotylinski/Documents/APCSA/scrabble/output.txt"));
            String line = reader.readLine();

            while (line != null) {

                if(isAnagram(hand,line)){
                    int score = Letters.scoreWord(line);

                    for(int i = 0; i < words.size();i++){
                        if(score > words.get(i).getScore()){
                            words.add(i,new Word(line,score));
                            break;
                        }
                    }
                }
                // read next line
                line = reader.readLine();

            }
            // words.remove(words.size() - 1);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }

    public static boolean isAnagram(String hand, String word) {
        if(hand.length() < word.length()){
            return false;
        }

        for(int i = 0; i < hand.length(); i++){
            String currentChar = hand.substring(i,i+1);
            if(word.contains(currentChar)){
                word = word.substring(0,word.indexOf(currentChar)) + word.substring(word.indexOf(currentChar) + 1);
            }
        }
        return word.length() == 0;

    }

    // see if a letter exists at a certain index position
    public static boolean lettersInWords(String word, String[] letters, int[] pos){
        for(int i = 0; i < letters.length;i++){
            if(!(word.substring(pos[i],pos[i]+1).equals(letters[i]))){
                return false;
            }
        }
        return true;
    }

    public static void prepareFile() throws IOException {
        BufferedReader reader;
        FileWriter output = new FileWriter("output.txt");

        // check if word has all the same letters NOT if you can rearrange hand
        // count letters in hand
        // -> take most abundant letter
        // -> compare that against count of

        try {
            reader = new BufferedReader(new FileReader("/Users/rileymotylinski/Downloads/Collins.txt"));
            String line = reader.readLine();


            while (line != null) {
                output.write(line.toLowerCase() + "\n");
                line = reader.readLine();

            }


            output.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
