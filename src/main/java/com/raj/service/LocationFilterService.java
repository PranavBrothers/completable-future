package com.raj.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LocationFilterService implements FilterService{
	
	public Map<String, Set<Long>> getFilters(List<ProfileBean> profiles){
		Map locationFiltersMap = new HashMap<String, Set<Long>>();
		for(ProfileBean profileBean: profiles) {
			List<Long> profileKeys = new ArrayList<Long>();
			profileKeys.add(profileBean.getProfileKey());
			locationFiltersMap.put(profileBean.getLocation(),profileKeys);
		}
		try {
			Thread.sleep(5000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Location Filter Error");
		}
		System.out.println("Location Filter Ready");
		return locationFiltersMap;
	}
	
}
