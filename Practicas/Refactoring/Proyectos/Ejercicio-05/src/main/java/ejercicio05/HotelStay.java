package ejercicio05;

import java.time.LocalDate;

public class HotelStay extends Product {
    public double cost;
    private Hotel hotel;

    public HotelStay(double c, TimePeriod tp, Hotel h) {
        super(tp);
        this.cost = c;
        this.hotel = h;
	}

    public double priceFactor() {
        return this.cost / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }
}
