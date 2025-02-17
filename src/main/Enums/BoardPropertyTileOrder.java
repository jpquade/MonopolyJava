package main.Enums;

public enum BoardPropertyTileOrder {
    MEDITERRANEAN_AVENUE(0),
    BALTIC_AVENUE(1),
    READING_RAILROAD(2),
    ORIENTAL_AVENUE(3),
    VERMONT_AVENUE(4),
    CONNECTICUT_AVENUE(5),

    ST_CHARLES_PLACE(6),
    ELECTRIC_COMPANY(7),
    STATES_AVENUE(8),
    VIRGINIA_AVENUE(9),
    PENNSYLVANIA_RAILROAD(10),
    ST_JAMES_PLACE(11),
    TENNESSEE_AVENUE(12),
    NEW_YORK_AVENUE(13),

    KENTUCKY_AVENUE(14),
    INDIANA_AVENUE(15),
    ILLINOIS_AVENUE(16),
    B_AND_O_RAILROAD(17),
    ATLANTIC_AVENUE(18),
    WATER_WORKS(19),
    VENTNOR_AVENUE(20),
    MARVIN_GARDENS(21),

    PACIFIC_AVENUE(22),
    NORTH_CAROLINA_AVENUE(23),
    PENNSYLVANIA_AVENUE(24),
    SHORT_LINE_RAILROAD(25),
    PARK_PLACE(26),
    BOARDWALK(27);

    private final int value;

    BoardPropertyTileOrder(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
