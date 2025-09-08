package com.ivoyant.companydemofordocker;



import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/employees")
public class CompanyController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestParam String name) {
        Employee emp = new Employee(name);
        return employeeRepository.save(emp);
    }
}
