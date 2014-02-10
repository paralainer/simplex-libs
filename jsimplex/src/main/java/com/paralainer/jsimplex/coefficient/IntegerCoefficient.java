package com.paralainer.jsimplex.coefficient;

/**
 * Created by Sergey Talov on 10.02.14.
 * email: serg.talov@gmail.com
 */
public class IntegerCoefficient extends Coefficient implements Doubleable, Fractable {

    private Integer value;

    public IntegerCoefficient(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String toString(){
        return value.toString();
    }

    public FractionCoefficient toFraction(){
        return new FractionCoefficient(value, 1);
    }

    public DoubleCoefficient toDouble(){
        return new DoubleCoefficient(Double.valueOf(value));
    }

    @Override
    public Coefficient add(Coefficient coefficient) {
        if (coefficient instanceof IntegerCoefficient){
           return new IntegerCoefficient(value + intValue(coefficient));
        } else {
            return toFraction().add(coefficient);
        }
    }

    @Override
    public Coefficient divide(Coefficient coefficient) {
        if (coefficient instanceof IntegerCoefficient){
            return new FractionCoefficient(value, intValue(coefficient));
        } else {
            return toFraction().divide(coefficient);
        }
    }

    @Override
    public Coefficient multiply(Coefficient coefficient) {
        if (coefficient instanceof IntegerCoefficient){
            return new IntegerCoefficient(value * intValue(coefficient));
        } else {
            return toFraction().multiply(coefficient);
        }
    }

    @Override
    public Coefficient subtract(Coefficient coefficient) {
        if (coefficient instanceof IntegerCoefficient){
            return new IntegerCoefficient(value - intValue(coefficient));
        } else {
            return toFraction().subtract(coefficient);
        }
    }

    private Integer intValue(Coefficient coefficient){
        return ((IntegerCoefficient) coefficient).value;
    }
}
