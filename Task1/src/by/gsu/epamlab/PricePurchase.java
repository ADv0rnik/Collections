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
            return (Round(getPrice() - discInRoubles) * getQuantity());       
    }

    @Override
    public String toString() {
        return String.format("%s; %.2f; %d; %.2f; %.2f", super.getName(), Round(super.getPrice()), super.getQuantity(), Round(this.discInRoubles), getCost());
    }
}
