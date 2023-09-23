/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author HI
 */
public class StudentList {

    private ArrayList<Student> StudentList = new ArrayList();
    Validation val = new Validation();

    public void createStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Add Student -----------");
        System.out.print("Enter Id: ");
        String id = sc.nextLine();
        try {
            if (id.isEmpty()) {
                throw new NullPointerException("Null string entered.");
            }

            // Xử lý chuỗi nhập vào nếu không null
            if (val.checkIdExist(StudentList, id) == -1) {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter semester: ");
                String semester = sc.nextLine();
                System.out.print("Enter course name: ");
                ArrayList<String> courseList = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    String courseName = sc.nextLine();
                    courseList.add(courseName);
                    if (!val.checkInputYN("Do you want to add more course?")) {
                        break;
                    }
                }
                Student st = new Student(id, name, semester, courseList);
                StudentList.add(st);
            } else {
                System.out.println("There has been a student with ID: " + id);
            }
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
            // Xử lý lỗi khi chuỗi nhập vào là null
        }
    }

    public void updateStudent(String id) {
        Scanner sc = new Scanner(System.in);
        System.out.println("----------- Update Student ------------");
        if (val.checkIdExist(StudentList, id) == -1) {
            System.out.println("There is no student with the ID:" + id);
        } else {
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter semester: ");
            String semester = sc.nextLine();
            System.out.print("Enter course name: ");
            ArrayList<String> courseList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                String courseName = sc.nextLine();
                courseList.add(courseName);
                if (!val.checkInputYN("Do you want to add more course?")) {
                    break;
                }
            }
            StudentList.set(val.checkIdExist(StudentList, id), new Student(id, name, semester, courseList));
        }
    }

    public void deleteStudent(String id) {
        System.out.println("------------- Delete Student ------------");
        if (val.checkIdExist(StudentList, id) == -1) {
            System.out.println("There is no student with the ID:" + id);
        } else {
            StudentList.remove(val.checkIdExist(StudentList, id));
        }
    }

    public void searchStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------- Search Student --------");
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        ArrayList<Student> foundStudents = new ArrayList<>();
        Predicate<Student> Predicate = student -> student.getId().contains(text) || student.getName().contains(text) || student.getSemester().contains(text);
        boolean isStudentFound = false;
        for (Student student : StudentList) {
            if (Predicate.test(student)) {
                foundStudents.add(student);
                isStudentFound = true;
            }
        }
        if (!isStudentFound) {
            System.out.println("There is no Student found with text: " + text);
        }
        Collections.sort(StudentList);
        System.out.println("---------- Result -----------");
        System.out.printf("%-10s %-30s %-30s %-12s%n", "ID", "Name", "Semester", "Course name");
        for (int i = 0; i < foundStudents.size(); i++) {
            Student get = foundStudents.get(i);
            String courseName = "";
            for (int j = 0; j < get.getCourseName().size(); j++) {
                courseName += get.getCourseName().get(j) + ", ";
            }
            courseName = courseName.substring(0, courseName.length()-2);
            System.out.printf("%-10s %-30s %-30s %-12s%n", get.getId(), get.getName(), get.getSemester(), courseName);
        }
    }
    
    public boolean searchStudent(String id){
        Predicate<Student> Predicate = student -> student.getId().equalsIgnoreCase(id);
        boolean isStudentFound = false;
        for (Student student : StudentList) {
            if (Predicate.test(student)) {
                isStudentFound = true;
            }
        }
        if (!isStudentFound) {
            System.out.println("There is no Student found with ID: " + id);
        }
        return isStudentFound;
    }

    public void studentReport() {
        for (Student student : StudentList) {
            String courseName = "";
            for (int j = 0; j < student.getCourseName().size(); j++) {
                courseName += student.getCourseName().get(j) + ", ";
            }
            courseName = courseName.substring(0, courseName.length()-2);
            System.out.printf("%-10s %-30s %-30s %n", student.getName() +" | ", courseName + " | ",student.getCourseName().size());
        }
    }
}
