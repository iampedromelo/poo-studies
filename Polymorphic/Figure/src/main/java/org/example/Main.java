package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        // FIZ FIGURE COMO INTERFACE

        Figure[] figures = new Figure[150];

        for (int i = 0; i < 50; i++) {
            figures[i] = new Circle(i+1);
            figures[i+50] = new Rectangle(i+1,i+1);
            figures[i+100] = new Triangule(i+1,i+1,i+1);
        }

        double total = 0;
        for (Figure figure: figures){
            total += figure.area();
        }

        System.out.println("The total area of figures is: " + total);
    }
}
