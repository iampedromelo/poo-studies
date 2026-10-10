package org.example;

public class RegisterEmployeeService {
    private final Repository<Employee,String> repository;

    public RegisterEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    void register(Employee e){
        if(repository.getById(e.getId()) == null){
            repository.save(e);
        }
    }
}
