package Parser;

import java.util.*;

public class OrderParser {

    private HashMap<String, Integer> months = new HashMap<>();

    public OrderParser() {
        months.put("januar", 1);
        months.put("februar", 2);
        months.put("märz", 3);
        months.put("april", 4);
        months.put("mai", 5);
        months.put("juni", 6);
        months.put("juli", 7);
        months.put("august", 8);
        months.put("september", 9);
        months.put("oktober", 10);
        months.put("november", 11);
        months.put("dezember", 12);
    }

    public void parseOrder(String order) {
        String[] order_each = order.split(" ");
        Order current_order = new Order();
        Calendar order_date = Calendar.getInstance();
        for (int i = 0; i < order_each.length; i++) {
            String current = order_each[i].toLowerCase();

            //if "." in Substring -> Date, if 2 "." then Month is a number, else it's a String and needs to be parsed
            if(current.contains(".") && current.split("\\.").length == 2 ||
                    current.contains(".") && months.containsKey(order_each[i+1].toLowerCase())) {

                int day = Integer.parseInt(current.split("\\.")[0]);

                if (current.contains(".") && months.containsKey(order_each[i+1].toLowerCase())) {
                    order_date.set(order_date.get(Calendar.YEAR), months.get(order_each[i+1].toLowerCase())-1, day);
                } else {
                    int month = Integer.parseInt(current.split("\\.")[1])-1;
                    order_date.set(order_date.get(Calendar.YEAR), month, day);
                }

                //Year, Month(starts at 0), Day, Hour, Minute, Second
                current_order.setDay(order_date.getTime());
            }

            //if "Uhr" or "h" then time is on index -1 of current / need to differentiate between single digit and ":" times
            if(current.contains("uhr") || current.equalsIgnoreCase("h") || current.equalsIgnoreCase("h,")) {
                if(order_each[i-1].contains(":")) {
                    int hour = Integer.parseInt(order_each[i-1].split(":")[0]);
                    int minute = Integer.parseInt(order_each[i-1].split(":")[1]);
                    order_date.set(Calendar.HOUR_OF_DAY, hour);
                    order_date.set(Calendar.MINUTE, minute);
                } else {
                    int hour = Integer.parseInt(order_each[i-1]);
                    order_date.set(Calendar.HOUR_OF_DAY, hour);
                    order_date.set(Calendar.MINUTE, 0);
                }
                current_order.setTime(order_date.getTime());
            }

            // if amount is specified, nubmer is followed by one of these words
            if(current.contains("person") ||
                    current.equalsIgnoreCase("mann") ||
                    current.equalsIgnoreCase("frau") ||
                    current.contains("leute")) {
                if(order_each[i-1].length() != 1) {
                    int amount = parseAmount(order_each[i-1]);
                    current_order.setAmount_customers(amount);
                } else {
                    current_order.setAmount_customers(Integer.parseInt(order_each[i-1]));
                }
            }

            //if name --> always follows one of the following words
            if(current.equalsIgnoreCase("gruß") ||
                    current.equalsIgnoreCase("dank") ||
                    current.equalsIgnoreCase("grüßen") ||
                    current.equalsIgnoreCase("grüße"))
            {
                int name_length = order_each.length - i;
                current_order.setName(parseName(order_each, name_length));
            }

        }

            System.out.println(current_order);
    }

    private int parseAmount(String amount) {
        return switch (amount.toLowerCase()) {
            case "eine" -> 1;
            case "zwei" -> 2;
            case "drei" -> 3;
            case "vier" -> 4;
            case "fünf" -> 5;
            case "sechs" -> 6;
            case "sieben" -> 7;
            case "acht" -> 8;
            case "neun" -> 9;
            case "zehn" -> 10;
            default -> 0;
        };
    }

    private String parseName(String[] order, int name_length) {
        String name = "";
        for (int k = name_length-1; k > 0; k--) {
            name += order[order.length-k] + " ";
        }

        return name;
    }

}
