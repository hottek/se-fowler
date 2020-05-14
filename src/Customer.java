import java.lang.*;
import java.util.*;

class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    Customer(String newname) {
        name = newname;
    }

    void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    private String getName() {
        return name;
    }

    String statement() {
        return getHTMLStatement();
    }

    private String getHTMLStatement() {
        Enumeration<Rental> enum_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + each.getCharge() + "\n";
        }
        //add footer lines
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;

    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration<Rental> enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = enum_rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

}
    