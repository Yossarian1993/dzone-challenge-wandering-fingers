package com.martin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FileReader
{
    private static final int MIN_REQUIRED_LENGTH_OF_WORD = 5;

    public Map<String, List<String>> read(String fileName)
    {
        File file = new File(fileName);

        Map<String, List<String>> wordsByFirstAndLastLetter = Collections.emptyMap();

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file)))
        {
            wordsByFirstAndLastLetter = bufferedReader.lines()
                                                      .filter(Objects::nonNull)
                                                      .filter(s -> s.length() >= MIN_REQUIRED_LENGTH_OF_WORD)
                                                      .collect(Collectors.groupingBy(this::concatFirstAndLastLetter));
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return wordsByFirstAndLastLetter;
    }

    private String concatFirstAndLastLetter(String word)
    {
        return String.valueOf(word.charAt(0)) + String.valueOf(word.charAt(word.length() - 1));
    }
}
