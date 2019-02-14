package com.jdevel.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InputFileReader {

    /**
     * Obtains all files from within a directory and returns as an array list
     * @param directoryPath the path to the directory
     * @return an array list containing all files found within the directory
     */
    public static ArrayList<File> getFileListFromDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        File[] fileArray = directory.listFiles();

        ArrayList<File> fileArrayList = new ArrayList<>(fileArray.length);
        for (File file : fileArray) {
            fileArrayList.add(file);
        }

        return fileArrayList;
    }

    /**
     * Reads a specified amount of lines from a file, storing each line as a string in an array list
     * @param file file to be read from
     * @param offset number of lines to skip when reading file
     * @param max maximum number of lines to read from file
     * @return array list containing all lines specified to be read
     * @throws IOException possible IOException while using BufferedReader
     */
    public static ArrayList<String> readLinesFromFile( File file, int offset, int max ) throws IOException {
        // Pre-allocate list to contain lines
        ArrayList<String> lineList = new ArrayList<>(max - offset);

        // Create reader for the file
        BufferedReader bReader = new BufferedReader(new FileReader(file));

        // Skip through the first 'offset' lines of the file
        for (int i = 0; i < offset; i++) {
            bReader.readLine();
        }

        // Iterate through each line, adding it to the lineList, stopping on max or null
        String currentLine = "";
        for (int i = 0; i < max; i++) {
            // Read next line in file
            currentLine = bReader.readLine();
            // Prevent null
            if (currentLine == null) {
                break;
            }
            // Otherwise add to list
            lineList.add(currentLine);
        }

        // Return the list of file lines
        return lineList;
    }

    /**
     * Returns all lines within a file as an array list of strings, containing a String for each line
     * @param file file to read from
     * @return array list containing a string for each line of file
     * @throws IOException
     */
    public static ArrayList<String> readLinesFromFile( File file ) throws IOException {
        // Pre-allocate list to contain lines
        ArrayList<String> lineList = new ArrayList<>();

        // Create reader for the file
        BufferedReader bReader = new BufferedReader(new FileReader(file));

        // Iterate through each line, adding it to the lineList, stopping on null
        String currentLine = "";
        while ( (currentLine = bReader.readLine()) != null ) {
            lineList.add(currentLine);
        }

        // Return the list of file lines
        return lineList;
    }

    /**
     * Iterates through a String, parsing all integers separated by the specified regex separator
     * @param intString string containing ints which is to be parsed
     * @param regexSeparator regex expression used to separate each of the integers in the list
     * @return array list containing all of the parsed integers
     */
    public static ArrayList<Integer> getSeparatedIntegersListFromString(String intString, String regexSeparator) {
        // Allocate list
        ArrayList<Integer> integerList = new ArrayList<Integer>();

        // Iterate through each of the separated strings, storing each of the parsed integers in list
        String[] separatedStrings = intString.split(regexSeparator);
        for (String s : separatedStrings) {
            integerList.add( Integer.parseInt(s) );
        }

        // Return the list of integers
        return integerList;
    }

}
