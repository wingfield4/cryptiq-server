package io.cryptiq.cryptiqserver.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cryptiq.cryptiqserver.db.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public List<User> findByUsernameContaining(String username);
}
