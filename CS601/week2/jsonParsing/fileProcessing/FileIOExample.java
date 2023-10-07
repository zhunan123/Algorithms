package week2.jsonParsing.fileProcessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIOExample {

    public static void readFromFile(String input) {
        try {
            FileReader fr = new FileReader(input);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readAndWrite(String input, String output) {
        try {
            FileReader fr = new FileReader(input);
            PrintWriter writer = new PrintWriter(output);

            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                writer.println(line);
            }

            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        if (args.length >= 1) {
            FileIOExample.readFromFile(args[0]);
//            FileIOExample.readFromFile("CS601/week2/jsonParsing/input.txt");
            FileIOExample.readAndWrite(args[0], "CS601/week2/jsonParsing/fileProcessing/output.txt");
        }
    }
}
