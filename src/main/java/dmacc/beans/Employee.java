package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author booth - gboothroyd@dmacc.edu
 *CIS175 - Fall 2021
 * Nov 30, 2021
 */

@Entity
public class Employee {
	@Id
	@GeneratedValue
	 private long id;
	 private String	name;
	 private double	monthlySalary;
	 private int age;

	/**
	 * 
	 */
	 
	
	
	
		public Employee(String name, double monthlySalary, int age) {
			super();
			this.name = name;
			this.monthlySalary = monthlySalary;
			this.age = age;
		}




	/**
	 * 
	 */
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}






	/**
	 * @param id
	 * @param name
	 * @param monthlySalary
	 * @param age
	 */


	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}






	/**
	 * @param name
	 */
	public Employee(String name) {
		super();
		this.name = name;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the monthlySalary
	 */
	public double getMonthlySalary() {
		return monthlySalary;
	}

	/**
	 * @param monthlySalary the monthlySalary to set
	 */
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}




	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", monthlySalary=" + monthlySalary + ", age=" + age + "]";
	}
	
	
	
	

}
