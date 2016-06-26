package com.wei.service;

import java.util.Date;
import java.util.List;

import com.wei.entity.User;

public interface UserService {
	
	public void addUser(User user);  
    
    public void updateUser(int state,int id);  
      
    public void updateUserdate(Date logindate,int id);
    
    
    public void updateUser(String account,String name,String nickname,String password,int type,int id);
    
    public void deleteUser(int id);  
      
    public String getUser(int id);  
      
    public User getUserByID(int id);  
  
    
      
    public List getUsers();  
      
    public List<User> getUserList();  
  
      
    public void init();

	public User getUserByAccount(String account);

	public List<User> searchUser(List<String> list);  
}
