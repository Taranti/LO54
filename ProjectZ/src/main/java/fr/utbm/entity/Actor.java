package fr.utbm.entity;
// Generated 19 nov. 2016 10:33:10 by Hibernate Tools 4.3.1



/**
 * Actor generated by hbm2java
 */
public class Actor  implements java.io.Serializable {


     private int id;
     private String lastname;
     private String firstname;

    public Actor() {
    }

	
    public Actor(int id, String lastname) {
        this.id = id;
        this.lastname = lastname;
    }
    public Actor(int id, String lastname, String firstname) {
       this.id = id;
       this.lastname = lastname;
       this.firstname = firstname;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getLastname() {
        return this.lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getFirstname() {
        return this.firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }




}


