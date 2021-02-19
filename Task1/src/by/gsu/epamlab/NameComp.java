package by.gsu.epamlab;

import java.util.Comparator;

public class NameComp implements Comparator<Purchase> {
        @Override
        public int compare(Purchase o1, Purchase o2) {
            if (o1.getName().equals(o2.getName())){
                    return Double.compare(o1.getCost(), o2.getCost());
            } return o1.getName().compareTo(o2.getName());
        }
}


