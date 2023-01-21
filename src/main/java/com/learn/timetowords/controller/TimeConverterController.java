package com.learn.timetowords.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.timetowords.payload.TimeRequest;
import com.learn.timetowords.payload.TimeResponse;
import com.learn.timetowords.service.TimeConverterService;

@RestController
@RequestMapping("/api/time")
public class TimeConverterController {
	@Autowired
	private TimeConverterService timeConverterService;
	
	@PostMapping("/")
	public TimeResponse getTimeConverts(@RequestBody TimeRequest timeRequest)
	{
		return timeConverterService.timeConverter(timeRequest);
	}
}
