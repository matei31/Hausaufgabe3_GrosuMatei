package com.company.model;

import java.util.List;

/**
 * Date: 21.10.2021
 */
public class Teacher extends Person {
    private List<Course> courses;

    /**
     * Class constructor.
     * @param firstName is the name of the teacher
     * @param lastName is the last name of the teacher
     * @param courses is a list of courses
     */
    public Teacher(String firstName, String lastName, List<Course> courses) {
        super(firstName, lastName);
        this.courses = courses;
    }

    public List<Course> getCourses() {return courses;}
    public void setCourses(List<Course> courses) {this.courses = courses;}
}
