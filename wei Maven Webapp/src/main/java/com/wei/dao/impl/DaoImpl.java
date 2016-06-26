package com.wei.dao.impl;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.wei.dao.Dao;

public class DaoImpl implements Dao {

	 private JdbcTemplate jt;  
	  
	  
	    public int getCount(String sql) {  
	        int count = 0;  
	        try {  
	            count = jt.queryForInt(sql);  
	        } catch (DataAccessException e) {  
	        }  
	        return count;  
	    }  
	      
	    public String getResultValue(String sql, String column) {  
	        String value = "";  
	        try {  
	            SqlRowSet s = jt.queryForRowSet(sql);  
	            while (s.next()){  
	                value = s.getString(column);  
	            }  
	        } catch (DataAccessException e) {  
	        }  
	        return value;  
	    }  
	  
	    public List getResult(String sql) {  
	        List list = null;  
	        try {  
	            list = jt.queryForList(sql);  
	        } catch (DataAccessException e) {  
	        }  
	        return list;  
	    }  
	    
	    
	    public void update(String sql) {  
	    	  
	        try {  
	            jt.update(sql);  
	        } catch (DataAccessException e) {  
	        }  
	    }  
	  
	    public void delete(String sql) {  
	        try {  
	            jt.execute(sql);  
	        } catch (DataAccessException e) {  
	        }  
	    }  
	  
	  
	  
	    public void update(String sql, Object[] params) {  
	        // TODO Auto-generated method stub  
	        try {  
	            jt.update(sql,params);  
	        } catch (DataAccessException e) {  
	        }  
	    }  
	  
	    public void setJt(JdbcTemplate jt) {  
	        this.jt = jt;  
	    }  
	      
	    public JdbcTemplate getJt() {  
	        return jt;  
	    }  

}
