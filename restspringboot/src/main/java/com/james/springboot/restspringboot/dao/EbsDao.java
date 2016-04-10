package com.james.springboot.restspringboot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.james.springboot.restspringboot.model.EBS;



@Repository
public class EbsDao implements IEbsDao {
	
	
	@Autowired
	@Qualifier(value="localJDBC")
	private JdbcTemplate jdbcTemplate;
	
	
	public List<EBS> getAllStudents(){
		String sql ="select * from EBS";
		
		List<EBS> list = jdbcTemplate.query(sql,(rs,i)->{
			
			EBS student = new EBS();
			
			student.setStuId(rs.getInt("stu_id"));
			student.setFirstName(rs.getString("stu_first_name"));
			student.setLastName(rs.getString("stu_last_name"));
			student.setFinacialNum(rs.getInt("stu_financial_aid_id"));
			student.setTeacherId(rs.getInt("stu_teach_id"));
			return student;
		});
		return list;
	}
	
	
	public List<EBS> getStudentById(int id){
		String sql="select * from EBS where stu_id=?";
		 List<EBS> list = jdbcTemplate.query(sql,new Object[]{id}, (rs,num)->{
				EBS student = new EBS();
			
			student.setStuId(rs.getInt("stu_id"));
			student.setFirstName(rs.getString("stu_first_name"));
			student.setLastName(rs.getString("stu_last_name"));
			student.setFinacialNum(rs.getInt("stu_financial_aid_id"));
			student.setTeacherId(rs.getInt("stu_teach_id"));
			return student;
		});
		 
		 return list;
	}
}
