package io.cryptiq.cryptiqserver.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.cryptiq.cryptiqserver.db.models.User;
import io.cryptiq.cryptiqserver.web.Routes;
import io.cryptiq.cryptiqserver.web.requests.SearchUsersRequest;
import io.cryptiq.cryptiqserver.web.requests.SetDeviceTokenRequest;
import io.cryptiq.cryptiqserver.web.services.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(Routes.CREATE_USER)
	public User SendMessage(@RequestBody User user)
	{
		return userService.createUser(user);
	}
	
	@PostMapping(Routes.SET_DEVICE_TOKEN)
	public String SetDeviceToken(@RequestBody SetDeviceTokenRequest request)
	{
		userService.setDeviceToken(request.getUserId(), request.getDeviceToken());
		return "Success";
	}
	
	@GetMapping(Routes.SEARCH_USERS)
	public List<User> SearchUsers(SearchUsersRequest request)
	{
		return userService.searchForUsers(request.getUsername());
	}
	
	@GetMapping(Routes.GET_USER)
	public User GetUser(@PathVariable int userId)
	{
		return userService.getUserById(userId);
	}
}
