package com.company.model;

import java.util.List;

/**
 * Class Student is a subclass of Person;
 * Aside from first and last name, a student has an ID and a list of courses
 * Date: 25.10.2021
 */
public class Student extends Person {
    private long studentID;
    private int totalCredits;
    private List<Course> enrolledCourses;

    /**
     * Class constructor
     * @param firstName is the first name
     * @param lastName is the last name
     * @param studentID is the ID
     * @param enrolledCourses is a list of courses
     */
    public Student(String firstName, String lastName, long studentID, List<Course> enrolledCourses){
        super(firstName, lastName);
        this.studentID = studentID;
        this.enrolledCourses=enrolledCourses;
        for (Course c: this.enrolledCourses)
            totalCredits += c.getCredit();
    }

    public long getStudentID() {return studentID;}
    public void setStudentID(long studentID) {this.studentID = studentID;}

    public int getTotalCredits() {return totalCredits;}
    public void setTotalCredits(int totalCredits) {this.totalCredits = totalCredits;}

    public List<Course> getEnrolledCourses() {return enrolledCourses;}
    public void setEnrolledCourses(List<Course> enrolledCourses) {this.enrolledCourses = enrolledCourses;}
}
