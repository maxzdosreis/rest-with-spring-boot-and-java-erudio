package org.maxzdosreis.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String FirstName;
	private String LastName;
	private String address;
	private String gender;
	
	public Person() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(FirstName, LastName, address, gender, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(FirstName, other.FirstName) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(address, other.address) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id);
	}
	
	
}
