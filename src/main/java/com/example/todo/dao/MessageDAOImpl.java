package com.example.todo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.todo.models.Message;

@Repository("MessageDAO")
public class MessageDAOImpl implements MessageDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void persistMessage(Message message) {
		Session session =  sessionFactory.openSession();
		session.persist(message);
		session.close();
	}
	

	@Override
	@Transactional
	public Message findMessageById(String id) {
		Session session =  sessionFactory.openSession();
		Message message = (Message) session.get(Message.class, id);
		session.close();
		return message;
	}

	@Override
	@Transactional
	public void updateMessage(Message message) {
		Session session =  sessionFactory.openSession();
		session.save(message);
		session.close();
	}

	@Override
	@Transactional
	public void deleteMessage(Message message) {
		Session session =  sessionFactory.openSession();
		session.delete(message);
		session.close();
	}
	
	/*@SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<Message> listMessages() {
		Session session = sessionFactory.openSession();
        List<Message> messageList = session.createQuery("from MESSAGE").list();
        session.close();
        return messageList;
	}*/

}
