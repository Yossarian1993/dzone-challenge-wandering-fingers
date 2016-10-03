package com.martin;

import java.util.List;
import java.util.Map;

public class App
{
    private static final String FILE_PATH = "src/main/resources/enable1.txt";
    private static final String INPUT_STRING = "gijakjthoijerjidsdfnokg";

    public static void main(String[] args)
    {
        FileReader reader = new FileReader();
        WordFinder wordFinder = new WordFinder();

        Map<String, List<String>> words = reader.read(FILE_PATH);

        List<String> matchingWords = wordFinder.find(words, INPUT_STRING);

        System.out.println(matchingWords);
    }

}
