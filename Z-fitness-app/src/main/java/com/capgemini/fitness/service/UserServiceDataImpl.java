package com.capgemini.fitness.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fitness.dao.UserDataDao;
import com.capgemini.fitness.entity.User;
import com.capgemini.fitness.exception.UserException;


@Service
@Transactional
public class UserServiceDataImpl implements UserService{
	@Autowired
	private UserDataDao userDataDaoImpl;
	
	@Override
	public Integer addUser(User user) throws UserException {
			try {
				User p= 
						userDataDaoImpl.save(user);
				System.out.println(p);
				return 1;
				//return p.getUserId();
			}catch(DataAccessException e) {
				throw new UserException(e.getMessage(),e);
			}catch(Exception e) {
				throw new UserException(e.getMessage(),e);
			}
	}

	@Override
	public User getUserById(Integer userId) throws UserException {
		try {
			Optional<User> optional= 
					userDataDaoImpl.findById(userId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}
	
	
	@Override
	public Integer deleteUser(Integer userId) throws UserException {
		try {
			userDataDaoImpl.deleteById(userId);
			//return appointmentId;
			return 1;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
		}
	}
	
	
	@Override
	public User updateUser(User user) throws UserException {
		try {
			User p= 
					userDataDaoImpl.save(user);
			return p;
		}catch(DataAccessException e) {
			throw new UserException(e.getMessage(),e);
		}catch(Exception e) {
			throw new UserException(e.getMessage(),e);
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

