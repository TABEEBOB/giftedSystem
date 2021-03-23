package business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*****************************************************************************
 * this class is tied to the Courses table in the Registration DB
 * within this class are the setter and getters methods
 * we have the select(), insert(), delete(), update()
 * we are able to create new section, modify existing section or delete a selection
 ****************************************************************************/

/**
 *
 * @author tabe-ebob
 */
public class courses {
    
    public String Id, coursename,coursedescription;
    public int credithour;
    
    
    public courses() {
        
        Id = " ";
        coursename = " ";
        coursedescription = " ";
        credithour = 00;
    }
    
     public courses( String id, String coursename, String coursedescription, int credithour) {
        
       this.Id = id;
       this.coursename = coursename;
       this.coursedescription = coursedescription;
       this.credithour = credithour;
    }
    
    public String getId() {return Id;}
    public String getCoursename() {return coursename;}
    public String getCoursedescription() {return coursedescription;}
    public int getCredithour() {return credithour; }
   
    public void setId(String id) {this.Id = id;}
    public void setCoursename(String coursename) {this.coursename = coursename;}
    public void setCoursedescription(String coursedescription) {this.coursedescription = coursedescription;}
    public void setCredithour(int credithour) {this.credithour = credithour; }
  
      /*****************************************************************************
 * the selectDB() accepts an int value
 * when run, it displays CRN in database associated with ID
 * 
 ****************************************************************************/
    public void selectDB(String id) {
      Id = id;
   
        try{
        
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
          ResultSet rs = statement.executeQuery("Select * from Courses where CourseID = " + id);
				
          rs.next();
         
          coursename = rs.getString(2);
          coursedescription = rs.getString(3);
          credithour = rs.getInt(4); 
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
   public void insertDB(String id, String coursename, String coursedescription, int credithour) {
       setId(id);
       setCoursename(coursename);
       setCoursedescription(coursedescription);
       setCredithour(credithour);
       
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value ="Insert into Courses(CourseID,CourseName,Description, CreditHours) values("+getId()+","+
                                        "'" +getCoursename() +"',"+
                                        "'" +getCoursedescription() +"',"+
                                        "'" +getCredithour()+"')";
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
   public void deleteDB(String id) {
   
       Id = id;
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value = "delete * from Courses where CourseID = '"+getId()+"'";
            
             int check = statement.executeUpdate(value);
               con.close();
       }
       catch(Exception e) {
       
           System.out.println(e);
       }
   }
   public void display(){
       
        System.out.println("Course ID: "+Id);
        System.out.println("Course  Name: "+coursename);
        System.out.println("Description: "+coursedescription);
        System.out.println("Credit Hours: "+credithour);    
    }
   public static void main(String[]args) {
       courses course1 = new courses();
       //course1.selectDB("CIST 1122");
       course1.insertDB("'CIST 1100'", "Intro Law", "basic law terms", 4);
       //course1.deleteDB("CIST 1100");
       course1.display();
       
   }
}
