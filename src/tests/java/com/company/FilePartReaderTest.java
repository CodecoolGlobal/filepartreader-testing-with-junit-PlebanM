package com.company;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

public class FilePartReaderTest {

    private String pathToTestFile = "/home/plebsik/Pulpit/codecool/WEB/SI-5/filepartreader-testing-with-junit-PlebanM/src/tests/java/com/company/testFiles/testFile.txt";
    private String pathToTest1LineFile = "/home/plebsik/Pulpit/codecool/WEB/SI-5/filepartreader-testing-with-junit-PlebanM/src/tests/java/com/company/testFiles/One_line_test.txt";
    private String pathToTest2LineFile = "/home/plebsik/Pulpit/codecool/WEB/SI-5/filepartreader-testing-with-junit-PlebanM/src/tests/java/com/company/testFiles/Two_lines_test.txt";


    private FilePartReader filePartReader;

    @BeforeEach
    public void setup(){
        filePartReader = new FilePartReader();
    }

    @Test
        public void setup_ToLineSmallerThenFromLine_ExceptionThrown(){
        Integer toLine = 1;
        Integer fromLine = 2;
        System.out.println(filePartReader);
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup(pathToTestFile, fromLine, toLine));

    }


    @Test
    public void setup_FromLineLowerThen1_ExceptionThrown(){

        Integer toLine = 1;
        Integer fromLine = 0;
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class,() -> filePartReader.setup(pathToTestFile, fromLine, toLine));


    }

    @Test
    public void read_checkIfReadFileWithOneLineCorrect_ReturnWholeFileContent() throws IOException {
        FilePartReader filePartReader = new FilePartReader();

        filePartReader.setup(pathToTest1LineFile,1,2);

        String contentFromFile = "Text in first line";
        assertEquals(contentFromFile, filePartReader.read());

    }

    @Test
    public void read_checkIfReadTwoLinesFileCorrect_ReturnWholeFileContent() throws IOException {

        FilePartReader filePartReader = new FilePartReader();

        filePartReader.setup(pathToTest2LineFile,1,2);


        String contentFromFile = "This is first line.\n" +
                "This is second line";
        assertEquals(contentFromFile, filePartReader.read());

    }

    @Test
    public void read_checkIfReadWholeFileIfRangeLinesAreEquals_ReturnWholeFileContent() throws IOException {

        FilePartReader filePartReader = new FilePartReader();

        filePartReader.setup(pathToTest2LineFile,1,1);


        String contentFromFile = "This is first line.\n" +
                "This is second line";
        assertEquals(contentFromFile, filePartReader.read());

    }

    @Test
    public void read_checkIfReadAllFileLinesIfRangeLineIsBiggerThenAllLinesInFile_ReturnWholeFileContent() throws IOException {

        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(pathToTest2LineFile,5,9);

        String contentFromFile = "This is first line.\n" +
                "This is second line";
        assertEquals(contentFromFile, filePartReader.read());
    }

    @Test
    public void readLines_checkIfReadOneLineProperty_returnOneLine() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(pathToTest2LineFile,2,2);

        String secondLineFromFile = "This is second line";
        assertEquals(secondLineFromFile, filePartReader.readLines());
    }


    @Test
    public void readLines_checkIfReadTwoLineProperty_returnTwoLines() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(pathToTestFile,4,5);

        String twoLines = "Fourth line\n" +
                "Fifth line";
        assertEquals(twoLines, filePartReader.readLines());
    }

    @Test
    public void readLines_checkIfReadPropertlyWhenRangeIsOutOfBound_returnThreeLinesNoError() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup(pathToTestFile,3,10);

        String twoLines = "Third Line\n" +
                "Fourth line\n" +
                "Fifth line";
        assertEquals(twoLines, filePartReader.readLines());
    }

}