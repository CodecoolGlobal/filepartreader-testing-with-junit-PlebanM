package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileWordAnalyzerTest {

    private FilePartReader filePartReader;
    private FileWordAnalyzer fileWordAnalyzer;
    @BeforeEach
    void setup(){
        filePartReader = new FilePartReader();
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

    }

    @Test
    void getWordsOrderedAlphabetically_withNonOrderedWords_orderedWords() throws IOException {
        String noneOrderedAlphabWords = "/home/plebsik/Pulpit/codecool/WEB/SI-5/filepartreader-testing-with-junit-PlebanM/src/tests/java/com/company/testFiles/NoneOrderedAlphabeticallyWords.txt";
        filePartReader.setup(noneOrderedAlphabWords,1,1);

        List<String> orderedAlphabetically = new ArrayList<String>(Arrays.asList("array", "home", "like", "zebra"));

        assertEquals(orderedAlphabetically, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    void getWordsContainingSubstring_withWordsContainWordHome_returnWords() throws IOException {
         String fileWithwordsContainsHomeWord = "/home/plebsik/Pulpit/codecool/WEB/SI-5/filepartreader-testing-with-junit-PlebanM/src/tests/java/com/company/testFiles/wordsContainHomeWord.txt";
        filePartReader.setup(fileWithwordsContainsHomeWord,1,1);

        List<String> wordsWithHome = new ArrayList<String>(Arrays.asList("homeless", "nawhomeleo", "home", "jahome"));
        String searchedWord = "home";

        assertEquals(wordsWithHome, fileWordAnalyzer.getWordsContainingSubstring(searchedWord));
    }

    @Test
    void getWordsContainingSubstring_palindromWordsInFile_returnListWords() throws IOException {
        String fileWithPalindroms = "/home/plebsik/Pulpit/codecool/WEB/SI-5/filepartreader-testing-with-junit-PlebanM/src/tests/java/com/company/testFiles/palindromWords.txt";
        filePartReader.setup(fileWithPalindroms,1,1);

        List<String> palindromsFromFile = new ArrayList<String>(Arrays.asList("ala", "kajak", "morom"));

        assertEquals(palindromsFromFile, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}