package com.raj.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class FilterMain {
	
		public static void main(String[] args) throws ExecutionException, InterruptedException {
	    	FilterService locationFilterService = new LocationFilterService();
	    	FilterService countryFilterService = new CountryFilterService();
	    	List<Object> profileList  = new ArrayList<>();
	    	
	    	CompletableFuture<Map<String, String>> future1 = CompletableFuture.supplyAsync(() -> {
	            try {
	                TimeUnit.SECONDS.sleep(10);
	            } catch (InterruptedException e) {
	                throw new IllegalStateException(e);
	            }
	            System.out.println("1");
	            return locationFilterService.getFilters(profileList);
	        });
	    	
	    	CompletableFuture<Map<String, String>> future2 = CompletableFuture.supplyAsync(() -> {
	            try {
	                TimeUnit.SECONDS.sleep(10);
	            } catch (InterruptedException e) {
	                throw new IllegalStateException(e);
	            }
	            System.out.println("1");
	            return countryFilterService.getFilters(profileList);
	        });
	    	CompletableFuture.allOf(future1, future2).isDone();
	    	future1.get();
	    	future2.get();
	    }

	   
}
