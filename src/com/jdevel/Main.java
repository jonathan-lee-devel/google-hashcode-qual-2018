package com.jdevel;

import com.jdevel.input.InputFileReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Obtain a list of all files within the directory
        ArrayList<File> inputFileList = InputFileReader.getFileListFromDirectory("/home/jonathan/workspace/google-hashcode-qual18-files");

        try {
            // Iterate through each file
            for (File file : inputFileList) {
                // For each, configure a simulation

                // Read contents of the file
                ArrayList<String> fileContent = InputFileReader.readLinesFromFile(file);
                // Obtain the first line, containing the information about the pre-booked rides, then remove from fileContent list
                String fileHeader = fileContent.get(0);
                fileContent.remove(0);


                // Obtain the integers from the first line in the input file
                ArrayList<Integer> headerIntegers = InputFileReader.getSeparatedIntegersListFromString(fileHeader, "\\s");

                for (String s : fileContent) {
                    System.out.println(s);
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
