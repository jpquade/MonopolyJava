import Properties.Property;

public class Main {
    public static void main(String[] args) {

        InitValues initValues = new InitValues();

        //System.out.println(initValues.propertyName.toString());

        int numberOfProperties = 28;

        Property[] property = new Property[numberOfProperties];

        for(int i = 0; i < numberOfProperties; i++){
            String name = initValues.propertyAttributes.get(i).get(0);
            String color = initValues.propertyAttributes.get(i).get(1);
            int cost;

            try{
                cost = Integer.parseInt(initValues.propertyAttributes.get(i).get(2));
            }
            catch(NumberFormatException e){
                cost = 0;
            }

            property[i] = new Property(name, cost, color);
        }
        for (Property value : property) {
            System.out.println(value.getName() + " " + value.getColor()  + " " + value.getCost()+ " " + value);
        }

    }
}