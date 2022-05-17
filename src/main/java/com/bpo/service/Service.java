package com.bpo.service;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bpo.dao.Dao;
import com.bpo.model.RecordModel;

@Component
public class Service {

	private static String higestVolume = null;
	private static String longestVolume = null;
	private static String busiestDaybyVolume = null;
	private static String busiestDaybyLength = null;
	@Autowired
	Dao calldao;
	public List<RecordModel> getCallDetails() {
		
		return calldao.getCalldetails();
	}
	public String highestCallVolumeByHour() {
		
		List <RecordModel> callList=calldao.getCalldetails();
		int max=0;
		int count=0;
		String day;
		String time;
		String temp_day;
		String temp_time;
		String busy_time = null;
		for(RecordModel call:callList)
		{	
			day=call.getStart_time().substring(0,10);
			time=call.getStart_time().substring(11);
			
//			System.out.println(day);
//			System.out.println(time);
			for(RecordModel caller:callList)
			{
				temp_day=caller.getStart_time().substring(0,10);
				temp_time=caller.getStart_time().substring(11);
				
				if(temp_day.equals(day)) {
					System.out.println(time.substring(0,2));
					if(time.substring(0,2).equals(temp_time.substring(0,2)))
						count++;
					
				}
			}
			
			if(count>max) {
				max=count;
				busy_time=time;
			}
			count=0;

			
		}
		int hour=Integer.parseInt(busy_time.substring(0, 2));
		System.out.println(hour);
		int nexthour=hour+1;
		System.out.println(nexthour);
		higestVolume="Hour of the day when the call volume is highest is "+hour+" to "+nexthour;
			
				
			
		return higestVolume;
	}
	
public String longestCallVolumeByHour() {
		
		List <RecordModel> callList=calldao.getCalldetails();
		int max=0;
		String day;
		String time;
		String temp_day;
		String temp_time;
		String busy_time = null;
		int duration=0;
		int durationOfCallsInSingleHour=0;
		for(RecordModel call:callList)
		{	
			day=call.getStart_time().substring(0,10);
			time=call.getStart_time().substring(11);
			System.out.println(time);
//			System.out.println(day);
//			System.out.println(time);
			for(RecordModel caller:callList)
			{
				temp_day=caller.getStart_time().substring(0,10);
				temp_time=caller.getStart_time().substring(11);
				duration=caller.getDuration();
				
				if(temp_day.equals(day)) {
					//System.out.println(time.substring(0,2));
					if(time.substring(0,2).equals(temp_time.substring(0,2)))
						durationOfCallsInSingleHour=durationOfCallsInSingleHour+duration;
					System.out.println(durationOfCallsInSingleHour);
					
				}
			}
			
			System.out.println("Last max before checking with max duration: "+max);
			if(durationOfCallsInSingleHour>max) {
					max=durationOfCallsInSingleHour;
					System.out.println(max);
					busy_time=time;
				}
			
			
			durationOfCallsInSingleHour=0;
			System.out.println("Last max before exiting for loop: "+max);

				
		}
		System.out.println(max);
		
		int hour=Integer.parseInt(busy_time.substring(0, 2));
		System.out.println(hour);
		int nexthour=hour+1;
		System.out.println(nexthour);
		longestVolume="Hour of the day when the call length is highest is "+hour+" to "+nexthour;
		
		
			
		
		return longestVolume;
	}
	
	public String highestCallVolumeByDay() {
		
		List <RecordModel> callList=calldao.getCalldetails();
		int max=0;
		int count=0;
		int year=0;
		int month=0;
		int dayno=0;
		int week=0;
		int tempweek=0;
		int busy_week=0;
		String day;
		//String time;
		String temp_day;
		//String temp_time;
		String busy_day = null;
		for(RecordModel call:callList)
		{	
			day=call.getStart_time().substring(0,10);
			//time=call.getStart_time().substring(11);
			
			year= Integer.parseInt(day.substring(0,4));
			dayno=Integer.parseInt(day.substring(8));
			month=Integer.parseInt(day.substring(5,7));
			LocalDate date = LocalDate.of(year, month, dayno);
			week = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
			System.out.println("Date: "+day+" Week Number: "+week);
//			System.out.println(day);
//			System.out.println(time);
			for(RecordModel caller:callList)
			{
				temp_day=caller.getStart_time().substring(0,10);
				//temp_time=caller.getStart_time().substring(11);
				
				LocalDate date_temp = LocalDate.of(Integer.parseInt(temp_day.substring(0,4)), 
						Integer.parseInt(temp_day.substring(5,7)), 
						Integer.parseInt(temp_day.substring(8)));
				tempweek = date_temp.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
				System.out.println("Inside Second For Loop:");
				System.out.println("Date: "+temp_day+" Week Number: "+tempweek);
				
				if(tempweek==week) {
				if(temp_day.equals(day)) {
					//System.out.println(time.substring(0,2));
					//if(time.substring(0,2).equals(temp_time.substring(0,2)))
						count++;
					
				}
			}
			}
			
			if(count>max) {
				max=count;
				busy_day=day;
				busy_week=tempweek;
			}
			count=0;

			
		}
//		int hour=Integer.parseInt(busy_time.substring(0, 2));
//		System.out.println(hour);
//		int nexthour=hour+1;
//		System.out.println(nexthour);
		busiestDaybyVolume="Week number: "+busy_week+" Day when there are most calls: "+busy_day;
			
				
			
		return busiestDaybyVolume;
		
	}
	
		public String longestCallVolumeByDay() {
		
		List <RecordModel> callList=calldao.getCalldetails();
		int max=0;
		String day;
		String time;
		String temp_day;
		String temp_time;
		String busy_time = null;
		String busy_day = null;
		int busy_week = 0;
		int week=0;
		int tempweek=0;
		int duration=0;
		int durationOfCallsInSingleHour=0;
		for(RecordModel call:callList)
		{	
			day=call.getStart_time().substring(0,10);
			time=call.getStart_time().substring(11);
			System.out.println(time);
//			System.out.println(day);
//			System.out.println(time);
			LocalDate date = LocalDate.of(Integer.parseInt(day.substring(0,4)), 
					Integer.parseInt(day.substring(5,7)), 
					Integer.parseInt(day.substring(8)));
			week = date.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
			
			for(RecordModel caller:callList)
			{
				temp_day=caller.getStart_time().substring(0,10);
				temp_time=caller.getStart_time().substring(11);
				duration=caller.getDuration();
				
				LocalDate date_temp = LocalDate.of(Integer.parseInt(day.substring(0,4)), 
						Integer.parseInt(day.substring(5,7)), 
						Integer.parseInt(day.substring(8)));
				
				tempweek = date_temp.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
				
				if(week==tempweek) {
				if(temp_day.equals(day)) {
					//System.out.println(time.substring(0,2));
					if(time.substring(0,2).equals(temp_time.substring(0,2)))
						durationOfCallsInSingleHour=durationOfCallsInSingleHour+duration;
					System.out.println(durationOfCallsInSingleHour);
					
				}
				}
			}
			
			System.out.println("Last max before checking with max duration: "+max);
			if(durationOfCallsInSingleHour>max) {
					max=durationOfCallsInSingleHour;
					System.out.println(max);
					busy_time=time;
					busy_day=day;
					busy_week=tempweek;
				}
			
			
			durationOfCallsInSingleHour=0;
			System.out.println("Last max before exiting for loop: "+max);

				
		}
		System.out.println(max);
		
//		int hour=Integer.parseInt(busy_time.substring(0, 2));
//		System.out.println(hour);
//		int nexthour=hour+1;
//		System.out.println(nexthour);
		busiestDaybyLength="Week number: "+busy_week+" Day when the calls are longest: "+busy_day;
		
		
			
		
		return busiestDaybyLength;
	}
	
	

}
