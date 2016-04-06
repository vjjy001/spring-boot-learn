package com.james.springboot.restspringboot.service.action;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.james.springboot.restspringboot.dao.IStateDao;
import com.james.springboot.restspringboot.model.State;



@RestController
public class JdbcTestController {
	
	@Autowired
	private IStateDao stateDao;
	
	@RequestMapping(value="/api/states",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Collection<State>> getAllStates(){
			List<State> list =stateDao.getAllStates();
		return new ResponseEntity<Collection<State>>(list,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/api/statestemp",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	
	public ResponseEntity<Collection<State>> getAllStatesTemplate(){
			List<State> list =stateDao.getAllStatesByTemplate();
		return new ResponseEntity<Collection<State>>(list,HttpStatus.OK);
	}
	
	/**
	 * request url format:/api/regionid/1
	 * @param blsnum
	 * @return
	 */
	@RequestMapping(value="/api/regionid/{id}",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<State>> getAllStatesByRegion(@PathVariable("id") int blsnum){
			List<State> list =stateDao.getStatesByRegion(blsnum);
		return new ResponseEntity<Collection<State>>(list,HttpStatus.OK);
	}
	/**
	 * request url format: /api/regionid?blsnum=1
	 * @param blsnum
	 * @return
	 */
	@RequestMapping(value="/api/regionid",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<State>> getAllStatesByRegionID(@RequestParam(value="blsnum",defaultValue="1") int blsnum){
			List<State> list =stateDao.getStatesByRegion(blsnum);
		return new ResponseEntity<Collection<State>>(list,HttpStatus.OK);
	}
}
