package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Triangle triangle = new Triangle(0,0,3,4,5);
        Circle circle = new Circle(0,0,2);
        Rectangle rectangle = new Rectangle(0,0,5.1,2);

        System.out.printf("A área do triângulo de lados %f, %f, %f é %.2f \n", triangle.getA(), triangle.getB(), triangle.getC(), triangle.area());
        System.out.printf("A área do  círculo de raio %f é %.2f \n", circle.getRadius(), circle.area());
        System.out.printf("A área do retângulo de lados %f e %f é %.2f \n", rectangle.getWidth(), rectangle.getLength(), rectangle.area());
    }
}
