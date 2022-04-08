package Parser;

import java.util.Calendar;
import java.util.Date;

public class Order {

    private String name;

    private Date time;

    private int amount_customers;

    private String day;

    private String daytime;

    public Order() {
        Calendar zero = Calendar.getInstance();
        zero.set(0, 0, 0, 0, 0, 0);
        this.setTime(zero.getTime());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDaytime() {
        return daytime;
    }

    public void setDaytime(String daytime) {
        this.daytime = daytime;
    }

    @Override
    public String toString() {
        return  name +
                ", " + time +
                " (" + day + " " + daytime + ")" +
                ", für: " + amount_customers + " Person(en)";
    }
}
