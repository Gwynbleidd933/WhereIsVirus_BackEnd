package acn.poc.wiv.rest;


import acn.poc.wiv.beans.GetAllUsersResponse;
import acn.poc.wiv.beans.RegisterUserRequest;
import acn.poc.wiv.beans.UserLoginRequest;
import acn.poc.wiv.beans.UserLoginResponse;
import acn.poc.wiv.entity.User;
import acn.poc.wiv.service.UserService;
import acn.poc.wiv.utils.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;
	private Validator validator;
	Logger logger = LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	public UserRestController(UserService userService, Validator validator) {
		this.userService = userService;
		this.validator = validator;
	}


	@GetMapping("/users")
	public GetAllUsersResponse findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> findById(@PathVariable int id) {

		Optional<User> user = userService.findById(id);

		if (user == null) {
			throw new RuntimeException("User id not found - " + id);
		}

		return user;
	}


	@PutMapping("/users")
	public User addUser(@RequestBody User user) {

		// also just in case they pass an id in JSON ... set id to 0
		// this is to force a save of new item ... instead of update

		user.setId(0);

		userService.save(user);

		return user;
	}



	@PostMapping("/users")
	public User updateUser(@RequestBody User user) {

		userService.save(user);

		return user;
	}


	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable int id) {

		Optional<User> tempUser = userService.findById(id);

		// throw exception if null

		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + id);
		}

		userService.deleteById(id);

		return "Deleted user with id: " + id;
	}


	@GetMapping("/hello")
	public String getHelloWorld() {
		logger.info("START getHelloWorld");

		String msg = "Hello from Where is Virus app!";

		logger.info("END getHelloWorld");
		return msg;
	}


	@PostMapping("/user-register")
	public Boolean registerUser(@RequestBody RegisterUserRequest request) throws Exception {

		userService.register(request);

		return Boolean.TRUE;
	}


	@PostMapping("/user-login")
	public UserLoginResponse loginUser(@RequestBody UserLoginRequest request) {

		UserLoginResponse response = userService.login(request);

		return response;
	}

}










