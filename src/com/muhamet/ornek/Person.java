package com.muhamet.ornek;

import java.io.Serializable;



public class Person implements Serializable{

	String gender;
	String email;
	String phone;
	String nat;
	Name name;
	
	
	
	public Person() {
		super();
	}



	public Person(String gender, String email, String phone, String nat, Name name) {
		super();
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.nat = nat;
		this.name = name;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getNat() {
		return nat;
	}



	public void setNat(String nat) {
		this.nat = nat;
	}



	public Name getName() {
		return name;
	}



	public void setName(Name name) {
		this.name = name;
	}



	static class Name implements Serializable{
		 String title;
		 String first;
		 String last;
		 
		 
		public Name() {
			super();
		}
		public Name(String title, String first, String last) {
			super();
			this.title = title;
			this.first = first;
			this.last = last;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getFirst() {
			return first;
		}
		public void setFirst(String first) {
			this.first = first;
		}
		public String getLast() {
			return last;
		}
		public void setLast(String last) {
			this.last = last;
		}
		 
		 
	 }
}
