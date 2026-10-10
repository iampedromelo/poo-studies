package org.example;

import java.util.ArrayList;

public class FindEmployeeService {
    private final Repository<Employee,String> repository;

    public FindEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public Employee findById(String id){
        return repository.getById(id);
    }

    public ArrayList<Employee> findAll(){
        return repository.getAll();
    }
}
