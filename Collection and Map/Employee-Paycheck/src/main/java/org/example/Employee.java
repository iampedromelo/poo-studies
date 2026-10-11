package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Employee {
    private final String id;
    private String name;
    private String jobTitle;
    private double salary;
    private LocalDate dateOfEmployment;
    private final List<Paycheck> paychecks;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        if(!isValid(id,name,jobTitle,salary,dateOfEmployment)){
            throw new IllegalArgumentException("Invalid employee");
        };
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
        this.paychecks = new ArrayList<>();
    }

    public Employee(String id, List<Paycheck> paychecks) {
        this.id = id;
        this.paychecks = paychecks;
    }

    private boolean isValid(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        return (id != null) && (name != null) && (jobTitle != null) && (dateOfEmployment != null) && (salary > 0);
    }

    public double getYearsOfService(){
        return Period.between(dateOfEmployment,LocalDate.now()).getYears();
    }

    public void addPaycheck(LocalDate payday){
        final LocalDate paydayNonNull = Objects.requireNonNull(payday, "Invalid payday");
        paychecks.add(new Paycheck(payday,salary));
    }

    public void removePaycheck(Paycheck oldPaycheck){
        final Paycheck oldPaycheckNonNull = Objects.requireNonNull(oldPaycheck, "Invalid paycheck");
        for (Paycheck paycheck : paychecks){
            if(paycheck.equals(oldPaycheckNonNull)){
                paychecks.remove(paycheck);
                return;
            }
        }
    }

    public Iterator<Paycheck> iteratorPaycheck(){
        return paychecks.iterator();
    }

    public Stream<Paycheck> streamPaycheck(){
        return paychecks.stream();
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
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                ", paychecks=" + paychecks +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setSalary(double salary) {
        if(salary <= 0){
            throw new IllegalArgumentException("Invalid salary");
        }
        this.salary = salary;
    }

    public void setDateOfEmployment(LocalDate dateOfEmployment) {
        this.dateOfEmployment = dateOfEmployment;
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

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
