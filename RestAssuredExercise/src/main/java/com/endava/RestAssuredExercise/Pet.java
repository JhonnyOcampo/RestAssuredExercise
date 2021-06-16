package com.endava.RestAssuredExercise;

import java.util.List;

public class Pet {
	
	private String id;
	private String name;
	private List<String> photoUrls;
		
	public Pet() {
	}
	
	public Pet(String name, List<String> photoUrls) {
		this.name = name;
		this.photoUrls = photoUrls;
	}
		
	
	public Pet(String id, String name, List<String> photoUrls) {
		this.id = id;
		this.name = name;
		this.photoUrls = photoUrls;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}
	

}
