package com.capgemini.fitness.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.fitness.entity.Appointment;

//Spring Data JPA

@Repository
public interface AppointmentDataDao 
				extends JpaRepository<Appointment,Integer>{
	
	
	
}
