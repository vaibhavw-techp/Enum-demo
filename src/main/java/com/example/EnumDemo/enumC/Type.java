package com.example.EnumDemo.enumC;

public enum Type {
    TSHIRT("Tshirt"),
    FORMAL("Formal"),
    JACKET("Jacket"),
    JERKIN("Jerkin"),
    POLO("Polo"),
    HOODY("Hoody"),
    TURTLE_NECK("Turtleneck");

    private String value;

    private Type(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
