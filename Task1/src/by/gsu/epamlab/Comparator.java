package by.gsu.epamlab;

public class Comparator implements java.util.Comparator<Purchase> {
        @Override
        public int compare(Purchase o1, Purchase o2) {
            if (o1.getName().equals(o2.getName())){
                    return Double.compare(o1.getCost(), o2.getCost());
                } return o1.getName().compareTo(o2.getName());
            }
        }


