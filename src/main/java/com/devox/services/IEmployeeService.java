package com.devox.services;

import com.devox.bean.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IEmployeeService {

    /**
     *
     * @param employee
     * @return Mono Employee
     */
    Mono<Employee> save(Employee employee);

    Mono findById(int id);

    Flux<Employee> findAllEmployees();

}
