package org.example;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("ID-1", "Person 1", "CEO", LocalDate.of(2005,12,13), 20_000);
        PerHourEmployee perHourEmployee = new PerHourEmployee("ID-2", "Person 2","CFO", LocalDate.now(),15.5,200);

        System.out.println(fullTimeEmployee.toString() + " Salary: " + fullTimeEmployee.salary());
        System.out.println(perHourEmployee.toString() + " Salary: " + perHourEmployee.salary());


        //creating another PerHourEmplooyee with id-1
        FullTimeEmployee anotherFullTimeEmployee = new FullTimeEmployee("ID-1", "Another Person","CTO", LocalDate.now(),15.5);
        System.out.println(anotherFullTimeEmployee.toString());

        System.out.println("Are the fullTimeEmployeee equals to the anotherFullTimeEmployee? " + (fullTimeEmployee.equals(anotherFullTimeEmployee)? "Yes" : "No"));

    }
}
