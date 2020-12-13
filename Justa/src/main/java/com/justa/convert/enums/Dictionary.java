package com.justa.convert.enums;

import java.math.BigDecimal;

public enum Dictionary {

    HECTARE("ha", "10000", "hectare", "m²"),
    DAY("d", "86400", "day", "s"),
    DEGREE("°", "3.14159265358979323846/180", "degree", "rad"),
    ARCMINUTE("´", "3.14159265358979323846/10800", "arcminute", "rad"),
    ARCSECOND("\"", "3.14159265358979323846/648000", "arcsecond", "rad"),
    MINUTE("min", "60", "minute", "s"),
    HOUR("h", "3600", "hour","s"),
    LITRE("L", "0.001", "litre","m³"),
    TONNE("t", "1000", "tonne", "kg");



    private final String symbol;
    private final String value;
    private final String name;
    private final String unit;
    private final BigDecimal pi = new BigDecimal("3.14159265358979323846");

    Dictionary(String symbol, String value, String name, String unit) {
        this.symbol = symbol;
        this.value = value;
        this.name = name;
        this.unit = unit;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getUnit() {
        return unit;
    }
}
