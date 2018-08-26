package com.abhishek;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface EmpDao {
	@SqlUpdate("create table employee(eno NUMBER(5) PRIMARY KEY,name VARCHAR2(20))")
	void createTable();

	@SqlUpdate("INSERT INTO employee (eno,name) VALUES (?,?)")
	void insertPositional(int eno, String name);

	@SqlUpdate("INSERT INTO employee(eno,name) VALUES(:eno,:name)")
	void insertNamed(@Bind("eno") int eno, @Bind("name") String name);
	
	@SqlUpdate("INSERT INTO employee(eno,name) VALUES(:eno,:name)")
	void insertBean(@BindBean Employee employee);
	
	@SqlQuery("SELECT * FROM employee")
	@RegisterBeanMapper(Employee.class)
	List<Employee> empList();
}