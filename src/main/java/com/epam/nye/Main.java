package com.epam.nye;

import com.epam.nye.entities.Employee;
import com.epam.nye.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
            Employee employee = new Employee("Barbara", 27);
            Employee employee2 = new Employee("Kornel", 25);
            Employee employee3 = new Employee("Peter", 26);
            Employee employee4 = new Employee("Tamas", 37);

            employeeRepository.saveAll(List.of(employee, employee2, employee3, employee4));

            Employee peter = employeeRepository.findById(3L).get();

            System.out.println(peter);
        };
    }


}