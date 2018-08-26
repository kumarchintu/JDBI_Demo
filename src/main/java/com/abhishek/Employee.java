package com.abhishek;

public class Employee {
	private Integer eno;
	private String name;

	public Employee() {
	}

	public Employee(Integer eno, String name) {
		this.eno = eno;
		this.name = name;
	}

	public Integer getEno() {
		return eno;
	}

	public void setEno(Integer eno) {
		this.eno = eno;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}