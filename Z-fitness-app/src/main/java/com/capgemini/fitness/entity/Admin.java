package com.capgemini.fitness.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 
 * This is Admin POJO Class
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "admin")
public class Admin {

	@Id
	@Column(name = "admin_id")
	private Integer admin_id;
	@NotNull
	@Column(name = "admin_name")
	private String admin_name;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z.0-9]*@[a-zA-Z]+([.][a-zA-Z]{2,3}){1,2}$",
	    message = "Invalid emaiId")
	@Column(name = "email_id")
	private String emailId;
	@NotNull
	@Column(name = "address")
	private String address;
	
	//@Range(min = 10,message ="Mobile number is a 10-digit number" )
	@NotNull
	@Column(name = "mobile_no",length=10)
	private Long mobileNo;
/*
	public Admin()
	{

	}
	
	
	public Admin(Integer admin_id, String admin_name,
			@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z.0-9]*@[a-zA-Z]+([.][a-zA-Z]{2,3}){1,2}$", message = "Invalid emaiId") String email,
			String address, Long mobile) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		Email = email;
		Address = address;
		Mobile = mobile;
	}

*/
	/*
	 * public Admin(Integer admin_id, String admin_name, String email, String
	 * address, Long mobile) { super(); this.admin_id = admin_id; this.admin_name =
	 * admin_name; Email = email; Address = address; Mobile = mobile; }
	 */
/*
	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Long getMobile() {
		return Mobile;
	}

	public void setMobile(Long mobile) {
		Mobile = mobile;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", Email=" + Email + ", Address="
				+ Address + ", Mobile=" + Mobile + "]";
	}
	
	
*/	

}