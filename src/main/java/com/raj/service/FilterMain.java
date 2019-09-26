package com.raj.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FilterMain {
	
		public static void main(String[] args) throws ExecutionException, InterruptedException {
			FilterMain fm = new FilterMain();
			List<ProfileBean> profileList = fm.getProfileList();
			fm.prepareFilters(profileList);
	    }
		
		private void prepareFilters(List<ProfileBean> profileList) throws InterruptedException, ExecutionException {
			FilterService locationFilterService = new LocationFilterService();
	    	FilterService countryFilterService = new CountryFilterService();
	    	
	    	CompletableFuture<Map<String, Set<Long>>> locationFilter = CompletableFuture.supplyAsync(() -> {
	            return locationFilterService.getFilters(profileList);
	        });
	    	
	    	CompletableFuture<Map<String, Set<Long>>> countryFilter = CompletableFuture.supplyAsync(() -> {
	            return countryFilterService.getFilters(profileList);
	        });
	    	
	    	CompletableFuture.allOf(locationFilter, countryFilter).isDone();
	    	
	    	Map<String, Object> filtersMap = new HashMap<String, Object>();
	    	Map<String, Set<Long>> locationFilterMap = locationFilter.get();
	    	Map<String, Set<Long>> countryFilterMap = countryFilter.get();
	    	filtersMap.put("Location", locationFilterMap);
	    	filtersMap.put("Country", countryFilterMap);
	    	
	    	System.out.println(filtersMap);
		}

		private List<ProfileBean> getProfileList() {
			List<ProfileBean> profileList  = new ArrayList<>();
	    	profileList.add(new ProfileBean(1l, "Rajkumar","Chennai","INDIA"));
	    	profileList.add(new ProfileBean(2l, "Gautham","Delhi","INDIA"));
	    	profileList.add(new ProfileBean(3l, "Trump","New York","USA"));
	    	profileList.add(new ProfileBean(4l, "Russel","Colombo","SriLanka"));
	    	profileList.add(new ProfileBean(5l, "Ambani","Mumbai","INDIA"));
	    	profileList.add(new ProfileBean(6l, "Roshan","Bangalore","INDIA"));
	    	profileList.add(new ProfileBean(7l, "Putin","Moscow","Russia"));
	    	profileList.add(new ProfileBean(8l, "Sai","Dubai","UAE"));
	    	profileList.add(new ProfileBean(9l, "Koirala","Kathmandu","Nepal"));
	    	profileList.add(new ProfileBean(10l, "DuPlesis","CapeTown","South Africa"));
	    	
	    	profileList.add(new ProfileBean(11l, "Rajkumar","Chennai","INDIA"));
	    	profileList.add(new ProfileBean(21l, "Gautham","Delhi","INDIA"));
	    	profileList.add(new ProfileBean(31l, "Trump","New York","USA"));
	    	profileList.add(new ProfileBean(41l, "Russel","Colombo","SriLanka"));
	    	profileList.add(new ProfileBean(51l, "Ambani","Mumbai","INDIA"));
	    	profileList.add(new ProfileBean(61l, "Roshan","Bangalore","INDIA"));
	    	profileList.add(new ProfileBean(71l, "Putin","Moscow","Russia"));
	    	profileList.add(new ProfileBean(81l, "Sai","Dubai","UAE"));
	    	profileList.add(new ProfileBean(91l, "Koirala","Kathmandu","Nepal"));
	    	profileList.add(new ProfileBean(101l, "DuPlesis","CapeTown","South Africa"));
	    	return profileList;
		}
	   
}
