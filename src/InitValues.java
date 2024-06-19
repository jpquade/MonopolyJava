import Enums.Color;
import Enums.Owner;
import Enums.PropertyType;
import Properties.Property;

import java.util.ArrayList;
import java.util.Arrays;

public class InitValues {

    public ArrayList<Property> propertyAttributes = new ArrayList<>(Arrays.asList(
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Mediterranean Avenue").color(Color.BROWN).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Baltic Avenue").color(Color.BROWN).improvementAllowed(true).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Oriental Avenue").color(Color.LIGHTBLUE).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Vermont Avenue").color(Color.LIGHTBLUE).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Connecticut Avenue").color(Color.LIGHTBLUE).improvementAllowed(true).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("St Charles Place").color(Color.PINK).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("States Avenue").color(Color.PINK).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Virginia Avenue").color(Color.PINK).improvementAllowed(true).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("St. James Place").color(Color.ORANGE).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Tennessee Avenue").color(Color.ORANGE).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("New York Avenue").color(Color.ORANGE).improvementAllowed(true).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Kentucky Avenue").color(Color.RED).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Indiana Avenue").color(Color.RED).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Illinois Avenue").color(Color.RED).improvementAllowed(true).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Atlantic Avenue").color(Color.YELLOW).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Ventnor Avenue").color(Color.YELLOW).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Marvin Gardens").color(Color.YELLOW).improvementAllowed(true).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Pacific Avenue").color(Color.GREEN).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("North Carolina Avenue").color(Color.GREEN).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Pennsylvania Avenue").color(Color.GREEN).improvementAllowed(true).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Park Place").color(Color.DARKBLUE).improvementAllowed(true).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.STANDARD).name("Boardwalk").color(Color.DARKBLUE).improvementAllowed(true).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.UTILITY).name("Electric Company").color(Color.WHITE).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.UTILITY).name("Water Works").color(Color.WHITE).owner(Owner.NONE).build(),

            new Property.PropertyBuilder().propertyType(PropertyType.RAILROAD).name("Reading Railroad").color(Color.BLACK).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.RAILROAD).name("Pennsylvania RailRoad").color(Color.BLACK).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.RAILROAD).name("B&O RailRoad").color(Color.BLACK).owner(Owner.NONE).build(),
            new Property.PropertyBuilder().propertyType(PropertyType.RAILROAD).name("Water Works").color(Color.BLACK).owner(Owner.NONE).build()
    ));
}