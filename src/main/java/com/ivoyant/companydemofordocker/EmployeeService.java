package com.ivoyant.companydemofordocker;


import com.ivoyant.companydemofordocker.Employee;
import com.ivoyant.companydemofordocker.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        return repository.findById(id).map(emp -> {
            emp.setName(updatedEmployee.getName());
            return repository.save(emp);
        }).orElseThrow(() -> new RuntimeException("Employee not found with id " + id));
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
