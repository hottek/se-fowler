public class Movie {
    private static final int CHILDRENS = 2;
    private static final int REGULAR = 0;
    private static final int NEW_RELEASE = 1;
    private String title;
    private Price priceCode;

    Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        setPriceCode(newpriceCode);
    }

    public int getPriceCode() {
        return priceCode.getPriceCode();
    }

    private void setPriceCode(int arg) {
        switch (arg) {
            case REGULAR:
                priceCode = new RegularPrice();
                break;
            case CHILDRENS:
                priceCode = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                priceCode = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    String getTitle() {
        return title;
    }

    double getCharge(int daysRented) {
        return priceCode.getCharge(daysRented);
    }

    int getFrequentRenterPoints(int daysRented) {
        return priceCode.getFrequentRenterPoints(daysRented);
    }

    abstract class Price {
        abstract int getPriceCode();

        abstract double getCharge(int daysRented);

        int getFrequentRenterPoints(int daysRented) {
            return 1;
        }
    }

    class ChildrensPrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.CHILDRENS;
        }

        @Override
        double getCharge(int daysRented) {
            double result = 1.5;
            if (daysRented > 3)
                result += (daysRented - 3) * 1.5;
            return result;
        }
    }

    class NewReleasePrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.NEW_RELEASE;
        }

        @Override
        double getCharge(int daysRented) {
            return daysRented * 3;
        }

        @Override
        int getFrequentRenterPoints(int daysRented) {
            return (daysRented > 1) ? 2 : 1;
        }
    }

    class RegularPrice extends Price {
        @Override
        int getPriceCode() {
            return Movie.REGULAR;
        }

        @Override
        double getCharge(int daysRented) {
            double result = 2;
            if (daysRented > 2)
                result += (daysRented - 2) * 1.5;
            return result;
        }
    }
}