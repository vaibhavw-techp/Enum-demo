package com.example.EnumDemo.enumC;

public enum Size {
   S, M, L;


    public static Size rangeConversion(Long size) {
        if (size <= 30) return Size.S;
        else if (size >= 50) return Size.L;
        else return Size.M;
    }

}
