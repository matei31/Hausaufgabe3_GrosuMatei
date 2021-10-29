package com.company.repository;

import com.company.model.Course;

public class CourseRepo extends InMemoryRepo<Course> {
    public CourseRepo(){
        super();
    }
    /**
     * @param entity entity must not be null
     * @return null - if the entity is updated, otherwise returns the entity - (e.g id does not exist).
     */
    @Override
    public Course update(Course entity) {
        for(Course c:repo_list) {
            if (c.equals(entity)){
                c.setCredit(entity.getCredit());
                c.setMaxEnrollment(entity.getMaxEnrollment());
                c.setTeacher(entity.getTeacher());
                c.setStudentsEnrolled(entity.getStudentsEnrolled());
                return null;
            }
        }
        return entity;
    }
}

