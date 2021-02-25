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
        List<PricePurchase> list = new ArrayList<>();
        EnumMap<WeekDay, List<PricePurchase>> enumMap = new EnumMap<>(WeekDay.class);
        try{
            sc = new Scanner(new FileReader(PACKAGE + args[0] + EXT));
            while (sc.hasNextLine()){
                String key = sc.nextLine();
                String value = sc.nextLine();
                Purchase purchase = PurchaseFactory.getClassFromFactory(key);

                if(purchase.getClass().equals(PricePurchase.class)){
                    list.add((PricePurchase) purchase);
                    WeekDay day = WeekDay.valueOf(value);
                    if (enumMap.get(day) == null){
                        enumMap.put(day, new ArrayList<>());
                        enumMap.get(day).add((PricePurchase) purchase);
                    }
                    else {
                        enumMap.get(day).add((PricePurchase) purchase);
                    }
                }

                if(firstPurchaseMap.containsKey(purchase)) {
                    int day1 = WeekDay.valueOf(value).ordinal();
                    int day2 = WeekDay.valueOf(firstPurchaseMap.get(purchase)).ordinal();
                    if (day1 < day2) {
                        String tmp = firstPurchaseMap.get(purchase);
                        firstPurchaseMap.remove(purchase);
                        firstPurchaseMap.put(purchase, value);
                        lastPurchaseMap.put(purchase, tmp);
                    }
                    else{
                        lastPurchaseMap.put(purchase,value);
                    }
                }
                else {
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
        printMap(enumMap);
        System.out.println("Total cost is: "+ getTotalCost(list));
        System.out.println();
        System.out.println(findWeekDay(firstPurchaseMap,new Purchase("bread",155,2)));
        System.out.println(findWeekDay(lastPurchaseMap,new Purchase("bread",154,2)));
        System.out.println(findItem(firstPurchaseMap, "MONDAY"));
    }
//define private methods for data manipulation
    private static void printMap(HashMap<Purchase, String> map) {
        map.forEach((Purchase, String) -> System.out.format("%s = %s%n", Purchase, String));
    }

    private static void printMap(EnumMap<WeekDay, List<PricePurchase>> map) {
        map.forEach((WeekDay, list) -> System.out.format("%s = %s%n", WeekDay, list));
    }

    private static void removeItem (HashMap<Purchase, String> map, Purchase purchase){
        map.keySet().removeIf(purchase1 -> purchase1.getName().equals(purchase.getName()));
    }

    private static double getTotalCost(List<PricePurchase> list){
        double total = 0;
        for (int i = 0; i < list.size(); i++){
            total += list.get(i).getCost();
        }
        return total;
    }

    private static WeekDay findWeekDay(HashMap<Purchase, String> map, Purchase purchase){
        WeekDay result = null;
        var keys = map.keySet();
        for(Purchase p: keys){
            if(p.getName().equals(purchase.getName()) && p.getPrice() == purchase.getPrice()){
                result = WeekDay.valueOf(map.get(p));
                break;
            }
        }
        return result;
    }

    private static List<Purchase> findItem(HashMap<Purchase, String> map, String day){
        List<Purchase> result = new ArrayList<>();
        var entry = map.entrySet();
        for (Map.Entry<Purchase, String> p: entry){
            if(day.equals(p.getValue())){
                result.add(p.getKey());
            }
        }
        return result;
    }
}
