package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Paycheck {
    private LocalDate payday;
    private double salary;

    public Paycheck(LocalDate payday, double salary) {
        this.payday = payday;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paycheck paycheck = (Paycheck) o;
        return Double.compare(salary, paycheck.salary) == 0 && Objects.equals(payday, paycheck.payday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payday, salary);
    }

    public void setPayday(LocalDate payday) {
        this.payday = payday;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public double getSalary() {
        return salary;
    }
}
