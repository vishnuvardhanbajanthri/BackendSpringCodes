package com.capg.sm.springboot.capgtopics;

import java.util.List;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CapgTopicsController {

	//CapgTopicsService topicService=new CapgTopicsService();
	
	@Autowired
	CapgTopicsService topicService;
	
	@RequestMapping("/myController")
	public String display()
	{
		return "My Controller";
	}
	
	@RequestMapping("/capgtopics")
	public List<CapgTopics> getAllTopics()
	{
		return topicService.getAllMyTopics();
	}
}
