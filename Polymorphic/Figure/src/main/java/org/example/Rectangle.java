package org.example;

import java.util.Objects;

public class Rectangle implements Figure{
    private final double width;
    private final double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(width, rectangle.width) == 0 && Double.compare(length, rectangle.length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }
}
