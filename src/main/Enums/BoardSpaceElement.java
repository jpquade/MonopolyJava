package main.Enums;

public enum BoardSpaceElement {
    GO(0),                      // location 0
    MEDITERRANEAN_AVENUE(1),    // location 1
    COMMUNITY_CHEST1(2),        // location 2
    BALTIC_AVENUE(3),           // location 3
    INCOME_TAX(4),              // location 4
    READING_RAILROAD(5),        // location 5
    ORIENTAL_AVENUE(6),         // location 6
    CHANCE1(7),                 // location 7
    VERMONT_AVENUE(8),          // location 8
    CONNECTICUT_AVENUE(9),      // location 9
    JUST_VISITING_JAIL(10),     // location 10
    ST_CHARLES_PLACE(11),       // location 11
    ELECTRIC_COMPANY(12),       // location 12
    STATES_AVENUE(13),          // location 13
    VIRGINIA_AVENUE(14),        // location 14
    PENNSYLVANIA_RAILROAD(15),  // location 15
    ST_JAMES_PLACE(16),         // location 16
    COMMUNITY_CHEST2(17),       // location 17
    TENNESSEE_AVENUE(18),       // location 18
    NEW_YORK_AVENUE(19),        // location 19
    FREE_PARKING(20),           // location 20
    KENTUCKY_AVENUE(21),        // location 21
    CHANCE2(22),                // location 22
    INDIANA_AVENUE(23),         // location 23
    ILLINOIS_AVENUE(24),        // location 24
    B_AND_O_RAILROAD(25),       // location 25
    ATLANTIC_AVENUE(26),        // location 26
    WATER_WORKS(27),            // location 27
    VENTNOR_AVENUE(28),         // location 28
    MARVIN_GARDENS(29),         // location 29
    GO_TO_JAIL(30),             // location 30
    PACIFIC_AVENUE(31),         // location 31
    NORTH_CAROLINA_AVENUE(32),  // location 32
    COMMUNITY_CHEST3(33),       // location 33
    PENNSYLVANIA_AVENUE(34),    // location 34
    SHORT_LINE_RAILROAD(35),    // location 35
    CHANCE3(36),                // location 36
    PARK_PLACE(37),             // location 37
    LUXURY_TAX(38),             // location 38
    BOARDWALK(39),              // location 39
    JAIL(40);                   // location 40 not to be used when counting spaces moved

    private final int value;

    BoardSpaceElement(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
