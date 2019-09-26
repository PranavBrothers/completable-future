package com.raj.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface FilterService {
	public Map<String, Set<Long>> getFilters(List<ProfileBean> profiles);
}
