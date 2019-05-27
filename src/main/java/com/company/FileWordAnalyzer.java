package com.company;

import java.io.IOException;
import java.util.*;

public class FileWordAnalyzer {

    FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws IOException {
        String textFromFile = filePartReader.readLines();
        String[] words = textFromFile.split("\\W+");

        List<String> stringsList = new ArrayList<>(new HashSet<>(Arrays.asList(words)));

        Collections.sort(stringsList);

        return stringsList;

    }

    public List<String> getWordsContainingSubstring (String subString ) throws IOException {
        String textFromFile = filePartReader.readLines();
        String[] words = textFromFile.split("\\W+");

        List<String> stringsList = new ArrayList<>(new HashSet<>(Arrays.asList(words)));

        List<String> wordsContainsSubString = new ArrayList<>();
        for (String word : stringsList ){
            if(word.toLowerCase().contains(subString.toLowerCase())){
                wordsContainsSubString.add(word);
            }
        } return wordsContainsSubString;

    }

    public List getStringsWhichPalindromes () throws IOException {
        List<String> stringList = getWordsOrderedAlphabetically();

        List<String> palindroms = new ArrayList<>();
        for (String word : stringList){
            if(word.toLowerCase().equals(new StringBuffer(word.toLowerCase()).reverse().toString())& word.length()>1){
                palindroms.add(word);
            }
        }return palindroms;
    }
}
