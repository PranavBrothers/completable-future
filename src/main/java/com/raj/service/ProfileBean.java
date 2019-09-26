package com.raj.service;

public class ProfileBean {

	private Long profileKey;
	private String name;
	private String location;
	private String country;
	
	public Long getProfileKey() {
		return profileKey;
	}
	public String getName() {
		return name;
	}
	public void setProfileKey(Long profileKey) {
		this.profileKey = profileKey;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public String getCountry() {
		return country;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public ProfileBean(Long profileKey, String name, String location, String country) {
		super();
		this.profileKey = profileKey;
		this.name = name;
		this.location = location;
		this.country = country;
	}
	@Override
	public String toString() {
		return "ProfileBean [profileKey=" + profileKey + ", name=" + name + ", location=" + location + ", country="
				+ country + "]";
	}

	
}