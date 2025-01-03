package main.Properties;

public class PropertyFinancials {

    private String name;
    private int price;
    private int rent;
    private int pricePerImprovement;
    private int rentOneHouse;
    private int rentTwoHouse;
    private  int rentThreeHouse;
    private int rentFourHouse;
    private int rentHotel;
    private int mortgageAmount;

    public PropertyFinancials(String name, int price, int rent, int pricePerImprovement, int rentOneHouse, int rentTwoHouse,
                              int rentThreeHouse, int rentFourHouse, int rentHotel, int mortgageAmount) {
        this.name = name;
        this.price = price;
        this.rent = rent;
        this.pricePerImprovement = pricePerImprovement;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getPricePerImprovement() {
        return pricePerImprovement;
    }

    public void setPricePerImprovement(int pricePerImprovement) {
        this.pricePerImprovement = pricePerImprovement;
    }

    public int getRentOneHouse() {
        return rentOneHouse;
    }

    public void setRentOneHouse(int rentOneHouse) {
        this.rentOneHouse = rentOneHouse;
    }

    public int getRentTwoHouse() {
        return rentTwoHouse;
    }

    public void setRentTwoHouse(int rentTwoHouse) {
        this.rentTwoHouse = rentTwoHouse;
    }

    public int getRentThreeHouse() {
        return rentThreeHouse;
    }

    public void setRentThreeHouse(int rentThreeHouse) {
        this.rentThreeHouse = rentThreeHouse;
    }

    public int getRentFourHouse() {
        return rentFourHouse;
    }

    public void setRentFourHouse(int rentFourHouse) {
        this.rentFourHouse = rentFourHouse;
    }

    public int getRentHotel() {
        return rentHotel;
    }

    public void setRentHotel(int rentHotel) {
        this.rentHotel = rentHotel;
    }

    public int getMortgageAmount() {
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
                ", pricePerHouse=" + pricePerImprovement +
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
        int price;
        int rent;
        int pricePerImprovement;
        int rentOneHouse;
        int rentTwoHouse;
        int rentThreeHouse;
        int rentFourHouse;
        int rentHotel;
        int mortgageCost;

        public PropertyFinancialBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PropertyFinancialBuilder price(int price) {
            this.price = price;
            return this;
        }

        public PropertyFinancialBuilder rent(int rent) {
            this.rent = rent;
            return this;
        }

        public PropertyFinancialBuilder pricePerImprovement(int pricePerImprovement) {
            this.pricePerImprovement = pricePerImprovement;
            return this;
        }

        public PropertyFinancialBuilder rentOneHouse(int rentOneHouse) {
            this.rentOneHouse = rentOneHouse;
            return this;
        }

        public PropertyFinancialBuilder rentTwoHouse(int rentTwoHouse) {
            this.rentTwoHouse = rentTwoHouse;
            return this;
        }

        public PropertyFinancialBuilder rentThreeHouse(int rentThreeHouse) {
            this.rentThreeHouse = rentThreeHouse;
            return this;
        }

        public PropertyFinancialBuilder rentFourHouse(int rentFourHouse) {
            this.rentFourHouse = rentFourHouse;
            return this;
        }

        public PropertyFinancialBuilder rentHotel(int rentHotel) {
            this.rentHotel = rentHotel;
            return this;
        }

        public PropertyFinancialBuilder mortgageCost(int mortgageCost) {
            this.mortgageCost = mortgageCost;
            return this;
        }

        public PropertyFinancials build(){
            return new PropertyFinancials(name,  price,  rent, pricePerImprovement,  rentOneHouse,  rentTwoHouse,
                    rentThreeHouse,  rentFourHouse, rentHotel,  mortgageCost);
        }
    }
}
