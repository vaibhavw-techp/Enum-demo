package com.example.EnumDemo.enumC;

public enum Type {
    Tshirt("Tshirt"),
    Formal("Formal"),
    Jacket("Jacket"),
    Jerkin("Jerkin"),
    Polo("Polo"),
    Hoody("Hoody"),
    Turtleneck("Turtleneck");

    private String value;

    private Type(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
