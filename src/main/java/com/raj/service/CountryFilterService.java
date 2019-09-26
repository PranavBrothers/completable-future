package com.raj.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountryFilterService implements FilterService{
	
	public Map<String, Set<Long>> getFilters(List<ProfileBean> profiles){
		Map<String, Set<Long>> countryFiltersMap = new HashMap<String, Set<Long>>();
		for(ProfileBean profileBean: profiles) {
			Set<Long> profileKeys = countryFiltersMap.get(profileBean.getCountry());
			if(profileKeys==null) {
				profileKeys = new HashSet<Long>();
			}
			profileKeys.add(profileBean.getProfileKey());
			countryFiltersMap.put(profileBean.getCountry(),profileKeys);
		}
		try {
			Thread.sleep(2000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Country Filter Error");
		}
		System.out.println("Country Filter Ready");
		return countryFiltersMap;
	}
	
}
