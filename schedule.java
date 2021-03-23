/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*****************************************************************************
 * this class is tied to the StudentSchedule table in the Registration DB
 * within this class are the setter and getters methods
 * we have the select(), insert(), delete(), update()
 * we are able to create new section, modify existing section or delete a selection
 ****************************************************************************/
/**
 *
 * @author tabe-ebob
 */
public class schedule {
    
    int stuId, crn;
    
    public schedule() {
    
        stuId = 0;
        crn = 0;
    }
    public schedule(int stuId, int crn) {
    
    this.stuId = stuId;
    this.crn = crn;
    }
    
    public int getStuId() {return stuId;}
    public int getCrn() {return crn;}
    
    public void setStuId(int stuId) {this.stuId = stuId;}
    public void setCrn(int stuId) {this.crn = stuId;}
  
    /*****************************************************************************
 * the selectDB() accepts an int value
 * when run, it displays CRN in database associated with ID
 * 
 ****************************************************************************/
    public void selectDB(int id) {
      stuId = id;
   
        try{
        
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
          ResultSet rs = statement.executeQuery("Select * from StudentSchedule where StudentID = " + id);
				
          while(rs.next()){
          //stuId = rs.getInt(1);
          crn = rs.getInt(2);
         
            
        }
        }
        catch(Exception e) {
            System.out.println(e);
        }
   
   }
 /*****************************************************************************
 * the insertDB() adds new field into the database
 * 
 ****************************************************************************/
   public void insertDB(int stuId, int crn) {
       setStuId(stuId);
       setCrn(crn);
      
       
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value ="Insert into StudentSchedule(StudentID,CRN) values("+getStuId()+","+
                                        "'" +getCrn()+"')";
               System.out.println(value);
                int check = statement.executeUpdate(value);
               if(check == 1){
                   System.out.println("value has been entered into database");
                  
               }else{
                   System.out.println("Sorry could not insert value into database");
                  
               }
               
               con.close();
           
       }
       catch(Exception e) {
       
           System.out.println(e);
       }
   }
    /*****************************************************************************
 * the deleteDB() accepts an int value
 * when run, it deletes CRN in database associated with ID
 * 
 ****************************************************************************/
   public void deleteDB( int id, int cr) {
   
       stuId = id;
       crn = cr;
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value = "delete  from StudentSchedule where StudentID = '"+getStuId()+"' and CRN = '"+getCrn()+"'";
            
               int check = statement.executeUpdate(value);
               
               con.close();
       }
       catch(Exception e) {
       
           System.out.println(e);
       }
   }  
   public void display(){
       
       System.out.println("Student ID: " +stuId);
       System.out.println("CRN: "+crn);
         
    }
   public static void main(String[]args) {
       schedule schedule = new schedule();
       //schedule.insertDB(5,2323);
       //schedule.deleteDB(5);
      // schedule.selectDB(1);
       schedule.display();
       
   }
}

    
