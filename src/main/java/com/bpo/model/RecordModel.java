package com.bpo.model;

/*
 * Plain Old Java Object for Call Records Table in Database.
 */


public class RecordModel {

	int id;
	String from_number;
	String start_time;
	String end_time;
	int duration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom_number() {
		return from_number;
	}
	public void setFrom_number(String from_number) {
		this.from_number = from_number;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}
