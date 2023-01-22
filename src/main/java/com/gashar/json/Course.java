/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.json;

/**
 *
 * @author gasha
 */
public class Course {
    private String courseName;
    private long courseNumber;
    private String creatorUsername;
    
    public Course(String name, long number, String author) {
        this.courseName = name;
        this.courseNumber = number;
        this.creatorUsername = author;
    }
    
    public String getCourseName() {
        return this.courseName;
    }
    
    public void setCourseName(String s) {
        this.courseName = s;
    }
    
    public String getCreatorUsername() {
        return this.creatorUsername;
    }
    
    public void setCreatorUsername(String s) {
        this.creatorUsername = s;
    }
    
    public long getCourseNumber() {
        return this.courseNumber;
    }
    
    public void setCourseNumber(long i) {
        this.courseNumber = i;
    }
}
