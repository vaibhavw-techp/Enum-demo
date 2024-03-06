package com.example.EnumDemo.enumC;

public enum Size {
   S, M, L;

    private String value;

    public static Size rangeConversion(Long size) {
        if (size <= 30) return Size.S;
        else if (size >= 50) return Size.L;
        else return Size.M;
    }

    public static Long getDressSizeLong1(Size size){
        switch (size) {
            case S:
                return 30L;
            case M:
                return 40L;
            case L:
                return 50L;
        }
        return 0L;
    }
}
