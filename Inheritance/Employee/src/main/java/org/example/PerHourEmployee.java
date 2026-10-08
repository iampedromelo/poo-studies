package org.example;

import java.time.LocalDate;
import java.util.Objects;

public final class PerHourEmployee extends Employee{
    private final double hourlyRate;
    private final double workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate, double workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    double salary() {
        return hourlyRate * workedHour;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double getWorkedHour() {
        return workedHour;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PerHourEmployee employee = (PerHourEmployee) o;
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "PerHourEmployee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", jobTitle='" + getJobTitle() + '\'' +
                ", dateOfEmployment=" + getDateOfEmployment() + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", workedHour=" + workedHour +
                '}';
    }
}
