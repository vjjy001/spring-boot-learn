package com.james.springboot.restspringboot.dao;

import java.util.List;

import com.james.springboot.restspringboot.model.State;

public interface IStateDao {
	
	public List<State> getAllStates();
	
	public List<State> getAllStatesByTemplate();
	
	public List<State> getStatesByRegion(int blusnum);
}
