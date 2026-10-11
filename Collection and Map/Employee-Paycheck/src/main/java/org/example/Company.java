package org.example;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Company {
    private final Map<String,Employee> employees;

    public Company() {
        this.employees = new TreeMap<>();
    }

    public void hire(String id, String name, String jobTitle, LocalDate dateOfEmployment, double salary){
        final String idNonNull = Objects.requireNonNull(id,"Invalid id");
        if(employees.containsKey(idNonNull)){
            throw new IllegalStateException("Employee already exist");
        }
        employees.put(id,new Employee(id,name,jobTitle,salary,dateOfEmployment));
    }

    public void hire(Employee employee){
        final Employee employeeNonNull = Objects.requireNonNull(employee,"Invalid employee");
        if(employees.containsKey(employeeNonNull.getId())){
            throw new IllegalStateException("Employee already exist");
        }
        employees.put(employeeNonNull.getId(),employeeNonNull);
    }

    public void fire(String id){
        final String idNonNull = Objects.requireNonNull(id,"Invalid id");
        if(!employees.containsKey(idNonNull)){
            throw  new IllegalStateException("Employee does not exist");
        }
        employees.remove(idNonNull);
    }

    public List<Employee> getEmployees(){
        //return employees.values().iterator();
        return employees.values().stream().toList();
    }

    public List<Employee> getEmployees(String jobTitle){
        final String jobTitleNonNUll = Objects.requireNonNull(jobTitle,"Invalid jobTitle");
        //return employees.values().stream().filter(e -> jobTitleNonNUll.equals(e.getJobTitle())).iterator();
        return employees.values().stream().filter(e -> jobTitleNonNUll.equals(e.getJobTitle())).toList();
    }

    public void pay(String id){
        final String idNonNull = Objects.requireNonNull(id,"Invalid id");
        if(!employees.containsKey(idNonNull)){
            throw  new IllegalStateException("Employee does not exist");
        }

        employees.get(idNonNull).addPaycheck(LocalDate.now());
    }

    public void increaseSalary(String id, double newSalary){
        final String idNonNull = Objects.requireNonNull(id,"Invalid id");
        if(!employees.containsKey(idNonNull)) {
            throw new IllegalStateException("Employee does not exist");
        }
            employees.get(idNonNull).setSalary(newSalary);
    }

    //the average salary of the moment, without considering the previous paychecks
    public double averageSalary(String jobTitle){
        final String jobTitleNonNUll = Objects.requireNonNull(jobTitle,"Invalid jobTitle");
        return employees.values().stream().filter(e -> jobTitleNonNUll.equals(e.getJobTitle())).mapToDouble(Employee::getSalary).average().orElse(0);
    }

    // the average salary considering the paychecks of which employee between the period
    public double averageSalary(LocalDate startDate, LocalDate endDate){
        final LocalDate startDateNonNull = Objects.requireNonNull(startDate, "Invalid startDate");
        final LocalDate endNonNull = Objects.requireNonNull(endDate, "Invalid endDate");

        return employees.values().stream().flatMap(Employee::streamPaycheck).filter(paycheck -> startDate.isBefore(paycheck.getPayday()) && endDate.isAfter((paycheck.getPayday()))).mapToDouble(Paycheck::getSalary).average().orElse(0);
    }


}
