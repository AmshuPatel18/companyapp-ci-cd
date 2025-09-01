package com.ivoyant.companydemofordocker;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/employees")
    public class CompanyController {

        private final List<String> students = new ArrayList<>();

        @GetMapping
        public List<String> getEmployees() {
            return students;
        }
        @Value("${HOSTNAME:unknown}") // Kubernetes injects Pod name in HOSTNAME env
        private String podName;

        @PostMapping
        public String addEmployee(@RequestParam String name) {
            students.add(name);
            return "Added: " + name;
        }
    }

