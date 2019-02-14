package com.jdevel;

import com.jdevel.input.InputFileReader;
import com.jdevel.task.Intersection;
import com.jdevel.task.Ride;
import com.jdevel.task.Simulation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        // Obtain a list of all input files within the directory
        ArrayList<File> inputFileList = InputFileReader.getFileListFromDirectory("/home/jonathan/workspace/google-hashcode-qual-2018/input_files");

        try {
            // Iterate through each file, for each, configure a simlation
            for (File file : inputFileList) {
                // Read contents of the file
                ArrayList<String> fileContent = InputFileReader.readLinesFromFile(file);

                // Obtain the first line, containing the information about the pre-booked rides, then remove from fileContent list
                String fileHeader = fileContent.get(0);
                fileContent.remove(0);
                // Obtain the integers from the first line in the input file
                ArrayList<Integer> headerIntegers = InputFileReader.getSeparatedIntegersListFromString(fileHeader, "\\s");
                ListIterator<Integer> headerIterator = headerIntegers.listIterator();

                /*
                Congigure the simulation
                 */

                // Initialize using header infomation
                Simulation simulation = new Simulation(
                        headerIterator.next(),// Rows
                        headerIterator.next(),// Columns
                        headerIterator.next(),// Vehicles
                        headerIterator.next(),// Rides
                        headerIterator.next(),// Bonus
                        headerIterator.next()// Steps
                );

                // Initialize all of the pre-booked rides using remaining lines in file
                int rideId = 0;
                for (String rideString : fileContent) {

                    ArrayList<Integer> rideIntegers = InputFileReader.getSeparatedIntegersListFromString(rideString, "\\s");
                    ListIterator<Integer> iterator = rideIntegers.listIterator();

                    Ride ride = new Ride(
                            rideId,
                            new Intersection(iterator.next(), iterator.next()),// Start intersection
                            new Intersection(iterator.next(), iterator.next()),// Finish intersection
                            iterator.next(),// Earliest start
                            iterator.next()// Latest finish
                    );
                    rideId++;// Increment ID

                    simulation.addRide(ride);
                }

            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }
}
