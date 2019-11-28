package com.training.regression.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String sql = "select * from login;";
        
        GetConnection gc  = new GetConnection(); 
        List<LoginBean> list = null;
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
            e.printStackTrace();
        }
        System.out.println(list.size());
        for(LoginBean lb:list)
        {
            System.out.println(lb.getPassword());
            System.out.println(lb.getUserName());
        }

	}

}
