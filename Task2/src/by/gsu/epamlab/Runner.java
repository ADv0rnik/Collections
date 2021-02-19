package by.gsu.epamlab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        final String PACKAGE = "Task2/src/";
        final String EXT = ".txt";
        String[]number;
        double x1, x2, y1, y2;
        int num = 0;
        Scanner sc = null;
        String fileName = args[0];
        List<Segment> list = new ArrayList<>();
        try{
            sc = new Scanner(new FileReader(PACKAGE + fileName + EXT));
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                number = line.split("\\s*\\(\\s*|\\D?\\s*;\\s*|\\s*\\)\\s*");
                x1 = Double.parseDouble(number[1]);
                y1 = Double.parseDouble(number[2]);
                x2 = Double.parseDouble(number[4]);
                y2 = Double.parseDouble(number[5]);
                int len = (int)Math.round(Math.sqrt(Math.pow((x1 - x2), 2)+ Math.pow((y1 - y2), 2)));
                System.out.println(len);

                Segment segment = new Segment(len);
                int index = Collections.binarySearch(list, segment);
                //System.out.println(index);
                if (index < 0){
                    list.add(segment);
                    num++;
                }
                else {
                    num++;
                }
            }

        }catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
