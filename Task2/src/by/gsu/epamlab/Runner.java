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
        int index;
        String fileName = args[0];
        List<Segment> list = new ArrayList<>();
        try (Scanner sc = new Scanner(new FileReader(PACKAGE + fileName + EXT))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                number = line.split("\\s*\\(\\s*|\\D?\\s*;\\s*|\\s*\\)\\s*");
                x1 = Double.parseDouble(number[1]);
                y1 = Double.parseDouble(number[2]);
                x2 = Double.parseDouble(number[4]);
                y2 = Double.parseDouble(number[5]);
                int len = (int) Math.round(Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)));

                Segment segment = new Segment(len);
                index = Collections.binarySearch(list, segment);
                if (index < 0) {
                    list.add(index + 1, segment);
                } else {
                    int tmp = list.get(index).getNum();
                    tmp++;
                    list.set(index, new Segment(len, tmp));
                }
            }
            System.out.println("Before sorting:");
            for (Segment segment : list) {
                System.out.println(segment);
            }
            list.sort(Collections.reverseOrder());
            System.out.println("After sorting:");
            for (Segment segment : list) {
                System.out.println(segment);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
