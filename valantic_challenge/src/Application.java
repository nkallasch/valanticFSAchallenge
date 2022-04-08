import Parser.OrderParser;

public class Application {


    public static void main(String[] args) {

        String[] orders = {
                "Hallo, bitte für zwei Personen einen Tisch am 19.3. um 20:00 Uhr, Vielen Dank Klaus Müller",
                "Sehr geehrte Damen Herren, wir würden gern am 9. April 9:45 Uhr mit sechs Leuten zum Brunch kommen, Mit freundlichen Grüßen Maria Meier",
                "Guten Tag, einen Tisch für 8 Mann am 1.5. 9 Uhr abends, Gruß Franz Schulze",
                "Hallo, fünf Tische für eine Person am 13. Dezember um 15:23 h, Liebe Grüße Nils Kallasch"
        };

        OrderParser op = new OrderParser();
        op.parseOrder(orders[0]);
        op.parseOrder(orders[1]);
        op.parseOrder(orders[2]);
        op.parseOrder(orders[3]);
    }
}
