package com.capgemini.fitness.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.fitness.entity.User;
import com.capgemini.fitness.exception.UserException;
import com.capgemini.fitness.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/fitness/user")
//@Slf4j
@Api
@CrossOrigin(origins="*")
public class UserNewController {

	
	@Autowired
	private UserService userService;

	/*
	 * http://localhost:8081/fitness/user/ add user
	 */
	@ApiOperation(value = "Add user",
			consumes = "receives user object as Request body",
			response = String.class,
			httpMethod = "POST"
			)
	@PostMapping("/")
	public String addUser(@RequestBody User user) {
		try {
			Integer status = userService.addUser(user);
			if (status == 1) {
				//log.info("user:" + user.getFname() + user.getLname() + " added to database");
				return "user:" + user.getFname() + user.getLname() + " added to database";
			} else {
				//log.debug("Unable to add user");
				return "Unable to add user to database";
			}

		} catch (UserException e) {
			//log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/*
	 * //get user by Id //http://localhost:8081/fitness/user/1
	 */
	@ApiOperation(value = "Get user by Id",
			response = User.class,
			tags = "get-user",
			consumes = "userId",
			httpMethod = "GET")
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id) {
		try {
			User user = userService.getUserById(id);
			//log.info("User added" + user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (UserException e) {
			//log.error(e.getMessage());
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	// http://localhost:8081/fitness/appointment/1 delete appointment
	@ApiOperation(value = "Delete user",
			consumes = "user id",
			response = String.class,
			httpMethod = "DELETE")
	  @DeleteMapping("/{id}") 
	  public String deleteUser(@PathVariable Integer id) {
		  try { 
			  Integer status= userService.deleteUser(id);
			  if(status ==1) {
				  //log.info("User: "+id+" deleted from database"); 
				  return "User: "+id+" deleted from database";
			  }else {
				 // log.debug("Unable to delete User from database"); 
				  return"Unable to delete User from database";
			  }
		  }catch(UserException e) { 
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
		  } 
	  }
	  
	  
	  
	  /*http://localhost:8081/fitness/user/ update product
		*/  
		@ApiOperation(value = "Update user",
			consumes = "user object sent as request body",
			response = User.class,
			httpMethod = "PUT")
		  @PutMapping("/") 
		  public ResponseEntity<User> updateUser(@RequestBody User user) { 
		  try { 
			  User updatedUser= userService.updateUser(user);
			  //log.info("User: "+ user.getUserId()+ " updated");
			  return new ResponseEntity<>(updatedUser,HttpStatus.OK);
		  
		  }catch(UserException e) { 
			 // log.error(e.getMessage()); 
			  throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			  } 
		  }

	 
	/*
	  /* http://localhost:8081/fitness/user/1 delete user
	  
	  @DeleteMapping("/{id}")
	  public String deleteUser(@PathVariable Integer id) {
	  try { 
		  Integer status= userService.deleteUser(id); 
		  if(status ==1) {
			  log.info("user: "+id+" deleted from database"); 
			  return"user: "+id+" deleted from database";
		  }else {
			  log.debug("Unable to delete user from database");
			  return "Unable to delete user from database";
		  }
	  }catch(UserException e) { 
		  throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); 
     	} 
	  }*/
	  
	  /*
	  get all user http://localhost:8081/fitness/user/
	  
	  @GetMapping("/") public ResponseEntity<List<User>> viewUser(){ try {
	  List<User> userList = userService.viewUser();
	  log.info("Returning all Users details"); return new
	  ResponseEntity<>(userList,HttpStatus.OK); }catch(UserException e) {
	  log.error(e.getMessage()); throw new
	  ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }
	  
	  *//*
	  http://localhost:8081/fitness/user/ update product
	  
	  @PutMapping("/") public ResponseEntity<User> updateUser(@RequestBody User
	  user) { try { User updatedUser= userService.updateUser(user);
	  log.info("User: "+ user.getUserId()+ " updated"); return new
	  ResponseEntity<>(updatedUser,HttpStatus.OK);
	  
	  }catch(UserException e) { log.error(e.getMessage()); throw new
	  ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage()); } }
	  */
	 
}
