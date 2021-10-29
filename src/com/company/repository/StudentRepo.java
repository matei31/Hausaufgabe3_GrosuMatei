package com.company.repository;

import com.company.model.Student;
import com.company.repository.InMemoryRepo;

public class StudentRepo extends InMemoryRepo<Student> {
    public StudentRepo(){
        super();
    }
    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Student update(Student entity){
        for(Student s: repo_list) {
            if (s.equals(entity)){
                s.setStudentID(entity.getStudentID());
                s.setEnrolledCourses(entity.getEnrolledCourses());
                s.setTotalCredits(entity.getTotalCredits());
                return null;
            }
        }
        return entity;
    }
}
