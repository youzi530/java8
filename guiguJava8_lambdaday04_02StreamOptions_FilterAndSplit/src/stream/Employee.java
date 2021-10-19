package stream;

import java.util.Objects;

public class Employee {

	private Integer id;
	private String name;
	private Integer age;
	private double salary;

	public Employee(Integer id, String name, Integer age, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return Double.compare(employee.salary, salary) == 0 && Objects.equals(id, employee.id) && Objects.equals(name, employee.name) && Objects.equals(age, employee.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, age, salary);
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", salary=" + salary +
				'}';
	}
}
