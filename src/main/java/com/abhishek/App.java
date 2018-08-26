package com.abhishek;

import java.util.List;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class App {
	public static void main(String[] args) throws Exception {
		Jdbi jdbi = Jdbi.create("jdbc:oracle:thin:@localhost:1521:orcl", "spring", "spring");
		jdbi.installPlugin(new SqlObjectPlugin());

		List<Employee> empNames = jdbi.withExtension(EmpDao.class, dao -> {
			dao.createTable();
			dao.insertPositional(1, "Abhishek");
			dao.insertNamed(2, "Deb");
			dao.insertBean(new Employee(3, "Chintu"));
			return dao.empList();
		});

		for (Employee employee : empNames) {
			System.out.println(employee);
		}
	}
}