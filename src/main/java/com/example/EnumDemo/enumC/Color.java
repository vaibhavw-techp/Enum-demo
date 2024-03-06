package com.example.EnumDemo.enumC;

public enum Color {
    White("white"),
    Black("Black"),
    Yellow("Yellow"),
    Pink("Pink"),
    Green("Green"),
    Grey("Grey"),
    Red("Red"),
    Blue("Blue");

    private String value;

    private Color(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
