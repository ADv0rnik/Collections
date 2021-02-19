package by.gsu.epamlab;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        final String PACKAGE = "Task1/src/";
        final String EXT = ".csv";
        Scanner sc;
        HashMap<Purchase, String>firstPurchaseMap = new HashMap<>();
        HashMap<Purchase, String>lastPurchaseMap = new HashMap<>();
        try{
            sc = new Scanner(new FileReader(PACKAGE + args[0] + EXT));
            while (sc.hasNextLine()){
                String key = sc.nextLine();
                String value = sc.nextLine();
                Purchase purchase = PurchaseFactory.getClassFromFactory(key);
                if(firstPurchaseMap.containsKey(purchase)){
                    int day1 = WeekDay.valueOf(value).ordinal();
                    int day2 = WeekDay.valueOf(firstPurchaseMap.get(purchase)).ordinal();
                    if (day1 < day2) {
                        String tmp = firstPurchaseMap.get(purchase);
                        removeItem(firstPurchaseMap, purchase);
                        firstPurchaseMap.put(purchase, value);
                        lastPurchaseMap.put(purchase, tmp);
                    }else{
                        lastPurchaseMap.put(purchase,value);
                    }
                }else {
                    firstPurchaseMap.put(purchase, value);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
        printMap(firstPurchaseMap);
        System.out.println();
        printMap(lastPurchaseMap);
        System.out.println();
    }

    private static void printMap(HashMap<Purchase, String> map) {
        map.forEach((Purchase, String) -> {
            System.out.format("%s = %s%n", Purchase, String);
        });
    }

    private static void removeItem (HashMap<Purchase, String> map, Purchase k){
        map.remove(k);
    }
}
