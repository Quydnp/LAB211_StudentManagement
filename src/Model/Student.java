/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author HI
 */
public class Student implements Comparable<Student>{
    String id;
    String name;
    String semester;
    ArrayList<String> courseName;

    public Student(String id, String name, String semester, ArrayList<String> courseName) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.courseName = courseName;
    }
    
    public Student(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public ArrayList<String> getCourseName() {
        return courseName;
    }

    public void setCourseName(ArrayList<String> courseName) {
        this.courseName = courseName;
    }
    
    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}
