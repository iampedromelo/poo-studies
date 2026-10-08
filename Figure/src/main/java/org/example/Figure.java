package org.example;

public abstract class Figure  {
    private final double x;
    private final double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract int hashCode();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
