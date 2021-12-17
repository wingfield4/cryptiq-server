package io.cryptiq.cryptiqserver.web.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Notification;

import io.cryptiq.cryptiqserver.db.models.Message;
import io.cryptiq.cryptiqserver.db.repositories.MessageRepository;
import io.cryptiq.cryptiqserver.db.repositories.UserRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;
	@Autowired
	private UserRepository userRepository;
	
	public Message createMessage(Message message)
	{
		return messageRepository.save(message);
	}

	public Date sendMessage(Message message) throws FirebaseMessagingException
	{
		//update sentAt, since we're sending now :)
		message.setSentAt(new Date());
		messageRepository.save(message);
		
		//grab the user we're sending to (for their device token)
		var user = userRepository
				.findById(message.getSentTo())
				.orElse(null);
		
		var sentFromUser = userRepository
				.findById(message.getSentFrom())
				.orElse(null);
		
		if(user == null)
		{
			//TODO uh oh handle this error
		}
		
		var firebaseMessage = com.google.firebase.messaging.Message.builder()
				.setNotification(Notification.builder()
						.setTitle("Cryptiq Message")
						.setBody("New message from " + sentFromUser.getFormattedName())
						.build())
				//message data
			    .putData("id", message.getId().toString())
			    .putData("encryptedContent", message.getEncryptedContent())
			    .putData("sentTo", message.getSentTo().toString())
			    .putData("sentAt", message.getSentAt().toString())
			    .putData("sentFrom", message.getSentFrom().toString())
			    .setToken(user.getDeviceToken())
			    .build();
		
		FirebaseMessaging.getInstance().send(firebaseMessage);
		return new Date();
	}
	
	public List<Message> getNewMessages(int userId, Date lastReceived)
	{
		return messageRepository.findBySentToAndSentAtGreaterThan(userId, lastReceived);
	}
	
	public boolean validateUserId(int id)
	{
		var user = userRepository.findById(id).orElse(null);
		return user != null;
	}
	
	@PostConstruct
    public void initialize() {
        try {
            FirebaseOptions options = FirebaseOptions.builder()
            	    .setCredentials(GoogleCredentials.getApplicationDefault())
            		.build();
            
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
