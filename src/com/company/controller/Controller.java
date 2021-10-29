package com.company.controller;

import com.company.model.Course;
import com.company.model.Student;
import com.company.repository.CourseRepo;
import com.company.repository.StudentRepo;

import java.util.ArrayList;

/**
 * Classname Controller
 * Date: 25.10.2021
 */
public class Controller {
    private final StudentRepo srepo;
    private final CourseRepo crepo;

    /**
     * Class constructor.
     *
     * @param srepo is a students repository
     * @param crepo is a courses repository
     */
    public Controller(StudentRepo srepo, CourseRepo crepo) {
        this.srepo = srepo;
        this.crepo = crepo;
    }

    /**
     * @param s is a student
     * @param c is a course
     * @return true if the student s was enrolled to the course s
     */
    public boolean register(Student s, Course c) {
        if (c.getStudentsEnrolled().size() == c.getMaxEnrollment()) {
            System.out.println("Maximum number of students reached");
            return false;
        } else if (s.getTotalCredits() + c.getCredit() > 30) {
            System.out.println("Maximum number of credits reached");
            return false;
        } else {
            ArrayList<Course> newcourselist = (ArrayList<Course>) s.getEnrolledCourses();
            newcourselist.add(c);
            s.setEnrolledCourses(newcourselist);
            s.setTotalCredits(s.getTotalCredits() + c.getCredit());
            ArrayList<Student> newstudlist = (ArrayList<Student>) c.getStudentsEnrolled();
            newstudlist.add(s);
            c.setStudentsEnrolled(newstudlist);
            return true;
        }
    }

    /**
     * @return the list of courses with available places and display the courses and number of places
     */
    public ArrayList<Course> retrieveCourses() {
        ArrayList<Course> newlist = new ArrayList<>();
        for (Course c : crepo.findAll()) {
            if (c.getStudentsEnrolled().size() < c.getMaxEnrollment()) {
                newlist.add(c);
                System.out.println(c + " " + (c.getMaxEnrollment() - c.getStudentsEnrolled().size()));
            }
        }
        return newlist;
    }

    /**
     * @param c is a course
     * @return the list of students enrolled for course c
     */
    public ArrayList<Student> retrieveStudents(Course c) {
        return (ArrayList<Student>) crepo.findOne(c).getStudentsEnrolled();
    }

    /**
     * @return sll courses
     */
    public ArrayList<Course> getAllCourses() {
        return (ArrayList<Course>) crepo.findAll();
    }

    /**
     * Function updateCredits modifies the no of credits of a course and it also updates the totalCredits of
     * the students that are enrolled
     * @param c is a course
     * @param newcredits is the new number of credits
     */
    public void updateCredits(Course c, int newcredits) {
        int diff = c.getCredit() - newcredits;
        crepo.findOne(c).setCredit(newcredits);
        for (Student s: c.getStudentsEnrolled()) {
            s.setTotalCredits(s.getTotalCredits() - diff);
        }
    }

    /**
     * Function deleteTeacher sets the teacher for course c to null and removes the course from all enrolled students
     * @param c is the course for which we want to remove the teacher
     */
    public void deleteTeacher (Course c) {
        c.getTeacher().getCourses().remove(c);
        c.setTeacher(null);
        for (Student s: c.getStudentsEnrolled())
        {
            ArrayList<Course> newcourselist = (ArrayList<Course>) s.getEnrolledCourses();
            newcourselist.remove(c);
            s.setEnrolledCourses(newcourselist);
        }
    }

}
