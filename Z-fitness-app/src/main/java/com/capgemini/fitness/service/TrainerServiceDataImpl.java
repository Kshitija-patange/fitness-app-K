package com.capgemini.fitness.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fitness.dao.TrainerDataDao;
import com.capgemini.fitness.entity.Admin;
import com.capgemini.fitness.entity.Trainer;
import com.capgemini.fitness.exception.AdminException;
import com.capgemini.fitness.exception.AppointmentException;
import com.capgemini.fitness.exception.TrainerException;


@Service
@Transactional
public class TrainerServiceDataImpl implements TrainerService{
	@Autowired
	private TrainerDataDao trainerDataDaoImpl;
	
	@Override
	public Integer addTrainer(Trainer trainer) throws TrainerException {
			try {
				Trainer p= 
						trainerDataDaoImpl.save(trainer);
				System.out.println(p);
				//return p.getTrainerId();
				return 1;
			}catch(DataAccessException e) {
				throw new TrainerException(e.getMessage(),e);
			}catch(Exception e) {
				throw new TrainerException(e.getMessage(),e);
			}
	}

	@Override
	public Trainer getTrainerById(Integer trainerId) throws TrainerException {
		try {
			Optional<Trainer> optional= 
					trainerDataDaoImpl.findById(trainerId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException e) {
			throw new TrainerException(e.getMessage(),e);
		}catch(Exception e) {
			throw new TrainerException(e.getMessage(),e);
		}
	}
	@Override
	public Integer deleteTrainer(Integer trainerId) throws TrainerException {
		try {
			trainerDataDaoImpl.deleteById(trainerId);
			//return appointmentId;
			return 1;
		}catch(DataAccessException e) {
			throw new TrainerException(e.getMessage(),e);
		}catch(Exception e) {
			throw new TrainerException(e.getMessage(),e);
		}
	}
	
	
	@Override
	public Trainer updateTrainer(Trainer trainer) throws TrainerException {
		try {
			Trainer p= 
					trainerDataDaoImpl.save(trainer);
			return p;
		}catch(DataAccessException e) {
			throw new TrainerException(e.getMessage(),e);
		}catch(Exception e) {
			throw new TrainerException(e.getMessage(),e);
		}
	}
/*
	@Override
	public Integer deleteAppointment(Integer appointmentId) throws AppointmentException {
		try {
			appointmentDataDaoImpl.deleteById(appointmentId);
			return appointmentId;
		}catch(DataAccessException e) {
			throw new AppointmentException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AppointmentException(e.getMessage(),e);
		}
	}

	@Override
	public List<Appointment> viewAppointment() throws AppointmentException {
		try {
			List<Appointment> appointmentList=
					appointmentDataDaoImpl.findAll();
			return appointmentList;
		}catch(DataAccessException e) {
			throw new AppointmentException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AppointmentException(e.getMessage(),e);
		}
	}

	/*
	 * @Override public Appointment updateAppointment(Appointment appointment)
	 * throws AppointmentException { try { Appointment p=
	 * appointmentDataDaoImpl.save(appointment); return p;
	 * }catch(DataAccessException e) { throw new
	 * AppointmentException(e.getMessage(),e); }catch(Exception e) { throw new
	 * AppointmentException(e.getMessage(),e); } }
	 */

	

}

