package com.jdevel.output;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OutputFileWriter {

    public static String createSpacedIntegerString(ArrayList<Integer> integers, String separator) {
        StringBuffer stringBuffer = new StringBuffer();

        for (Integer integer : integers) {
            stringBuffer.append(integer);
            stringBuffer.append(separator);
        }
        stringBuffer.append("\n");

        return stringBuffer.toString();
    }

    public static void writeToFile(File file, ArrayList<String> outputLines) throws IOException {
        BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));

        for (String s : outputLines) {
            bWriter.write(s);
        }

        bWriter.close();
    }

}
