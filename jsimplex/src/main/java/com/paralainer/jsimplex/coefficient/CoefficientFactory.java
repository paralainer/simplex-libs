package com.paralainer.jsimplex.coefficient;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by Sergey Talov on 10.02.14.
 * email: serg.talov@gmail.com
 */
public class CoefficientFactory {

    private static final Producer[] PRODUCERS = {
            new Producer() {
                @Override
                public boolean isAcceptable(String value) {
                    return value.matches("-?[0-9]+");
                }

                @Override
                public Coefficient create(String value) {
                    return new IntegerCoefficient(Integer.valueOf(value));
                }
            },
            new Producer() {
                @Override
                public boolean isAcceptable(String value) {
                    return value.matches("[0-9]+/[0-9]+");
                }

                @Override
                public Coefficient create(String value) {
                    String[] fractions = value.split("/");
                    return new FractionCoefficient(Integer.valueOf(fractions[0]), Integer.valueOf(fractions[1]));
                }
            },
            new Producer() {
                @Override
                public boolean isAcceptable(String value) {
                    return value.matches("-?[0-9]+\\.[0-9]+");
                }

                @Override
                public Coefficient create(String value) {
                    return new DoubleCoefficient(Double.valueOf(value));
                }
            }
    };


    public static Coefficient createCoefficient(String value) {
        for (Producer producer : PRODUCERS) {
            if (producer.isAcceptable(value)) {
                return producer.create(value);
            }
        }

        throw new IllegalArgumentException("Value " + value + " is not supported for coefficient matrix");

    }

    private abstract static class Producer {

        public abstract boolean isAcceptable(String value);

        public abstract Coefficient create(String value);
    }
}
