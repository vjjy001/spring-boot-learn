package com.james.springboot.restspringboot.service.action;


import java.util.Collection;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.james.springboot.restspringboot.dao.IStateDao;
import com.james.springboot.restspringboot.model.State;


@CrossOrigin
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

	
	@RequestMapping(value="/api/pushStates",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<State>> getPagePushData(@RequestBody List<State> list){
			
		//List<State> sList  = Arrays.asList(list);
			//System.out.println(str);
			/*for(State st:list){
				System.out.println(st.getStateCode()+st.getStateNum());
			}*/
			//list.stream().sorted((s1,s2) ->Integer.parseInt(s1.getStateNum()) >Integer.parseInt(s2.getStateNum()));
		//return str;
			return new ResponseEntity<Collection<State>>(list,HttpStatus.OK);
	}

	
	@RequestMapping(value="/api/pushStatesStr",
			method=RequestMethod.POST
			)
	public ResponseEntity<String> getPagePushDataStr(@RequestBody() String strs){
			System.out.println(strs);
			
			
		return new ResponseEntity<String>(strs,HttpStatus.OK);
			
	}
	
	@RequestMapping(value="/api/pushStatesGet/",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<State>> getPushDataGet(@PathVariable List<State> list){
			
	
		//return str;
			return new ResponseEntity<Collection<State>>(list,HttpStatus.OK);
	}
}
