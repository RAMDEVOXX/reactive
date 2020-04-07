package com.devox.services.implementation;

import com.devox.bean.Employee;
import com.devox.dao.EmployeeDao;
import com.devox.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EmployeeServiceImpl  implements IEmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Mono<Employee> save(Employee employee) {
        return employeeDao.save(employee);
    }

    public Mono findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    public Flux<Employee> findAllEmployees() {
        return employeeDao.findAll();
    }

    public Mono<Employee> update(int id, Employee updatedEmployee) {
        return employeeDao.findById(id)
                .map(employeeToUpdate -> Employee.builder()
                        .firstName(updatedEmployee.getFirstName())
                        .lastName(updatedEmployee.getLastName())
                        .email(updatedEmployee.getEmail())
                        .build())
                .flatMap(employeeDao::save);
    }

    public Mono<Employee> deleteById(int id) {
        return employeeDao.findById(id)
                .flatMap(employee -> employeeDao.delete(employee).then(Mono.just(employee)));
    }
}
