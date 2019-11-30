/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author thoma
 */

@Entity
@Table(name = "client")
public class Client implements Serializable {
    
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    
    @Column(name = "LAST_NAME", nullable = false, length = 45)
    private String lastName;
    
    @Column(name = "FIRST_NAME", nullable = false, length = 45)
    private String firstName;
    
    @Column(name = "ADDRESS", nullable = false, length = 45)
    private String address;
    
    @Column(name = "PHONE", nullable = false, length = 45)
    private String phone;
    
    @Column(name = "EMAIL", length = 45)
    private String email;
    
    @ManyToOne
    @Column (name = "COURSE_SESSION", nullable = false, length = 45)
    private CourseSession session;

    public Client() {
    }

    public Client(int id, String lastName, String firstName, String address, String phone, String email, CourseSession session) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.session = session;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CourseSession getSession() {
        return session;
    }

    public void setSession(CourseSession session) {
        this.session = session;
    }   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.lastName);
        hash = 17 * hash + Objects.hashCode(this.firstName);
        hash = 17 * hash + Objects.hashCode(this.address);
        hash = 17 * hash + Objects.hashCode(this.phone);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.session);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.session, other.session)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", lastName=" + lastName + ", firstName=" + firstName + ", address=" + address + ", phone=" + phone + ", email=" + email + ", session=" + session + '}';
    }
    
    
}
