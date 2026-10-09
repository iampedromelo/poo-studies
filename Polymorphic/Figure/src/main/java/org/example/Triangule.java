package org.example;

import java.util.Objects;

public class Triangule implements Figure{
    private final double a;
    private final double b;
    private final double c;

    public Triangule(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private double semiperimeter(){
        return (a + b + c)/2;
    }

    @Override
    public double area() {
        double p = semiperimeter();
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangule triangule = (Triangule) o;
        return Double.compare(a, triangule.a) == 0 && Double.compare(b, triangule.b) == 0 && Double.compare(c, triangule.c) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
