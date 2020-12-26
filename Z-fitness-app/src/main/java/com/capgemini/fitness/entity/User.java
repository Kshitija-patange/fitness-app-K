package com.capgemini.fitness.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 
 * This is User POJO Class
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class User{
	//private static final long serialVersionUID = 1L;
	@Id
	@Column(name="user_id")
	private Integer userId;
	@NotNull
	@Column(name="f_name")
	private String fname;
	@NotNull
	@Column(name="l_name")
	private String lname;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z.0-9]*@[a-zA-Z]+([.][a-zA-Z]{2,3}){1,2}$",
		    message = "Invalid emaiId")
	@Column(name="email_id")
	private String emailId;
	@NotNull
	@Column(name="shipping_address")
	private String shippingAddress;
	@Column(name="country")
	private String country;
	@Column(name="state")
	private String state;
	@NotNull
	@Column(name="city")
	private String city;
	@NotNull
	@Size(min=6 ,max=6)
	@Column(name="pincode")
	private Integer pincode;
//	@Range(min = 10,message ="Mobile number is a 10-digit number" )
	@Column(name="mobile_no",length=10)
	private Long mobileNo;
	@NotNull
	@Column(name="age")
	private Integer age;

	/*
	 * many to many relation between user and trainer
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_trainer", 
	joinColumns = { @JoinColumn(name = "user_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "trainer_id") })
	private Set<Trainer> trainers;

	/*
	 * one to many relation with user and appointment
	 */
	@OneToMany(mappedBy = "user")
	private Set<Appointment> appointment;
    
	/*

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<Trainer> getTrainers() {
		return trainers;
	}

	public void setTrainers(Set<Trainer> trainers) {
		this.trainers = trainers;
	}

	public Set<Appointment> getAppointment() {
		return appointment;
	}
	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", fname=" + fname + ", lname=" + lname + ", emailId=" + emailId
				+ ", shippingAddress=" + shippingAddress + ", country=" + country + ", state=" + state + ", city="
				+ city + ", pincode=" + pincode + ", mobileNo=" + mobileNo + ", age=" + age  + "]";
	}
*/
}