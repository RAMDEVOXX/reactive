package com.devox.dao;

import com.devox.bean.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

//@Repository
//classic jpa respository block
//public interface EmployeeDao extends JpaRepository<Employee, Integer>, CrudRepository<Employee, Integer> {
public interface EmployeeDao extends ReactiveMongoRepository<Employee, Integer> {
    // -> https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html
    // -> https://www.baeldung.com/queries-in-spring-data-mongodb
}
