package com.capg.sm.springboot.capgtopics;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CapgTopicsService {
	
	public List topics=Arrays.asList(new CapgTopics("SpringBoot","SpringMVC","Spring"),
			
			new CapgTopics("JPA","Hibernate","Spring"),
			new CapgTopics("UI","React","Facebook")
			);
	
	public List<CapgTopics>getAllMyTopics()
	{
		return topics;
	}
}
	
