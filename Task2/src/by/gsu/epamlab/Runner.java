package by.gsu.epamlab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        final String PACKAGE = "Task2/src/";
        final String EXT = ".txt";
        String[]num;
        double x1, x2, y1, y2;
        Scanner sc = null;
        String fileName = args[0];
        try{
            sc = new Scanner(new FileReader(PACKAGE + fileName + EXT));
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                //System.out.println(line);
                num = line.split("\\s*\\(\\s*|\\D?\\s*;\\s*|\\s*\\)\\s*");
                x1 = Double.parseDouble(num[1]);
                y1 = Double.parseDouble(num[2]);
                x2 = Double.parseDouble(num[3]);
                y2 = Double.parseDouble(num[4]);
                System.out.println(x1);


            }


        }catch (FileNotFoundException e) {
            System.out.println(e);
        }


    }
}
