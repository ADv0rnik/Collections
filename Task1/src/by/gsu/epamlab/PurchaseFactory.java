package by.gsu.epamlab;

public class PurchaseFactory {
    public final static int  PURCHASE = 3;
    public final static int  PRICE_PURCHASE = 4;
    public static Purchase getClassFromFactory(String csvLine)  {
        String[]data = csvLine.split(";");
        return switch (data.length) {
            case PURCHASE -> new Purchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
            case PRICE_PURCHASE -> new PricePurchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]), Integer.parseInt(data[3]));
            default -> null;
        };
    }
}

