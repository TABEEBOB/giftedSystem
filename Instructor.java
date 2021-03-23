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
public class Instructor {
    
    public String firstname, lastname,street,city,state,office,email;
    public int Id, zip;
    
     public Instructor() {
        
        Id = 00;
        firstname = " ";
        lastname = " ";
        street = " ";
        city = " ";
        state = " ";
        zip = 00;
        office = " ";
        email = " ";  
    }
    public Instructor(int id, String firstname, String lastname, String street, String city, String state, int zip,String office, String email) {
    
    this.Id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.office = office;
    this.email = email;
   
    }
    public int getId() {return Id;}
    public String getFirstName() {return firstname;}
    public String getLastName() {return lastname;}
    public String getStreet() {return street; }
    public String getCity() {return city;}
    public String getState() {return state;}
    public int getZip() {return zip;}
    public String getOffice() {return office;}
    public String getEmail() {return email;}
  
    
    public void setId(int id) {this.Id = id;}
    public void setFirstName(String firstname) {this.firstname = firstname;}
    public void setLastName(String lastname) {this.lastname = lastname;}
    public void setStreet(String street) {this.street = street; }
    public void setCity(String city) {this.city = city;}
    public void setState(String state) {this.state = state;}
    public void setZip(int zip) {this.zip = zip;}
    public void setOffice(String office) {this.office = office;}
    public void setEmail(String email) {this.email = email;}
    
 /*****************************************************************************
 * the selectDB() accepts an int value
 * when run, it displays CRN in database associated with ID
 * 
 ****************************************************************************/
    public void selectDB(int id) {
      Id = id;
   
        try{
        
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
          ResultSet rs = statement.executeQuery("Select * from Instructors where ID = " + id);
				
          rs.next();
         
          firstname = rs.getString(2);
          lastname = rs.getString(3);
          street = rs.getString(4);
          city = rs.getString(5);
          state = rs.getString(6);
          zip = rs.getInt(7);
          office = rs.getString(8);
          email = rs.getString(9);
          
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
   public void insertDB(int id, String firstname, String lastname, String street, String city, String state, int zip, String office, String email) {
       setId(id);
       setFirstName(firstname);
       setLastName(lastname);
       setStreet(street);
       setCity(city);
       setState(state);
       setZip(zip);
       setOffice(office);
       setEmail(email);
     
       
       try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           
            Statement statement = con.createStatement();
            
            String value;
            value ="Insert into Instructors(ID,FirstName,LastName,Street,City,State,Zip,Office,EMail) values("+getId()+","+
                                        "'" +getFirstName() +"',"+
                                        "'" +getLastName() +"',"+
					"'" +getStreet() +"',"+
                                        "'" +getCity() +"',"+
                                        "'" +getState() +"',"+
                                        "'" +getZip() +"',"+
                                        "'" +getOffice() +"',"+
                                        "'" +getEmail()+"')";
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
         public void update(int id,String firstName, String lastName, String street, String city, String state, int zip,String office, String email) {
     
       
        try {
       
           Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
 
           Connection con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\tabe-ebob\\Desktop\\RegistrationMDB1.mdb");
           Statement stmt = con.createStatement();
            String sql = "update Instructors set FirstName = '"+getFirstName() + "',"+ 
                                            " LastName = '"+getLastName() +"',"+
                                            " Street ='"+getStreet()+"',"+
                                            " City ='"+getCity()+"',"+
                                            " State ='"+getState()+"',"+
                                            " Zip ='"+getZip()+"',"+
                                            " Office = '"+getOffice() +"'"+
                                            " EMail = '"+getEmail() +"',"+
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
            value = "delete * from Instructors where ID = '"+getId()+"'";
            
          
               int check = statement.executeUpdate(value);
               
               con.close();
       }
       catch(Exception e) {
       
           System.out.println(e);
       }
   }
   public void display(){
       
        System.out.println("Instructor ID: "+Id);
        System.out.println("Instructor First Name: "+firstname);
        System.out.println("Instructor Last Name: "+lastname);
        System.out.println("Street: "+street);
        System.out.println("City: "+city);
        System.out.println("State: "+state);
        System.out.println("ZipCode: "+zip);
        System.out.println("Instructor Office: "+office);
        System.out.println("Instructor Email "+email); 
       
       
       
    }
   public static void main(String[]args) {
       Instructor instructor1 = new Instructor();
       //instructor1.selectDB(4);
      // instructor1.deleteDB(6);
      
     // instructor1.insertDB(6,"arrey", "jones", "123 Jones", "dallas", "GA", 30098, "B21", "jones@gmail.com");
      instructor1.update(1, "xzym", "rey", "740 crossfire ridge nw", "Dallas","GA", 30064,"b20", "rey@gmail.com");
       instructor1.display();
   }
    
}
