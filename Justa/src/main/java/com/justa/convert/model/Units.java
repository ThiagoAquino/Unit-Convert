package com.justa.convert.model;

import com.udojava.evalex.Expression;
import com.justa.convert.enums.Dictionary;
import java.math.BigDecimal;


public class Units {
    private String unit_name;
    private BigDecimal multiplication_factor;

    public Units(String unit_name, BigDecimal multiplication_factor) {
        this.unit_name = unit_name;
        this.multiplication_factor = multiplication_factor;
    }

    public Units() {
    }

    public Units ConvertUnits(String units) throws Exception {
        if (units.isEmpty() || units.isBlank() || units == null) {
            throw new Exception("you passed a invalid string");
        } else {
            this.unit_name = units;
            for (Dictionary dic : Dictionary.values()) {
                if ( this.unit_name.contains(dic.getName())) {
                    this.unit_name = this.unit_name.replace(dic.getName(), dic.getUnit());
                    units = units.replace(dic.getName(), dic.getValue());


                } else if (!dic.getSymbol().equalsIgnoreCase("d") &&  this.unit_name.contains(dic.getSymbol())) {
                    this.unit_name = this.unit_name.replace(dic.getSymbol(), dic.getUnit());
                    units = units.replace(dic.getSymbol(), dic.getValue());

                } else if (dic.getSymbol().equalsIgnoreCase("d")
                        &&  this.unit_name.contains(dic.getSymbol())) {

                    var letter = this.unit_name.indexOf('d');
                    if (letter == 0 && (this.unit_name.charAt(letter + 1) != 'e')) {

                        this.unit_name = this.unit_name.replace(dic.getSymbol(), dic.getUnit());
                        units = units.replace(dic.getSymbol(), dic.getValue());

                    } else if (this.unit_name.endsWith("d") &&
                            ((letter > 0)
                                    && (this.unit_name.charAt(letter - 1) != 'a')
                                    && (this.unit_name.charAt(letter - 1) != 'n'))) {
                        this.unit_name = this.unit_name.replace(dic.getSymbol(), dic.getUnit());
                        units = units.replace(dic.getSymbol(), dic.getValue());
                    }

                }
            }
            units = units.replaceAll("()", "");
            Expression expression = new Expression(units);
            expression.setPrecision(18);
            this.multiplication_factor = expression.eval();
        }

        return new Units(this.unit_name, this.multiplication_factor);
    }



    public String getUnit_name() {
        return unit_name;
    }

    public BigDecimal getMultiplication_factor() {
        return multiplication_factor;
    }


}

