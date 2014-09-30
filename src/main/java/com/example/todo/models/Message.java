package com.example.todo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGE")
public class Message {
	
	@Id
	@Column(name = "ID", nullable = false)
	private String id;
	@Column(name = "SENDER", nullable = false)
	private String sender;
	@Column(name = "RECEIVER", nullable = false)
	private String receiver;
	@Column(name = "CONTENT", nullable = false)
	private String content;
	public Message(){}
	public Message(String id, String sender, String receiver, String content)
	{
		this.id = id;
		this.sender = sender;
		this.receiver = receiver;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
}
