package com.company;

import java.io.*;
import java.util.Scanner;



public class Main {

    public static void main(String[] args){




        File wordList = new File("C:/Users/Dominik Hoffmann/" +
                "IdeaProjects/HangmanNew/src/WordList/most-common-nouns-english.csv");



        String word = WordReader.getRandomNoun(wordList);
        System.out.println(word);

        if(word != null){
            char[] guess = new char[word.length()];
            int chances = 6;
            int count = 0;

            while(count != chances){
                Scanner reader = new Scanner(System.in);
                char c = reader.next().charAt(0);
                System.out.println(Character.isAlphabetic(c));


                if(word.indexOf(c) == -1){
                    count++;
                }
                else{




                }








            }


        }





















    }
}
