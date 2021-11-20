package io.cryptiq.cryptiqserver.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.messaging.FirebaseMessagingException;

import io.cryptiq.cryptiqserver.db.models.Message;
import io.cryptiq.cryptiqserver.web.Routes;
import io.cryptiq.cryptiqserver.web.requests.NewMessagesRequest;
import io.cryptiq.cryptiqserver.web.responses.SendMessageResponse;
import io.cryptiq.cryptiqserver.web.services.MessageService;

@CrossOrigin(origins = "*")
@RestController
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@PostMapping(Routes.SEND_MESSAGE)
	public Message SendMessage(@RequestBody Message message)
	{
		if(!messageService.validateUserId(message.getSentTo()))
		{
			//handle no user error
			return null;
		}

		messageService.createMessage(message);
		try {
			messageService.sendMessage(message);
		} catch (FirebaseMessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return message;
	}
	
	@GetMapping(Routes.GET_NEW_MESSAGES)
	public List<Message> GetNewMessages(NewMessagesRequest request)
	{
		return messageService.getNewMessages(request.getUserId(), request.getLastReceived());
	}
}
