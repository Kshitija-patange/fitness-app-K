package com.capgemini.fitness.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author 
 * This is Appointment POJO Class
 */
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name = "appointment_id")
	private Integer appointment_id;
	@NotNull
	@Column(name = "user_id")
	private Integer user_id;
	@NotNull
	@Column(name = "trainer_id")
	private Integer trainer_id;
	
	@Column(name = "trainer_preference")
	private String trainer_Preference;
	@Column(name = "phy_theropist")
	private String phy_the;
	@NotNull
	@Column(name = "amount")
	private Integer amount;
	@Column(name = "location")
	private String location;
	@NotNull
	@Column(name = "date")
	private LocalDate date;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_appointment_id")
	private User user;
	
	
/*
	public Appointment()
	{

	}
	
	
	public Appointment(Integer appointment_id, Integer user_id,Integer trainer_id, String trainer_Preference, String phy_the,
			Integer amount, String location, LocalDate date) {
		super();
		this.appointment_id = appointment_id;
		this.user_id = user_id;
		this.trainer_id = trainer_id;
		Trainer_Preference = trainer_Preference;
		this.phy_the = phy_the;
		this.amount = amount;
		this.location = location;
		this.date = date;
	}

	public Integer getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(Integer appointment_id) {
		this.appointment_id = appointment_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(Integer trainer_id) {
		this.trainer_id = trainer_id;
	}

	public String getTrainer_Preference() {
		return Trainer_Preference;
	}

	public void setTrainer_Preference(String trainer_Preference) {
		Trainer_Preference = trainer_Preference;
	}

	public String getPhy_the() {
		return phy_the;
	}

	public void setPhy_the(String phy_the) {
		this.phy_the = phy_the;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Appointment [appointment_id=" + appointment_id +
				", Trainer_Preference=" + Trainer_Preference + ", phy_the=" + phy_the + ", amount=" + amount
				+ ", location=" + location + ", date=" + date +"]";
	}
*/

	
}