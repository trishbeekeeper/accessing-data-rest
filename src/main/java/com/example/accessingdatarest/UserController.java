package com.example.accessingdatarest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") //http:localhost:8085/users
public class UserController {
	@Autowired
	UserService userService;
	//to make it respond to get request:
	@GetMapping
	public String getUser() {
		return "get user was called!";
	}
	
	//to make the method respond to post request:
	@PostMapping
	public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		UserDetailsResponseModel returnValue = new UserDetailsResponseModel();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		//String firstName = userDto.getFirstName();
		//System.out.println("userDto.firstName is " + firstName);
		
		UserDto createdUser = userService.createUser(userDto);
		//String firstName2 = createdUser.getFirstName();
		//System.out.println("createdUser.firstName is " + firstName);
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
		
	}
	
	//to bind this method to put:
	@PutMapping
	public String updateUser() {
		return "update user was called!";
	}
	
	//to bind method to delete http method:
	@DeleteMapping
	public String deleteUser() {
		return "delete user was called";
	}
}
