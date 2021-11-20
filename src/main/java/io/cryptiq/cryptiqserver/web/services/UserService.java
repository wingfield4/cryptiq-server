package io.cryptiq.cryptiqserver.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.cryptiq.cryptiqserver.db.models.User;
import io.cryptiq.cryptiqserver.db.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User createUser(User user)
	{
		return userRepository.save(user);
	}
	
	public boolean setDeviceToken(int userId, String token)
	{
		var user = userRepository.findById(userId).orElse(null);
		
		if(user == null)
			return false;
		
		user.setDeviceToken(token);
		userRepository.save(user);
		return true;
	}
	
	public List<User> searchForUsers(String username)
	{
		final int MAX_USERS = 100;
		var limit = PageRequest.of(0, MAX_USERS);
		
		if(username != null)
		{
			return userRepository.findByUsernameContaining(username);
		}
		
		return userRepository.findAll(limit).toList();
	}
	
	public User getUserById(int userId)
	{
		return userRepository.findById(userId).orElse(null);
	}
}
