package by.gsu.epamlab;

public class Purchase {
    private String name;
    private int price;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Purchase(){
    }

    public Purchase(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getCost() {
        return Round(price) * quantity;
    }

    @Override
    public String toString() {
            return String.format("%s;%.2f;%d;%.2f;", this.name, this.Round(price), this.quantity, getCost());
    }

    public double Round(int value){
        return (double)value/100;
    }

    @Override
    public boolean equals(Object obj) {
            if (this == obj){
                return true;
            }
            if (obj == null || (obj.getClass()!=this.getClass())){
                return false;
            }
            Purchase product = (Purchase)obj;
            if (price != product.price){
                return false;
            }
            return this.name.equals(product.name);
        }

    /*@Override
    public int compareTo(Purchase o) {
        return 0;
    }*/
}
