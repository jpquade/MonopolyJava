import Enums.Color;
import Enums.PropertyType;
import Enums.Token;
import Properties.Property;

import java.sql.Array;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        TurnTracker turnTracker = new TurnTracker();

        turnTracker.turnProgression();
    }
}