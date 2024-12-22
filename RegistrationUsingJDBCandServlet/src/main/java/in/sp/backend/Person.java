package in.sp.backend;

public class Person 

{
	
	String name;
	String email;
	long number;
	
	
	
	public Person(String name, String email, long number) {


		this.name = name;
		this.email = email;
		this.number = number;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public long getNumber() {
		return number;
	}



	public void setNumber(long number) {
		this.number = number;
	}
	
	
	

}
