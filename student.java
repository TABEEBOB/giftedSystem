package business;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class student {
    public String password, firstName, lastName, street, city, state, email;
    public int Id, zip, gpa;
    
    public student() {
        
        Id = 00;
        password = " ";
        firstName = " ";
        lastName = " ";
        street = " ";
        city = " ";
        state = " ";
        zip = 00;
        email = " ";
        gpa = 00;   
    }
    public student(int id, String password, String firstName, String lastName, String street, String city, String state, int zip, String email, int gpa) {
    
    this.Id = id;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.email = email;
    this.gpa = gpa;
    }
    public int getId() {return Id;}
    public String getPassword() {return password;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getStreet() {return street; }
    public String getCity() {return city;}
    public String getState() {return state;}
    public int getZip() {return zip;}
    public String getEmail() {return email;}
    public int getGpa() {return gpa;}
    
    public void setId(int id) {this.Id = id;}
    public void setPassword(String password) {this.password = password;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public void setStreet(String street) {this.street = street; }
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}
    public void setZip(int zip) {this.zip = zip;}
    public void setEmail(String email) {this.email = email;}
    public void setGpa(int gpa) {this.gpa = gpa;}
    
 /*****************************************************************************
 * the selectDB() accepts an int value
 * when run, it displays CRN in database associated with ID
 * it does this one ID at a time
 * 
 ****************************************************************************/
    public void selectDB(int id) {
      Id = id;
   
        try{
        
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
          ResultSet rs = statement.executeQuery("Select * from Students where ID = " + id);
				
          rs.next();
          password = rs.getString(2);
          firstName = rs.getString(3);
          lastName = rs.getString(4);
          street = rs.getString(5);
          city = rs.getString(6);
          state = rs.getString(7);
          zip = rs.getInt(8);
          email = rs.getString(9);
          gpa = rs.getInt(10);
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
   public void insertDB(int id, String password, String firstName, String lastName, String street, String city, String state, int zip, String email, int gpa) {
       setId(id);
       setPassword(password);
       setFirstName(firstName);
       setLastName(lastName);
       setStreet(street);
       setCity(city);
       setState(state);
       setZip(zip);
       setEmail(email);
       setGpa(gpa);
       
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value ="Insert into Students(ID,Password,FirstName,LastName,Street,City,State,Zip,Email,GPA) values("+getId()+","+
					"'" +getPassword() +"',"+
                                        "'" +getFirstName() +"',"+
                                        "'" +getLastName() +"',"+
					"'" +getStreet() +"',"+
                                        "'" +getCity() +"',"+
                                        "'" +getState() +"',"+
                                        "'" +getZip() +"',"+
                                        "'" +getEmail() +"',"+
                                        "'" +getGpa()+"')";
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
 * the update() accepts an int value
 * when run, it matches the value in the database then modifies the columns 
 * 
 ****************************************************************************/
   public void update(int id, String password, String firstName, String lastName, String street, String city, String state, int zip, String email, int gpa) {
     
       
        try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
 
           Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           Statement stmt = con.createStatement();
            String sql = "update Students set Password = '"+getPassword() + "',"+ 
                                            " FirstName ='"+getFirstName()+"',"+
                                            " LastName = '"+getLastName() +"',"+
                                            " Street ='"+getStreet()+"',"+
                                            " City ='"+getCity()+"',"+
                                            " State ='"+getState()+"',"+
                                            " Zip ='"+getZip()+"',"+
                                            " EMail = '"+getEmail() +"',"+
                                            " GPA = '"+getGpa() +"'"+
                                            " WHERE ID='"+getId()+"'";
          
            System.out.println(sql);
            int n = stmt.executeUpdate(sql);
            if (n==1)
                System.out.println("UPDATE Successful!!!");
            else
                System.out.println("UPDATE FAILED***********");
            
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
   public void deleteDB(int id) {
   
       Id = id;
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value = "delete * from Students where ID = '"+getId()+"'";
            
          
               int check = statement.executeUpdate(value);
               
               con.close();
       }
       catch(Exception e) {
       
           System.out.println(e);
       }
   }
   public void display(){
       
        System.out.println("Student ID: "+Id);
        System.out.println("Student Password: "+password);
        System.out.println("Student First Name: "+firstName);
        System.out.println("Student Last Name: "+lastName);
        System.out.println("Street: "+street);
        System.out.println("City: "+city);
        System.out.println("State: "+state);
        System.out.println("ZipCode: "+zip);
        System.out.println("Customer Email "+email); 
        System.out.println("Student GPA: "+gpa);
     
    }
   public static boolean validate(int stuId, String password) throws SQLException, ClassNotFoundException {
       
       boolean status = false;
       try{
           
       Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        Connection connection = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
        
        String sql = "SELECT * FROM Students WHERE ID = ? and Password = ?";
        
        PreparedStatement statement = connection.prepareStatement(sql);
        
        statement.setInt(1,stuId);
        statement.setString(2,password);
 
        ResultSet rs=statement.executeQuery();  
        status=rs.next();  
       
    }
       catch(Exception e) {
       System.out.print(e);
       }
        return status;
   }
       
   public static void main(String[]args) {
       student student1 = new student();
      // student1.selectDB(9);
       student1.update(1, "xzym", "mike", "rey", "740 crossfire ridge nw", "Dallas","GA", 30064, "rey@gmail.com", (int) 2.6);
       //student1.deleteDB(16);
       //student1.update(1);
       student1.display();
   }
    
    }

