package com.example.serverlessFunction.repository;

import com.example.serverlessFunction.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class EmpDao {

    public List<Employee> listOfEmp(){
        return Stream.of(
                new Employee("1","karthik","Asst.Sys.Eng","24000"),
                new Employee("2","Guru","Sys eng","43000"),
                new Employee("3","Madhu","IT Analyst","67856")
        ).collect(Collectors.toList());
    }
}
