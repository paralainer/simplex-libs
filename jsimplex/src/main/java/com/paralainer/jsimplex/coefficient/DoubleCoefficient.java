package com.paralainer.jsimplex.coefficient;

/**
 * Created by Sergey Talov on 10.02.14.
 * email: serg.talov@gmail.com
 */
public class DoubleCoefficient extends Coefficient implements Doubleable {

    public Double value;

    public DoubleCoefficient(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("%.2f", value);
    }

    @Override
    public DoubleCoefficient toDouble() {
        return this;
    }

    @Override
    public Coefficient add(Coefficient coefficient) {
        return new DoubleCoefficient(this.value + doubleValue(coefficient));
    }

    @Override
    public Coefficient divide(Coefficient coefficient) {
        return new DoubleCoefficient(value / doubleValue(coefficient));
    }

    @Override
    public Coefficient multiply(Coefficient coefficient) {
        return new DoubleCoefficient(value * doubleValue(coefficient));
    }

    @Override
    public Coefficient subtract(Coefficient coefficient) {
        return new DoubleCoefficient(value - doubleValue(coefficient));
    }

    private Double doubleValue(Coefficient coefficient) {
        Doubleable doubleable = (Doubleable) coefficient;
        return doubleable.toDouble().getValue();
    }
}
