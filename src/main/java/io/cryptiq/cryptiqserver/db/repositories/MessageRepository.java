package io.cryptiq.cryptiqserver.db.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.cryptiq.cryptiqserver.db.models.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {
	List<Message> findBySentToAndSentAtGreaterThan(int sentTo, Date sentAt);
}
