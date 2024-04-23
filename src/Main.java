public class Main {
    public static void main(String[] args) {

        InitValues initValues = new InitValues();

        System.out.println(initValues.propertyName.toString());

        Property[] property = new Property[28];

        for(int i = 0; i < 28; i++){
            property = new Property(initValues.propertyName.get(i), initValues.propertyCost.get(i), initValues.propertyColor.get(i), false, false)[i];
        }
    }
}