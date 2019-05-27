package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringJoiner;

public class FilePartReader {

    private String filePath;
    private Integer fromLine;
    private Integer toLine;



    public FilePartReader() {

        this.filePath = new String();
        this.fromLine = new Integer(0);
        this.toLine = new Integer(0);
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException{
        if(toLine < fromLine | fromLine < 1){
            throw new IllegalArgumentException();
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        StringJoiner stringJoiner = new StringJoiner("\n");
        while ((line = br.readLine()) != null){
            stringJoiner.add(line);
            }
        br.close();
        return stringJoiner.toString();
    }

    public String readLines() throws IOException{

        StringJoiner stringJoiner = new StringJoiner("\n");
        Scanner scanner = new Scanner(read());
        int lineNumber = 1;
        while (scanner.hasNextLine()) {
            if(lineNumber >= fromLine & lineNumber <= toLine){
                stringJoiner.add(scanner.nextLine());
            }else {
                scanner.nextLine();
            }
            lineNumber++;
        }
        scanner.close();

        return stringJoiner.toString();
    }
}