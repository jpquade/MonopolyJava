package main.Enums;

public enum PlayerToken {
    NONE(0),
    CAR(1),
    CAT(2),
    DOG(3),
    HAT(4),
    IRON(5),
    SHIP(6),
    SHOE(7),
    THIMBLE(8);

    private int value;

    PlayerToken(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
