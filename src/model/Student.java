package model;

public class Student {

	private int id;
	private String lastname;
	private String firstname;
	private String streetaddress;
	private int postcode;
	private String postoffice;
	
	public Student() {
		id = -1;
		lastname = "";
		firstname = "";
		streetaddress = "";
		postcode = -1;
		postoffice = "";
	}
	
	public Student(int id, String firstname, String lastname, String streetaddress, int postcode, String postoffice ) {
		this.id = id;
		this.lastname = lastname;
		this.firstname = firstname;
		this.streetaddress = streetaddress;
		this.postcode = postcode;
		this.postoffice = postoffice;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getStreetaddress() {
		return streetaddress;
	}

	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getPostoffice() {
		return postoffice;
	}

	public void setPostoffice(String postoffice) {
		this.postoffice = postoffice;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", lastname=" + lastname + ", firstname=" +firstname + ", streetaddress=" + streetaddress + ", postcode=" + postcode + ", postoffice" + postoffice + "]";
	}
	
	
}
