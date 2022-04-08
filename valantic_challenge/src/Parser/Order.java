package Parser;

import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Order {

    private String name;

    private Date day;

    private Date time;

    private int amount_customers;

    public Order() {
        Calendar zero = Calendar.getInstance();
        zero.set(0, 0, 0, 0, 0, 0);
        this.setDay(zero.getTime());
        this.setTime(zero.getTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getAmount_customers() {
        return amount_customers;
    }

    public void setAmount_customers(int amount_customers) {
        this.amount_customers = amount_customers;
    }

    @Override
    public String toString() {
        return  name +
                ", " + day +
                ", " + time +
                ", für: " + amount_customers + " Person(en)";
    }
}
