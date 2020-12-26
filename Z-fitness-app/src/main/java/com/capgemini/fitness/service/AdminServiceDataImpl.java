package com.capgemini.fitness.service;




import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.fitness.dao.AdminDataDao;
import com.capgemini.fitness.entity.Admin;
import com.capgemini.fitness.exception.AdminException;


@Service
@Transactional
public class AdminServiceDataImpl implements AdminService{
	@Autowired
	private AdminDataDao adminDataDaoImpl;
	
	@Override
	public Integer addAdmin(Admin admin) throws AdminException {
			try {
				Admin p= 
						adminDataDaoImpl.save(admin);
				System.out.println(p);
				//return p.getAdmin_id();
				return 1;
			}catch(DataAccessException e) {
				throw new AdminException(e.getMessage(),e);
			}catch(Exception e) {
				throw new AdminException(e.getMessage(),e);
			}
	}

	@Override
	public Admin getAdminById(Integer adminId) throws AdminException {
		try {
			Optional<Admin> optional= 
					adminDataDaoImpl.findById(adminId);
			if(optional.isPresent()) {
				System.out.println(optional.get());
				return optional.get();
			}else {
				return null;
			}			
		}catch(DataAccessException e) {
			throw new AdminException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AdminException(e.getMessage(),e);
		}
	}
	
	
	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		try {
			Admin p= 
					adminDataDaoImpl.save(admin);
			return p;
		}catch(DataAccessException e) {
			throw new AdminException(e.getMessage(),e);
		}catch(Exception e) {
			throw new AdminException(e.getMessage(),e);
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

