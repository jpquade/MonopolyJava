import java.util.ArrayList;
import java.util.Arrays;

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
            boolean improvementAllowed = true;

            try{
                cost = Integer.parseInt(initValues.propertyAttributes.get(i).get(2));
            }
            catch(NumberFormatException e){
                cost = 0;
            }

            if(initValues.propertyAttributes.get(i).size() > 3){
                improvementAllowed = Boolean.parseBoolean(initValues.propertyAttributes.get(i).get(3));
            }

            property[i] = new Property(name, cost, color, improvementAllowed);
        }
        for (Property value : property) {
            System.out.println(value.getName() + " " + value.getColor()  + " " + value.getCost()+ " " + value.isImprovementAllowed());
        }

    }
}