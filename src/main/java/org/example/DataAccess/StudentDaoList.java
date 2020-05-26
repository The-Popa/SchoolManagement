package org.example.DataAccess;

import org.example.model.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {
    private static List<Student> students;

    @Override
    public Student saveStudent(Student student){
        if(student == null) return null;
        if(findById(student.getStudentId()) != null){
            throw new IllegalArgumentException("Student id already exists");
        }
        else {
            students.add((student));
            return student;
        }
    }
    @Override
    public Student findByEmail(String email){
        for(Student student : students){
            if(student.getEmail() == email){
                return student;
            }
        }
        return null;

    }
    @Override
    public List<Student> findByName(String name){
        List<Student> results = new ArrayList<>();
        for (Student student : students){
            if(student.getName().equalsIgnoreCase(name)){
                results.add(student);
            }
        }
        return results;

    }
    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                return student;

            }
        }
        return null;

    }
    @Override
    public List<Student> findAll(){
        return students;

    }
    @Override
    public boolean deleteStudent(Student student){
        return students.remove(student);
    }
}
