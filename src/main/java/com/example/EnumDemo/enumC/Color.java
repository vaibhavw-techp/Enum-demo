package com.example.EnumDemo.enumC;

public enum Color {
    WHITE("white"),
    BLACK("Black"),
    YELLOW("Yellow"),
    PINK("Pink"),
    GREEN("Green"),
    GREY("Grey"),
    RED("Red"),
    BLUE("Blue");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
