package ch6;

import java.util.Objects;

public class DiscountedItem extends Item{

    double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DiscountedItem) {
            if (this == o) return true;
            if (getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            DiscountedItem that = (DiscountedItem) o;
            return Double.compare(that.discount, discount) == 0;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
