package com.paralainer.jsimplex.coefficient;

/**
 * Created by Sergey Talov on 10.02.14.
 * email: serg.talov@gmail.com
 */
public class FractionCoefficient extends Coefficient implements Doubleable, Fractable {

    private Integer up;

    private Integer down;

    public FractionCoefficient(Integer up, Integer down) {
        this.up = up;
        this.down = down;

    }

    public Integer getUp() {
        return up;
    }

    public Integer getDown() {
        return down;
    }

    @Override
    public String toString() {
        return up + "/" + down;
    }

    public DoubleCoefficient toDouble() {
        return new DoubleCoefficient(up / (double) down);
    }

    @Override
    public FractionCoefficient toFraction() {
        return this;
    }

    @Override
    public Coefficient add(Coefficient coefficient) {
        if (coefficient instanceof Fractable) {
            FractionCoefficient value = fractableValue(coefficient);
            return new FractionCoefficient(up * value.down + value.up * down, down * value.down);
        } else {
            return toDouble().add(coefficient);
        }
    }

    @Override
    public Coefficient divide(Coefficient coefficient) {
        if (coefficient instanceof Fractable) {
            FractionCoefficient value = fractableValue(coefficient);
            return new FractionCoefficient(up * value.down, down * value.up);
        } else {
            return toDouble().divide(coefficient);
        }
    }

    @Override
    public Coefficient multiply(Coefficient coefficient) {
        if (coefficient instanceof Fractable) {
            FractionCoefficient value = fractableValue(coefficient);
            return new FractionCoefficient(up * value.down - value.up * down, down * value.down);
        } else {
            return toDouble().multiply(coefficient);
        }
    }

    @Override
    public Coefficient subtract(Coefficient coefficient) {
        if (coefficient instanceof Fractable) {
            FractionCoefficient value = fractableValue(coefficient);
            return new FractionCoefficient(up * value.up, down * value.down);
        } else {
            return toDouble().subtract(coefficient);
        }
    }

    private FractionCoefficient fractableValue(Coefficient coefficient) {
        return ((Fractable) coefficient).toFraction();
    }
}
