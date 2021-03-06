package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class Main {

    public static void main(String[] args){







        // Reading in CSV data for words.

        File wordList = new File("C:/Users/Dominik Hoffmann/" +
                "IdeaProjects/HangmanNew/src/WordList/most-common-nouns-english.csv");



        String word = WordReader.getRandomNoun(wordList);


        if(word != null){
            char[] guess = new char[word.length()];
            int chances = 6;
            int count = 0;
            List<Character> banned = new ArrayList<Character>();

            int charCounter = 0;






            while(count != chances){
                Scanner reader = new Scanner(System.in);
                System.out.println("Your guess (first character will count): ");
                char c = reader.next().charAt(0);

                // Casting down c if it's uppercase

                if(Character.isUpperCase(c)){
                    c = Character.toLowerCase(c);
                }






                // Checking if given char is alphabetic and wasn't already used if so it will get
                // on a banned list
                if(Character.isAlphabetic(c) && !banned.contains(c)){

                    // checking if the char occurs in the word
                    if(word.indexOf(c) == -1){
                        banned.add(c);
                        count++;
                    }


                    else{
                        // Iterating over word and adding chars in order at the right position in array
                        for(int i = 0; i < word.length(); i++){
                            if(word.charAt(i) == c){
                                guess[i] = c;
                                charCounter++;
                            }
                        }
                    }

                    for(int j = 0; j < guess.length; j++){
                        System.out.println(j + ": " + guess[j]);
                    }
                    // Eliminating chars of array display --- ?! More elegant solution !?
                    String guessS = Arrays.toString(guess);
                    if(guessS.contains(",") || guessS.contains("]") || guessS.contains("[")){
                        guessS = guessS.replace(",", "");
                        guessS = guessS.replace("[", "");
                        guessS = guessS.replace("]", "");
                        guessS = guessS.replace(" ", "");
                    }

                    if(charCounter == word.length()){
                        System.out.println("You won!");
                        break;
                    }




                    System.out.println(guessS);


                    System.out.println("You have " + (chances - count) + " trys left.");


                }
            }

            if(chances == count){
                System.out.println("The word was: " + word);
                System.out.println("You lost!");
            }


        }





















    }
}
