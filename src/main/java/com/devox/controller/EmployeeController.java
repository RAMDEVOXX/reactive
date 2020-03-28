package com.devox.controller;

import com.devox.bean.Employee;
import com.devox.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> save(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Mono findById(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @GetMapping
    public Flux<Employee> findAllEmployees(){
        return employeeService.findAllEmployees();
    }


}
