package com.training.sanity.tests;

import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.Reporter;

import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;


public class DBSelectuser {
	
	
	public void checkuser(String Username) {
	String sql = "select * from login where username= 'naveen1';"; 
    GetConnection gc  = new GetConnection(); 
    List<LoginBean> list = null;
    {
    try {
        gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
        list = new ArrayList<LoginBean>(); 
        
        gc.rs1 = gc.ps1.executeQuery(); 
        
        while(gc.rs1.next()) {
        
            LoginBean temp = new LoginBean(); 
            temp.setUserName(gc.rs1.getString(1));
            temp.setPassword(gc.rs1.getString(2));
            list.add(temp); 
            
        }
    } catch (SQLException e) {
    	Reporter.log("Bug Found: ");
    	e.printStackTrace();
    }
 
    for(LoginBean lb:list)
    {
          if (lb.getUserName().equals(Username))
          {
//        	  System.out.println(lb.getUserName());
//        	  System.out.println(lb.getPassword());
        	  Reporter.log("User is added to database");
          }
          else {
//        	  System.out.println(Username);
//        	  System.out.println(lb.getUserName());
//        	  System.out.println(lb.getPassword());
        	  Reporter.log("Bug Found: User is not added to database");
          }
        
    }

    }
	}

}
