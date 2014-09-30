package com.example.todo.dao;

import java.util.List;

import com.example.todo.models.Message;

public interface MessageDAO {
	void persistMessage(Message message);
	Message findMessageById(String id);
	void updateMessage(Message message);
	void deleteMessage(Message message);
	public List<Message> listMessages();
}
