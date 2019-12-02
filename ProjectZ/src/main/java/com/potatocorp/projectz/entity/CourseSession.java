/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.potatocorp.projectz.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author thoma
 */
@Entity
@Table(name = "course_session")

@org.hibernate.annotations.NamedQueries({
    @org.hibernate.annotations.NamedQuery(name = "CourseSessionFindByLocation", 
        query = "from CourseSession where LOCATION_ID = :locationId"),
    @org.hibernate.annotations.NamedQuery(name = "CourseSessionFindByCourse", 
        query = "from CourseSession where COURSE_CODE = :courseCode")
})

public class CourseSession implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID", unique = true, nullable = false)
    private Integer id;
    
    @Column (name = "START_DATE", nullable = false)
    private Date startDate;
    
    @Column (name = "END_DATE", nullable = false)
    private Date endDate;
    
    @Column (name = "MAX", nullable = false)
    private int max;
    
    @ManyToOne
    @JoinColumn (name = "COURSE_CODE", nullable = false)
    private Course course;
    
    @ManyToOne
    @JoinColumn (name = "LOCATION_ID", nullable = false)
    private Location location;

    public CourseSession() {
    }

    public CourseSession(Integer id, Date startDate, Date endDate, int max, Course course, Location location) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.max = max;
        this.course = course;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.startDate);
        hash = 97 * hash + Objects.hashCode(this.endDate);
        hash = 97 * hash + this.max;
        hash = 97 * hash + Objects.hashCode(this.course);
        hash = 97 * hash + Objects.hashCode(this.location);
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
        final CourseSession other = (CourseSession) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.max != other.max) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endDate, other.endDate)) {
            return false;
        }
        if (!Objects.equals(this.course, other.course)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CourseSession{" + "id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", max=" + max + ", course=" + course + ", location=" + location + '}';
    }
    
}
