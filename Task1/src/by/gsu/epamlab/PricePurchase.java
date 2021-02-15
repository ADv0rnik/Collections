package by.gsu.epamlab;

public class PricePurchase extends Purchase{
    private int discInRoubles;

    public double getDiscInRoubles() {
        return discInRoubles;
    }

    public void setDiscInRoubles(int discInRoubles) {
        this.discInRoubles = discInRoubles;
    }

    public PricePurchase() {}

    public PricePurchase(String name, int price, int quantity, int discInRoubles){
        super(name, price, quantity);
        this.discInRoubles = discInRoubles;
    }

    @Override
    public double getCost()  {
        if (discInRoubles > 0) {
            return (Round(getPrice() - discInRoubles) * getQuantity());
        } else {
            return super.getCost();
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%.2f",Round(this.discInRoubles));
    }
}
