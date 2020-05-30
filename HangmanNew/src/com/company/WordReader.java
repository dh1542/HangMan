package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordReader {


    /**
     * Will get you a random word from a CSV-file
     * @param file
     * @return  word(String)
     */



    public static String getRandomNoun(File file){

        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String word;
            List<String> wordlist = new ArrayList<String>();

            while((word = reader.readLine()) != null){
                String[] words = word.split(",");

                for(int i = 0; i < words.length; i++){
                    /*
                     Checking if the word contains a dot or unwanted chars which
                     are unnatural in English words

                     (It's possible to add more exceptions if the provided CSV file
                     has inadequate chars in its words)
                     */
                    if(words[i].indexOf('.') !=  -1){

                            words[i] = words[i].replace(".", "");
                    }
                    wordlist.add(words[i]);
                }
            }



            int rdm = getRandomNumberInRange(0, wordlist.size());

            String out = wordlist.get(rdm);

            return out;

        }catch(Exception e){
            System.out.println(e);
            return null;




        }

    }


    /**
     * Gives you a random integer between min and max
     * @param min
     * @param max
     * @return random number (int)
     */

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }




}
