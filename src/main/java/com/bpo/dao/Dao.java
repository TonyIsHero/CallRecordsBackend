package com.bpo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.bpo.model.RecordModel;

@Component
public class Dao {

	@Autowired
	JdbcTemplate jdbctemplate;
	public List<RecordModel> getCalldetails() {
		
		List<RecordModel> callList = new ArrayList<>();
		String sql="select * from callrecords";
		
		
		return jdbctemplate.query(sql, new ResultSetExtractor<List<RecordModel>>() {
			
			public List<RecordModel> extractData(ResultSet rs)throws SQLException, DataAccessException{

				while(rs.next()) {
					
					RecordModel e=new RecordModel();
					e.setId(rs.getInt(1));
					e.setFrom_number(rs.getString(2));
					e.setStart_time(rs.getString(3));
					e.setEnd_time(rs.getString(4));
					e.setDuration(rs.getInt(5));
					callList.add(e);
					
				}
				return callList;
			}
		});
	}

}
