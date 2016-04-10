package com.james.springboot.restspringboot.service.action;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.james.springboot.restspringboot.dao.IEbsDao;
import com.james.springboot.restspringboot.model.EBS;

@RestController
public class LocalJDBCRestController {

	@Autowired
	private IEbsDao service;

	@RequestMapping(value = "/api/getStudents", 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<EBS>> getAllStudents() {

		List<EBS> list = service.getAllStudents();
		return new ResponseEntity<Collection<EBS>>(list,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/api/getStudByJson", 
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<EBS>> getStudentByJsonObj(@RequestBody EBS ebs) {

		List<EBS> list = service.getStudentById(ebs.getStuId());
		return new ResponseEntity<Collection<EBS>>(list,HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/api/pushStuJSONArray", 
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<EBS>> getStudentByJsonArray(@RequestBody List<EBS> list) {

		//List<EBS> list = service.getStudentById(ebs.getStuId());
		return new ResponseEntity<Collection<EBS>>(list,HttpStatus.OK);
	}
}
