package com.martin;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFinder
{
    public List<String> find(Map<String, List<String>> words, String inputString)
    {
        String key = getConcatenatedFirstAndLastLetter(inputString);

        List<String> possibleWords = words.get(key);

        return possibleWords.stream()
                            .filter(word -> isMatch(word, inputString))
                            .collect(Collectors.toList());
    }

    private String getConcatenatedFirstAndLastLetter(String inputString)
    {
        String firstLetter = inputString.substring(0, 1);
        String lastLetter = inputString.substring(inputString.length() - 1, inputString.length());

        return firstLetter + lastLetter;
    }

    private boolean isMatch(String word, String inputString)
    {
        String actualInputString = trimFirstAndLastLetter(inputString);

        int actualIndex = 0;

        for (int i = 1; i < word.length() - 1; i++)
        {
            actualInputString = actualInputString.substring(actualIndex);

            char ch = word.charAt(i);

            actualIndex = actualInputString.indexOf(ch);

            if (actualIndex == -1)
            {
                return false;
            }
        }

        return true;
    }

    private String trimFirstAndLastLetter(String string)
    {
        return string.substring(1, string.length() - 1);
    }
}