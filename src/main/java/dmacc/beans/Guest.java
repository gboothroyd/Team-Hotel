package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author Dylan Thomas - djthomas4
 * CIS175 - Fall 2021
 * Nov 14, 2021
 */

@Entity
public class Guest {
	@Id
	@GeneratedValue
	private long id;
	private String fName;
	private String lName;
	private String phone;
	private String paymentMethod;

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Guest(String fName, String lName, String phone, String paymentMethod) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.phone = phone;
		this.paymentMethod = paymentMethod;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Guest [id=" + id + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone + ", paymentMethod="
				+ paymentMethod + "]";
	}

}