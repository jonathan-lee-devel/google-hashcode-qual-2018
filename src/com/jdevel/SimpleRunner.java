package com.jdevel;

import com.jdevel.input.InputFileReader;
import com.jdevel.output.OutputFileWriter;
import com.jdevel.task.Intersection;
import com.jdevel.task.Ride;
import com.jdevel.task.Simulation;
import com.jdevel.task.Vehicle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class SimpleRunner {

    public static void main(String[] args) {
        // Obtain a list of all input files within the directory
        ArrayList<File> inputFileList = InputFileReader.getFileListFromDirectory("./input_files");

        try {
            // Iterate through each file, for each, configure and run a simulation
            for (File file : inputFileList) {
                // Read contents of the file
                ArrayList<String> fileContent = InputFileReader.readLinesFromFile(file);
                System.out.println("Processing File: " + file.getName() + "...");

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

                    // Using the integers in current ride line, configure a ride object and add it to the simulation
                    Ride ride = new Ride(
                            rideId,// Id
                            new Intersection(iterator.next(), iterator.next()),// Start intersection
                            new Intersection(iterator.next(), iterator.next()),// Finish intersection
                            iterator.next(),// Earliest start
                            iterator.next()// Latest finish
                    );
                    rideId++;// Increment ID

                    simulation.addRide(ride);// Add the ride to the list of pre-booked rides for the simulation
                }

                /*
                Run the simulation and record the score
                 */
                int score = SimpleRunner.runSimulation(simulation);
                System.out.println("Score: " + score);

                // Iterate through all vehicle objects for the simulation in order to obtain output string
                ListIterator<Vehicle> vehicleListIterator = simulation.getVehicleArrayList().listIterator();
                // Create an array list of strings to output to file, one string for each line
                ArrayList<String> outputLines = new ArrayList<>(simulation.getVehicleArrayList().size());
                // Iterate through vehicle list, appending integers in correct format to the output array list
                while (vehicleListIterator.hasNext()) {
                    Vehicle vehicle = vehicleListIterator.next();
                    ArrayList<Integer> vehicleIntegers = new ArrayList<>();
                    vehicleIntegers.add(vehicle.getRideArrayList().size());
                    for (Ride ride : vehicle.getRideArrayList()) {
                        vehicleIntegers.add(ride.getId());
                    }

                    outputLines.add(OutputFileWriter.createSpacedIntegerString(vehicleIntegers, " "));
                }

                String outputFilePath = "./output_files/" + file.getName() + ".out";
                File outputFile = new File(outputFilePath);
                outputFile.createNewFile();
                OutputFileWriter.writeToFile(outputFile, outputLines);

                System.out.println("Finished!\n");
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

    }

    private static int runSimulation(Simulation simulation) {

        // Total score for the simulation to be returned
        int score = 0;

        // Assign all rides to vehicles in order (SIMPLE APPROACH FOR TESTING)
        ListIterator<Ride> rideListIterator = simulation.getRideArrayList().listIterator();
        ListIterator<Vehicle> vehicleRideAssign = simulation.getVehicleArrayList().listIterator();
        while (rideListIterator.hasNext() && vehicleRideAssign.hasNext()) {
            Ride ride = rideListIterator.next();
            Vehicle vehicle = vehicleRideAssign.next();

            vehicle.assignRide(ride);
        }

        // Run through each step for the simulation
        for (int step = 0; step < simulation.getNumSteps(); step++) {

            // Iterate through all vehicles
            ListIterator<Vehicle> vehicleListIterator = simulation.getVehicleArrayList().listIterator();
            while (vehicleListIterator.hasNext()) {
                Vehicle currentVehicle = vehicleListIterator.next();

                /*
                 * Check if any score is to be added
                 */

                if (currentVehicle.getCurrentLocation().equals( currentVehicle.getCurrentRide().getFinishIntersection() )) {// If the vehicle is at the finish intersection
                    if (currentVehicle.getCurrentRide().getLatestFinish() > step) {
                        // No score for late
                    }
                    else {// If it's on time, add 1, if it's early, add 1 + the bonus
                        score += (currentVehicle.getCurrentRide().getLatestFinish() < step) ? 1 + simulation.getPerRideTimelessBonus() : 1;
                    }
                }

                // Update each vehicle
                currentVehicle.step(step);
            }

        }

        return score;
    }

}
