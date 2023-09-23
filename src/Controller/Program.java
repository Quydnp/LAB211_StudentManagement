/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.StudentList;
import Model.Validation;
import View.Menu;
import java.util.Scanner;

/**
 *
 * @author HI
 */
public class Program extends Menu<String> {

    StudentList studentList = new StudentList();
    Validation validation = new Validation();
    Scanner sc = new Scanner(System.in);

    public Program() {
        super("STUDENT MANAGEMENT PROGRAM", new String[]{
            "Create Student",
            "Find and Sort students",
            "Update/Delete student",
            "Student Report",
            "Exit"});

    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1:
                studentList.createStudent();
                break;
            case 2:
                studentList.searchStudent();
                break;
            case 3:
                System.out.print("Enter student ID: ");
                String id = sc.nextLine();
                if (studentList.searchStudent(id)) {
                    System.out.println("Student found.");
                    System.out.println("Do you want to update (U) or delete (D) student?");
                    while (true) {
                        String answer = sc.nextLine();
                        if (answer.equalsIgnoreCase("U")) {
                            studentList.updateStudent(id);
                            break;
                        } else if (answer.equalsIgnoreCase("D")) {
                            studentList.deleteStudent(id);
                            break;
                        } else {
                            System.err.println("Please input y/Y or n/N.");
                            System.out.print("Enter again: ");
                        }
                    }
                }
                break;
            case 4:
                studentList.studentReport();
                break;
            case 5:
                System.out.println("Thank you!");
                break;
            default:
                throw new AssertionError();
        }
    }

}
