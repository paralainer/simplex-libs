package com.paralainer.jsimplex.coefficient;

/**
 * Created by Sergey Talov on 10.02.14.
 * email: serg.talov@gmail.com
 */
public abstract class Coefficient {

    public abstract Coefficient add(Coefficient coefficient);

    public abstract Coefficient divide(Coefficient coefficient);

    public abstract Coefficient multiply(Coefficient coefficient);

    public abstract Coefficient subtract(Coefficient coefficient);
}
