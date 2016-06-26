package com.wei.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.wei.dao.Dao;
import com.wei.entity.User;

public class UserServiceImpl implements UserService {

	
	private Dao dao;
	User user=null; 
	

	public void addUser(User user) {
		  String sql="insert into user(account,name,nickname,password,state,createdate,type) values(?,?,?,?,?,?,?)";  
	      Object[] params = new Object[] {user.getAccount(),user.getName(),user.getNickname(),user.getPassword(),new Integer(user.getState()),user.getCreatedate(),new Integer(user.getType())};  
	      dao.update(sql, params);  
	}

	
	

	public User getUserByID(int id) {
		 
        String sql="select * from user where id="+id;  
        
        List<Map> lists = dao.getResult(sql);  
        user=null;
        if (lists.size()>0)  
        {  
            user=new User();  
            Map map=lists.get(0);  
            user.setId((Integer)map.get("id"));  
            user.setAccount((String) map.get("account"));
            user.setName((String)map.get("name"));  
            user.setPassword((String) map.get("password"));
            user.setNickname((String)map.get("nickname"));  
            user.setState((Integer)map.get("state")); 
            user.setCreatedate((Date)map.get("createdate"));  
            user.setLastlogindate((Date)map.get("lastlogindate")); 
            user.setType((Integer)map.get("type"));
            
        }  
        return user;  
	}

	

		public User getUserByAccount(String account) {
			String sql="select * from user where account='"+account+"'"; 
			List<Map> lists = dao.getResult(sql); 
			user=null;
			 if (lists.size()>0)  
		      {  
				 	user=new User(); 
		            Map map=lists.get(0);  
		            user.setId((Integer)map.get("id"));  
		            user.setAccount(account);
		            user.setName((String)map.get("name"));  
		            user.setPassword((String) map.get("password"));
		            user.setNickname((String)map.get("nickname"));  
		            user.setState((Integer)map.get("state")); 
		            user.setCreatedate((Date)map.get("createdate"));  
		            user.setLastlogindate((Date)map.get("lastlogindate")); 
		            user.setType((Integer)map.get("type")); 
		      } 
		     return user; 
		}


	public List<User> getUserList() {
		
		
		 String sql = "select * FROM user";  
	        List<Map> lists = dao.getResult(sql);  
	        List<User> users=new ArrayList<User>();  
	        if (lists.size()>0)  
	        {  
	            for(int i=0;i<lists.size();i++)  
	            {  
	                User user=new User();  
	                Map map=lists.get(i);  
	                user.setId((Integer)map.get("id"));  
		            user.setAccount((String)map.get("account"));
		            user.setName((String)map.get("name"));  
		            user.setPassword((String) map.get("password"));
		            user.setNickname((String)map.get("nickname"));  
		            user.setState((Integer)map.get("state")); 
		            user.setCreatedate((Date)map.get("createdate"));  
		            user.setLastlogindate((Date)map.get("lastlogindate")); 
		            user.setType((Integer)map.get("type"));   
	                users.add(user);  
	            }  
	        }  
	        
	        return users; 
		
	}
	
	
	
	
	public void init() {

	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	//改变封存与否状态
	public void updateUser(int state, int id) {
		 String sql="update user set state=? where id=?";  
	        Object[] params = new Object[] {new Integer(state),new Integer(id)};  
	        dao.update(sql, params);  

	}
	
	//更新登录时间
	public void updateUserdate(Date logindate,int id) {
			String sql="update user set lastlogindate=? where id=?";  
	        Object[] params = new Object[] {logindate,new Integer(id)};  
	        dao.update(sql, params);  
	}
	
	public void updateUser(String account, String name, String nickname,
			String password, int type,int id) {
		String sql="update user set account=?,name=?,nickname=?,password=?,type=? where id=?";  
        Object[] params = new Object[] {account, name,  nickname,
    			 password,new Integer(type),new Integer(id)};  
        dao.update(sql, params); 
		
	}
	
	
	

	public void deleteUser(int id) {
		String sql="delete from user where id="+id;  
        dao.delete(sql); 
	}

	public String getUser(int id) {
		String sql="select name from t_test where id="+id;  
        String name=dao.getResultValue(sql, "name");  
        return name; 
	}




	public List getUsers() {
		// TODO Auto-generated method stub
		return null;
	}


//	 list.add(account);
//     list.add(name);
//     list.add(type);
//     list.add(startime);
//     list.add(endtime);

	public List<User> searchUser(List<String> list) {
		
			String sql="select * from user where 1=1";
			for (int i = 0; i < list.size()-1; i++) {
				if(list.get(i)==""){
					
				}else{
					switch(i){
					case 0:
						sql+=" and account like '%"+list.get(i)+"%'";
						break;
					case 1:
						sql+=" and name like '%"+list.get(i)+"%'";
						break;
					case 2:
						sql+=" and type="+Integer.parseInt(list.get(i));
						break;
					case 3:
						sql+=" and createdate between '"+list.get(3)+"' and '"+list.get(4)+"'";
						break;
					}
					
				}
			}
			
			System.out.println("sql="+sql);
			
		 	List<Map> lists = dao.getResult(sql);  
	        List<User> users=new ArrayList<User>();  
	        if (lists.size()>0)  
	        {  
	            for(int i=0;i<lists.size();i++)  
	            {  
	                User user=new User();  
	                Map map=lists.get(i);  
	                user.setId((Integer)map.get("id"));  
		            user.setAccount((String)map.get("account"));
		            user.setName((String)map.get("name"));  
		            user.setPassword((String) map.get("password"));
		            user.setNickname((String)map.get("nickname"));  
		            user.setState((Integer)map.get("state")); 
		            user.setCreatedate((Date)map.get("createdate"));  
		            user.setLastlogindate((Date)map.get("lastlogindate")); 
		            user.setType((Integer)map.get("type"));   
	                users.add(user);  
	            }  
	        }  
	        
	        return users; 
		
		
		
	}




	





}
