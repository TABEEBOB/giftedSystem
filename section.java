package business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*****************************************************************************
 * this class is tied to the Sections table in the Registration DB
 * within this class are the setter and getters methods
 * we have the select(), insert(), delete(), update()
 * we are able to create new section, modify existing section or delete a selection
 ****************************************************************************/

/**
 *
 * @author tabe-ebob
 */
public class section {
    
    public String Id, time,room;
    public int crn, instructor;
    
    
    public section() {
        
        crn = 0;
        Id = " ";
        time = " ";
        room = " ";
        instructor= 00;
    }
    
     public section( int crn, String id, String time, String room, int instructor) {
       
       this.crn = crn;
       this.Id = id;
       this.time = time;
       this.room = room;
       this.instructor = instructor;
    }
    
    public int getCrn() { return crn;}
    public String getId() {return Id;}
    public String getTime() {return time;}
    public String getRoom() {return room;}
    public int getInstructor() {return instructor; }
    
  
    public void setCrn(int crn) { this.crn = crn;}
    public void setId(String id) {this.Id = id;}
    public void setTime(String time) {this.time = time;}
    public void setRoom(String room) {this.room = room;}
    public void setInstructor(int instructor) {this.instructor = instructor; }
  
    
 /*****************************************************************************
 * the selectDB() accepts an int value
 * when run, it displays CRN in database associated with ID
 * 
 ****************************************************************************/
    public void selectDB(int crn) {
      crn = crn;
   
        try{
        
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
          ResultSet rs = statement.executeQuery("Select * from Sections where CRN = " + crn);
				
          rs.next();
         
          Id = rs.getString(2);
          time = rs.getString(3);
          room = rs.getString(4);
          instructor = rs.getInt(5);
          con.close();   
        }
        catch(Exception e) {
            System.out.println(e);
        }
   
   }
     /*****************************************************************************
 * the insertDB() adds new field into the database
 * 
 ****************************************************************************/
   public void insertDB(int crn, String id, String time, String room, int instructor) {
       setCrn(crn);
       setId(id);
       setTime(time);
       setRoom(room);
       setInstructor(instructor);
       
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value ="Insert into Sections(CRN,CourseID,TimeDays, RoomNo, Instructor) values("+getCrn()+","+
                                        "'" +getId() +"',"+
                                        "'" +getTime() +"',"+
                                        "'" +getRoom() +"',"+
                                        "'" +getInstructor()+"')";
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
   public void deleteDB(int Crn) {
   
       crn = Crn;
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value = "delete * from Sections where CRN = '"+getCrn()+"'";
            
          
               int check = statement.executeUpdate(value);
               con.close();
       }
       catch(Exception e) {
       
           System.out.println(e);
       }
   }
   public void display(){
       
       System.out.println("CRN: " +crn);
        System.out.println("Course ID: "+Id);
        System.out.println("Time & Day: "+time);
        System.out.println("RoomNo: "+room);
        System.out.println("Instructor: "+instructor);    
    }
   public static void main(String[]args) {
       section section1 = new section();
       //section1.selectDB(30101);
       section1.deleteDB(3111);
      //section1.insertDB(3111, "Cist101", "M9Pm", "F21", 3);
       section1.display();
       
   }
}
