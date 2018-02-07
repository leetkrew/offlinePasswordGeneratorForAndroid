package com.rjregalado.offlinepasswordgenerator;

import android.text.Editable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class generatePasswordHelper {

    public String generate(Integer intLength, boolean add_punctuations, boolean add_programmingCharacters, boolean add_similarCharacters, boolean add_uppercase) {

        String result = "";
        List<String> resultArray = new ArrayList<>();

        List<String> charactersArray = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h",  "j", "k",  "m", "n", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
                , "2", "3", "4", "5", "6", "7", "8", "9");

        for (String item : charactersArray) {
            resultArray.add(item);
        }


        if (add_uppercase) {
            charactersArray = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H",  "J", "K", "M", "N", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");

            for (String item : charactersArray) {
                resultArray.add(item);
            }
        }


        if (add_similarCharacters) {
            List<String> similarCharactersArray = Arrays.asList("1", "i", "l", "0", "o");

            if (add_uppercase) {
                List<String> similarCharactersUppercaseArray = Arrays.asList("I", "L", "O");

                for (String item : similarCharactersUppercaseArray) {
                    resultArray.add(item);
                }
            }

            for (String item : similarCharactersArray) {
                resultArray.add(item);
            }

        }

        if (add_punctuations) {
            List<String> punctuationsArray = Arrays.asList(";", ",", "\"", "?",".","(",")","!","-",",",":","'");
            for (String item : punctuationsArray) {
                resultArray.add(item);
            }
        }


        if (add_programmingCharacters) {
            List<String> programmingCharacters = Arrays.asList("`", "$", "'", "\"", "&", "?", "@", "#", "<", ">", "(", ")", "{", "}", "[", "]", "/", "\\", "=", "+", "%", "^", "*", "_", "|");
            for (String item : programmingCharacters) {
                resultArray.add(item);
            }
        }



        for (int i = 0; i <= intLength -1 ; i++) {
            Random rand = new Random();
            int n = rand.nextInt(resultArray.size() - 1);
            result = result + resultArray.get(n);
        }


        return result;
    }


}
