package ejercicio05;

import java.time.LocalDate;

public class CarRental extends Product {
    public double cost;
    private Company company;

    public CarRental(double cost, TimePeriod tp, Company company) {
        super(tp);
        this.cost = cost;
        this.company = company;
    }

    public double price() {
        return this.company.price() * this.company.promotionRate();
    }

    public double cost() {
        return this.cost;
    }
}
