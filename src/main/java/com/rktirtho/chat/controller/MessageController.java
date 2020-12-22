package com.rktirtho.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.rktirtho.chat.model.MessageModel;
import com.rktirtho.chat.userstorage.UserStorage;

@RestController
public class MessageController {
	
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("/chat/{to}")
	public void sendMassage(@DestinationVariable String to, MessageModel message) {
		System.out.println("[  handling send massage  ]"+ message +" to "+to);
		boolean ifExists = UserStorage.getInstance().getUsers().contains(to);
		
		if (ifExists) {
			simpMessagingTemplate.convertAndSend("topic/messages/"+to,message);
		}
		
	}

}
