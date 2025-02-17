package main.Enums;

public enum PropertyNames {

    MEDITERRANEAN_AVENUE(0),
    BALTIC_AVENUE(1),
    ORIENTAL_AVENUE(2),
    VERMONT_AVENUE(3),
    CONNECTICUT_AVENUE(4),
    ST_CHARLES_PLACE(5),
    STATES_AVENUE(6),
    VIRGINIA_AVENUE(7),
    ST_JAMES_PLACE(8),
    TENNESSEE_AVENUE(9),
    NEW_YORK_AVENUE(10),
    KENTUCKY_AVENUE(11),
    INDIANA_AVENUE(12),
    ILLINOIS_AVENUE(13),
    ATLANTIC_AVENUE(14),
    VENTNOR_AVENUE(15),
    MARVIN_GARDENS(16),
    PACIFIC_AVENUE(17),
    NORTH_CAROLINA_AVENUE(18),
    PENNSYLVANIA_AVENUE(19),
    PARK_PLACE(20),
    BOARDWALK(21),

    ELECTRIC_COMPANY(22),
    WATER_WORKS(23),

    READING_RAILROAD(24),
    PENNSYLVANIA_RAILROAD(25),
    B_AND_O_RAILROAD(26),
    SHORT_LINE_RAILROAD(27);

    private final int value;

    PropertyNames(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
