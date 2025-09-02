package com.ivoyant.companydemofordocker;

import com.ivoyant.companydemofordocker.Employee;
import com.ivoyant.companydemofordocker.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class CompanyController {

    @Autowired
    private EmployeeService service;

    @Value("${HOSTNAME:unknown}") // Kubernetes injects Pod name in HOSTNAME env
    private String podName;

    // Get all employees
    @GetMapping
    public List<Employee> getEmployees() {
        return service.getAllEmployees();
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return service.getEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    // Add new employee
    @PostMapping
    public Employee addEmployee(@RequestParam String name) {
        return service.addEmployee(new Employee(name));
    }

    // Update employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestParam String name) {
        return service.updateEmployee(id, new Employee(name));
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Deleted employee with id " + id;
    }

    // Optional: expose Pod name (for Kubernetes testing)
    @GetMapping("/pod")
    public String getPodName() {
        return "Pod Name: " + podName;
    }
}
