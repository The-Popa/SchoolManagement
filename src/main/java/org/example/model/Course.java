package org.example.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class Course {
    private static int sequencer = 0;
    private int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName, LocalDate startDate, int weekDuration){
        this.id = ++sequencer;
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        students = new ArrayList<Student>();

    }
    public void register(Student student){
        if (!students.contains(student)){
            this.students.add(student);

        }
    }
    public void unregister(Student student){
        if (!students.contains(student)){
            this.students.remove(student);
        }

    }
    public String getCourseName() {
        return courseName;

    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;

    }
    public LocalDate getStartDate() {
        return startDate;

    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;

    }
    public int getWeekDuration() {
        return weekDuration;

    }
    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;

    }
    public int getId(){
        return id;
    }
}
