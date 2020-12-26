package com.capgemini.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.fitness.entity.Admin;
import com.capgemini.fitness.exception.AdminException;
import com.capgemini.fitness.service.AdminService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fitness/admin")
//@Slf4j
public class AdminNewController {
	
	@Autowired
	private AdminService adminService;

	/*
	 * http://localhost:8081/fitness/admin/ add admin
	 */
	@ApiOperation(value = "Add admin",
			consumes = "receives admin object as Request body",
			response = String.class,
			httpMethod = "POST"
			)
	@PostMapping("/")
	public String addAdmin(@RequestBody Admin admin) {
		try {
			Integer status = adminService.addAdmin(admin);
			if (status == 1) {
				//log.info("admin:" + admin.getAdmin_name() + " added to database");
				return "admin:" + admin.getAdmin_name() + " added to database";
			} else {
				//log.debug("Unable to add admin");
				return "Unable to add admin to database";
			}

		} catch (AdminException e) {
			//log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/*
	 * //get user by Id //http://localhost:8081/fitness/admin/1
	 */
	@ApiOperation(value = "Get admin by Id",
			response = Admin.class,
			tags = "get-admin",
			consumes = "admin_id",
			httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable Integer id) {
		try {
			Admin admin = adminService.getAdminById(id);
			//log.info("Admin added" + admin);
			return new ResponseEntity<>(admin, HttpStatus.OK);
		} catch (AdminException e) {
			//log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	 /*http://localhost:8081/fitness/user/ update product
		*/  
	  @ApiOperation(value = "Update admini",
				consumes = "admin object sent as request body",
				response = Admin.class,
				httpMethod = "PUT")
		  @PutMapping("/") public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) { 
		  try { 
			  Admin updatedAdmin= adminService.updateAdmin(admin);
			  //log.info("Admin: "+ admin.getAdmin_id()+ " updated");
			  return new ResponseEntity<>(updatedAdmin,HttpStatus.OK);
		  
		  }catch(AdminException e) { 
			 // log.error(e.getMessage()); 
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			  } 
		  }
		  
	
	  /* http://localhost:8081/fitness/user/1 delete user
	  
	  @DeleteMapping("/{id}") public String deleteUser(@PathVariable Integer id) {
	  try { Integer status= userService.deleteUser(id); if(status ==1) {
	  log.info("user: "+id+" deleted from database"); return
	  "user: "+id+" deleted from database"; }else {
	  log.debug("Unable to delete user from database"); return
	  "Unable to delete user from database"; }
	  
	  }catch(UserException e) { throw new
	  ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }
	  
	  
	  get all user http://localhost:8081/fitness/user/
	  
	  @GetMapping("/") public ResponseEntity<List<User>> viewUser(){ try {
	  List<User> userList = userService.viewUser();
	  log.info("Returning all Users details"); return new
	  ResponseEntity<>(userList,HttpStatus.OK); }catch(UserException e) {
	  log.error(e.getMessage()); throw new
	  ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }
	  
	  
	  http://localhost:8081/fitness/user/ update product
	  
	  @PutMapping("/") public ResponseEntity<User> updateUser(@RequestBody User
	  user) { try { User updatedUser= userService.updateUser(user);
	  log.info("User: "+ user.getUserId()+ " updated"); return new
	  ResponseEntity<>(updatedUser,HttpStatus.OK);
	  
	  }catch(UserException e) { log.error(e.getMessage()); throw new
	  ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }
	  */
	 
}
