package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee {
    private final String id;
    private final String name;
    private final String jobTitle;
    private final LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }

    public double getYearsOfService(){
        LocalDate dateNow = LocalDate.now();
        return Period.between(dateNow,dateOfEmployment).getYears();
    }

    public double calculateBonus(){
        return 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
