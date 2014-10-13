package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.dao.MessageDAO;
import com.example.todo.models.Message;
@Service("messageService")
public class MessageServiceImpl implements MessageService{

	@Autowired
	MessageDAO messageDAO;
	@Override
	@Transactional
	public void persistMessage(Message message) {
		messageDAO.persistMessage(message);
	}

	@Override
	@Transactional
	public Message findMessageById(String id) {
		return messageDAO.findMessageById(id);
	}

	@Override
	@Transactional
	public void updateMessage(Message message) {
		messageDAO.updateMessage(message);
	}

	@Override
	@Transactional
	public void deleteMessage(Message message) {
		messageDAO.deleteMessage(message);
	}
	
	/*@Override
    @Transactional
    public List<Message> listMessages() {
        return messageDAO.listMessages();
    }*/

}
