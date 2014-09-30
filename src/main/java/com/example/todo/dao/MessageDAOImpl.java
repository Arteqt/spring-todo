package com.example.todo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.todo.models.Message;

@Repository("MessageDAO")
public class MessageDAOImpl implements MessageDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void persistMessage(Message message) {
		sessionFactory.getCurrentSession().persist(message);
		
	}

	@Override
	public Message findMessageById(String id) {
		return (Message) sessionFactory.getCurrentSession().get(Message.class, id);
	}

	@Override
	public void updateMessage(Message message) {
		sessionFactory.getCurrentSession().update(message);
		
	}

	@Override
	public void deleteMessage(Message message) {
		sessionFactory.getCurrentSession().delete(message);
		
	}
	
	@SuppressWarnings("unchecked")
    @Override
    public List<Message> listMessages() {
        List<Message> messageList = sessionFactory.getCurrentSession().createQuery("from MESSAGE").list();
        return messageList;
	}

}
