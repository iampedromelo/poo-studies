package org.example;

import java.time.LocalDate;

public class Main {
    static void main() {
        Employee[] newEmployees = {
                new Employee("id-01", "Pedro", "Analista Senior", LocalDate.of(2022,07,18)),
                new Employee("id-02", "Natalia", "Analista Junior", LocalDate.of(2024,12,01)),
                new Employee("id-03", "Yuri", "Analista Senior", LocalDate.of(2022,05,25))
        };
        Employee employeeDuplicated = new Employee("id-01", "Pedro II", "Analista Senior II", LocalDate.of(2022,07,18));

        Repository<Employee,String> repository = new FakeEmployeeRepository();

        RegisterEmployeeService registerEmployeeService = new RegisterEmployeeService(repository);
        FindEmployeeService findEmployeeService = new FindEmployeeService(repository);

        for (int i = 0; i < 3; i++) {
            registerEmployeeService.register(newEmployees[i]);
        }

        //adicionado o duplicado
        registerEmployeeService.register(employeeDuplicated);

        System.out.println("Employee with id-01");
        System.out.println(findEmployeeService.findById("id-01").toString());

        //experimentando outros metodos, deveria ter criado ums service para o getAll();
        System.out.println("The first employee");
        System.out.println((findEmployeeService.findAll()).getFirst().toString());

        System.out.println("All employees");
        findEmployeeService.findAll().stream().map(Employee::toString).forEach(System.out::println);

        /*
        Abordagens interessantes: Os services poderiam ser registerService e findService (genericos) e ao instanciar, escolheriamos qual objeto usariamos nessas instancias. Inclusive criar uma instancia de service para tipo de objeto.
        */

    }
}
