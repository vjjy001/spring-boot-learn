package com.james.springboot.restspringboot.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.james.springboot.restspringboot.model.State;



@Repository
public class StateDao implements IStateDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<State> getAllStates(){
		
		List<State> list = new ArrayList<State>();
		String sql ="select * from state";
		try {
			PreparedStatement pst= jdbcTemplate.getDataSource().getConnection().prepareStatement(sql);
			ResultSet rs =pst.executeQuery();
			while(rs.next()){
				State state = new State();
				state.setStateCode(rs.getString("statecode"));
				state.setStateNum(rs.getString("statenum"));
				list.add(state);
			}
			
			rs.close();
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	
	public List<State> getAllStatesByTemplate(){
		
		String sql ="select statecode,statenum from state";
		List<State> list = jdbcTemplate.query(sql,(ResultSet rs, int num)->{
				State state = new State();
				state.setStateCode(rs.getString("statecode"));
				state.setStateNum(rs.getString("statenum"));
				return state;
		});
		
		return list;
	}
	
	
	public List<State> getStatesByRegion(int blsnum){
		String sql = "select statecode,statenum from state where blsregion=?";
		List<State> list = jdbcTemplate.query(sql, new Object[]{blsnum},(rs,i)->{
			State st = new State(); 
			st.setStateCode(rs.getString("statecode"));
			st.setStateNum(rs.getString("statenum"));
			return st;
		});
		
		return list;
	}
}
