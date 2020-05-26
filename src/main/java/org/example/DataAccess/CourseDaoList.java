package org.example.DataAccess;


import org.example.model.Course;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CourseDaoList implements CourseDao {
    private static List<Course> courses;

    @Override
    public Course saveCourse(Course course){
        if(course == null) return null;
        if(findById(course.getId()) != null){
            throw new IllegalArgumentException("Course id already exists");}
        else {
            courses.add((course));
            return course;
        }
    }
    @Override
    public Course findById(int id){
        for(Course course : courses){
            if(course.getId() == id){
                return course;
            }
        }
        return null;

    }
    @Override
    public  List<Course> findByName(String name){
        List<Course> results = new ArrayList<>();
        for(Course course : courses){
            if(course.getCourseName().equalsIgnoreCase(name)){
                results.add(course);

            }
        }
        return results;

    }

    @Override
    public List<Course> findByDate(LocalDate date){
        List<Course> results = new ArrayList<>();
        for(Course course : courses){
            if(course.getStartDate().isEqual(date)) {
                results.add(course);
            }
        }
        return results;

    }
    @Override
    public List<Course> findAll(){
        return courses;

    }
    @Override
    public boolean removeCourse(Course course){
        return courses.remove(course);
    }
}