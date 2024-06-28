package Properties;

public class PropertyFinancials {

    String name;
    double price;
    double rent;
    double pricePerHouse;
    double rentOneHouse;
    double rentTwoHouse;
    double rentThreeHouse;
    double rentFourHouse;
    double rentHotel;
    double mortgageAmount;

    private PropertyFinancials(String name, double price, double rent, double pricePerHouse, double rentOneHouse, double rentTwoHouse, double rentThreeHouse, double rentFourHouse, double rentHotel, double mortgageAmount) {
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.pricePerHouse = pricePerHouse;
        this.rentOneHouse = rentOneHouse;
        this.rentTwoHouse = rentTwoHouse;
        this.rentThreeHouse = rentThreeHouse;
        this.rentFourHouse = rentFourHouse;
        this.rentHotel = rentHotel;
        this.mortgageAmount = mortgageAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public double getPricePerHouse() {
        return pricePerHouse;
    }

    public void setPricePerHouse(double pricePerHouse) {
        this.pricePerHouse = pricePerHouse;
    }

    public double getRentOneHouse() {
        return rentOneHouse;
    }

    public void setRentOneHouse(double rentOneHouse) {
        this.rentOneHouse = rentOneHouse;
    }

    public double getRentTwoHouse() {
        return rentTwoHouse;
    }

    public void setRentTwoHouse(double rentTwoHouse) {
        this.rentTwoHouse = rentTwoHouse;
    }

    public double getRentThreeHouse() {
        return rentThreeHouse;
    }

    public void setRentThreeHouse(double rentThreeHouse) {
        this.rentThreeHouse = rentThreeHouse;
    }

    public double getRentFourHouse() {
        return rentFourHouse;
    }

    public void setRentFourHouse(double rentFourHouse) {
        this.rentFourHouse = rentFourHouse;
    }

    public double getRentHotel() {
        return rentHotel;
    }

    public void setRentHotel(double rentHotel) {
        this.rentHotel = rentHotel;
    }

    public double getMortgageAmount() {
        return mortgageAmount;
    }

    public void setMortgageAmount(int mortgageAmount) {
        this.mortgageAmount = mortgageAmount;
    }

    @Override
    public String toString() {
        return "PropertyFinancials{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rent=" + rent +
                ", pricePerHouse=" + pricePerHouse +
                ", rentOneHouse=" + rentOneHouse +
                ", rentTwoHouse=" + rentTwoHouse +
                ", rentThreeHouse=" + rentThreeHouse +
                ", rentFourHouse=" + rentFourHouse +
                ", rentHotel=" + rentHotel +
                ", mortgageAmount=" + mortgageAmount +
                '}';
    }

    public static class PropertyFinancialBuilder{

        String name;
        double price;
        double rent;
        double pricePerHouse;
        double rentOneHouse;
        double rentTwoHouse;
        double rentThreeHouse;
        double rentFourHouse;
        double rentHotel;
        double mortgageCost;

        public PropertyFinancialBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PropertyFinancialBuilder price(double price) {
            this.price = price;
            return this;
        }

        public PropertyFinancialBuilder rent(double rent) {
            this.rent = rent;
            return this;
        }

        public PropertyFinancialBuilder pricePerHouse(double pricePerHouse) {
            this.pricePerHouse = pricePerHouse;
            return this;
        }

        public PropertyFinancialBuilder rentOneHouse(double rentOneHouse) {
            this.rentOneHouse = rentOneHouse;
            return this;
        }

        public PropertyFinancialBuilder rentTwoHouse(double rentTwoHouse) {
            this.rentTwoHouse = rentTwoHouse;
            return this;
        }

        public PropertyFinancialBuilder rentThreeHouse(double rentThreeHouse) {
            this.rentThreeHouse = rentThreeHouse;
            return this;
        }

        public PropertyFinancialBuilder rentFourHouse(double rentFourHouse) {
            this.rentFourHouse = rentFourHouse;
            return this;
        }

        public PropertyFinancialBuilder rentHotel(double rentHotel) {
            this.rentHotel = rentHotel;
            return this;
        }

        public PropertyFinancialBuilder mortgageCost(double mortgageCost) {
            this.mortgageCost = mortgageCost;
            return this;
        }

        public PropertyFinancials build(){
            return new PropertyFinancials(name,  price,  rent,  pricePerHouse,  rentOneHouse,  rentTwoHouse,  rentThreeHouse,  rentFourHouse,  rentHotel,  mortgageCost);
        }
    }
}
