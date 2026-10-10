package org.example;

import java.util.ArrayList;
import java.util.List;

public class FakeEmployeeRepository implements Repository<Employee,String>{
    private final ArrayList<Employee> employees;

    public FakeEmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    @Override
    public void save(Employee entity) {
        if(getById(entity.getId()) == null){
            employees.add(entity);
        }
    }

    @Override
    public Employee getById(String id) {
        for (Employee employee : employees){
            if(employee.getId().equals(id)){
                return employee;
            }
        }
        return null;
    }

    public ArrayList<Employee> getAll() {
        return (ArrayList<Employee>) employees.clone();
    }
}
