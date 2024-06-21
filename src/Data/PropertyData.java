package Data;

import java.util.HashMap;

import Initialization.InitValues;
import Properties.Property;
import Properties.PropertyFinancials;

public class PropertyData {
    private HashMap<String, Property> propertyMap;
    private HashMap<String, PropertyFinancials> propertyFinancialsMap;
    InitValues init;

    public PropertyData(){
        propertyMap = new HashMap<>();
        propertyFinancialsMap = new HashMap<>();
        init = new InitValues();
        initPropertyMap();
    }

    private void initPropertyMap() {for (Property property : init.getPropertyAttributes()) propertyMap.put(property.getName(), property);}
    private void initPropertyFinancialMap() {for (PropertyFinancials propertyFinancials : init.getPropertyFinancialAttributes()) propertyFinancialsMap.put(propertyFinancials.getName(), propertyFinancials);}

    public HashMap<String, Property> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(HashMap<String, Property> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public HashMap<String, PropertyFinancials> getPropertyFinancialsMap() {
        return propertyFinancialsMap;
    }

    public void setPropertyFinancialsMap(HashMap<String, PropertyFinancials> propertyFinancialsMap) {
        this.propertyFinancialsMap = propertyFinancialsMap;
    }

    @Override
    public String toString() {
        return "PropertyData{" +
                "propertyMap=" + propertyMap +
                ", propertyFinancialsMap=" + propertyFinancialsMap +
                '}';
    }
}
