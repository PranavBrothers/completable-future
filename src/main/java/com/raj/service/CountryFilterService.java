package com.raj.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountryFilterService implements FilterService{
	
	public Map<String, Set<Long>> getFilters(List<ProfileBean> profiles){
		Map countryFiltersMap = new HashMap<String, Set<Long>>();
		for(ProfileBean profileBean: profiles) {
			List<Long> profileKeys = new ArrayList<Long>();
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
