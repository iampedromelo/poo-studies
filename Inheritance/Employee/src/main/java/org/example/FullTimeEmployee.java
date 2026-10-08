package org.example;

import java.time.LocalDate;
import java.util.Objects;

public final class FullTimeEmployee extends Employee {
    private final double monthlySalary;

    public FullTimeEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double monthlySalary) {
        super(id, name, jobTitle, dateOfEmployment);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double salary() {
        return monthlySalary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FullTimeEmployee employee = (FullTimeEmployee) o;
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", jobTitle='" + getJobTitle() + '\'' +
                ", dateOfEmployment=" + getDateOfEmployment()  + '\'' +
                ", monthlySalary=" + monthlySalary +
                '}';
    }
}
