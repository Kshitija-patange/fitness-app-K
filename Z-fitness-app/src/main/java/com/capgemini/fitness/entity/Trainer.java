package com.capgemini.fitness.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 
 * This is Trainer POJO Class
 */

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name="trainer")
public class Trainer {
	//private static final long serialVersionUID = 1L;
	@Id
	@Column(name="trainer_id")
	private Integer trainerId;
	@NotNull
	@Column(name="trainer_name")
	private String trainerName;
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]+[a-zA-Z.0-9]*@[a-zA-Z]+([.][a-zA-Z]{2,3}){1,2}$",
		    message = "Invalid emaiId")
	@Column(name="email_id")
	private String emailId;
	@Column(name="address")
	private String address;
	//@Range(min = 10,message ="Mobile number is a 10-digit number" )
	@Column(name="mobile_no",length=10)
	private Long mobileNo;

	/*
	 *  many to many relation between user and trainer
	 */
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="trainers")
	private Set<User> users;

	/*
	public Integer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Integer trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Trainer [trainerId=" + trainerId + ", trainerName=" + trainerName + ", emailId=" + emailId
				+ ", address=" + address + ", mobileNo=" + mobileNo  + "]";
	}*/
}