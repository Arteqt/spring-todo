package com.example.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.todo.models.Message;
import com.example.todo.service.MessageService;

@Controller
@RequestMapping(value = "/messages")
public class MessageController {
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("message", new Message());
		return "showMessage";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String create(Message messageBean, Model model){
		messageService.persistMessage(messageBean);
		model.addAttribute("message", "User created");
		return "showMessage";
	}
	
	@ModelAttribute("messageBean")
	public Message createFormBean(){
		return new Message();
	}
	
	@ModelAttribute("messages")
	public List<Message> getMessages(){
		return messageService.listMessages();
	}
	
	@ModelAttribute("messagebyid")
	public Message getMessageById(String id){
		return messageService.findMessageById(id);
	}
}
