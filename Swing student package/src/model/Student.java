package model;

public class Student {
	private int roll;
	private String name;
	private String address;

	public String getAddress() {
		return address;
	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	public int getRoll() {
		return roll;
	}
//	public void setRoll(int roll) {
//		this.roll = roll;
//	}
	public Student(int roll) 
	{
		super();
		this.roll = roll;
		
	}
	public Student(String name, String address) 
	{
		super();
		this.name = name;
		this.address = address;
	}
	public Student(int roll, String name, String address) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
	}


}
