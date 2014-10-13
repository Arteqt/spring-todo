package com.example.todo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.todo.models.Message;
import com.example.todo.service.MessageService;

@Controller
@RequestMapping(value = "/inbox")
public class MessageController {
	@Autowired
	private MessageService messageService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("message", new Message());
		return "inboxPage";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(Message messageBean, Model model) {
		messageService.persistMessage(messageBean);
		model.addAttribute("message", "Message created");
		return "inboxPage";
	}

	@ModelAttribute("messageBean")
	public Message createFormBean() {
		return new Message();
	}

	/*@ModelAttribute("messages")
	public List<Message> getMessages() {
		return messageService.listMessages();
	}*/

	@ModelAttribute("messagebyid")
	public Message getMessageById(String id) {
		return messageService.findMessageById(id);
	}
}
