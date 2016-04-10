package com.james.springboot.restspringboot.dao;

import java.util.List;

import com.james.springboot.restspringboot.model.EBS;

public interface IEbsDao {

	public List<EBS> getAllStudents();
	public List<EBS> getStudentById(int id);
}
