package com.example.todo.service;

import java.util.List;

import com.example.todo.models.Message;

public interface MessageService {
	void persistMessage(Message message);
	Message findMessageById(String id);
	void updateMessage(Message message);
	void deleteMessage(Message message);
	public List<Message> listMessages();
}
