package com.bpo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpo.service.Service;
import com.bpo.model.RecordModel;

@RestController
public class Controller {
	
	@Autowired
	Service callservice;
	
	/*
	 * Rest APIs to generate the following functions
	 */
	
	/*
	 * To generate all the Call Records from the database
	 */
	
	@RequestMapping(value="/getCallDetails", method=RequestMethod.GET)
	public List<RecordModel> getCallDetails(){
		
		return callservice.getCallDetails();
		
	}
	
	/*
	 * To generate the time of the day when the call volume is highest
	 */
	
	@RequestMapping(value="/getHighestCallVolumeByHour", method=RequestMethod.GET)
	public String highestCallVolumeByHour() {
		
		return callservice.highestCallVolumeByHour();
	}
	
	/*
	 * To generate the time of the day when the duration of the calls were highest
	 */
	
	@RequestMapping(value="/getLongestCallVolumeByHour", method=RequestMethod.GET)
	public String longestCallVolumeByHour() {
		
		return callservice.longestCallVolumeByHour();
	}
	
	/*
	 * Weekly Basis
	 */
	
	@RequestMapping(value="/getHighestCallVolumeByDay", method=RequestMethod.GET)
	public String highestCallVolumeByDay() {
		
		return callservice.highestCallVolumeByDay();
	}
	
	@RequestMapping(value="/getLongestCallVolumeByDay", method=RequestMethod.GET)
	public String longestCallVolumeByDay() {
		
		return callservice.longestCallVolumeByDay();
	}

}
