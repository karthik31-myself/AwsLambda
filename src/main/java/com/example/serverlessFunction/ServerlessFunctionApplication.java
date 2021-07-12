 package com.example.serverlessFunction;

import com.example.serverlessFunction.entity.Employee;
import com.example.serverlessFunction.repository.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class ServerlessFunctionApplication {

	@Autowired
	private EmpDao empDao;

	@Bean
	public Supplier<String> showSom(){
		return()-> "Hello Karthik";
	}

	@Bean
	public Function<String, String> toLower(){
		return(input)->new StringBuilder(input).toString().toLowerCase();
	}

	@Bean
	public Consumer<String> sayMyName(){
		return(name)-> System.out.println(name);
	}


	@Bean
	public Function<Integer, List<Employee>> findEmpById(){
		return(input)-> empDao.listOfEmp().stream()
				.filter(employee -> employee.getId().equals(input)).collect(Collectors.toList());
	}

	@Bean
	public Supplier<List<Employee>> showAll(){
		return()-> empDao.listOfEmp().stream().collect(Collectors.toList());
	}


public static void main(String[] args) {
		SpringApplication.run(ServerlessFunctionApplication.class, args);
	}


}
