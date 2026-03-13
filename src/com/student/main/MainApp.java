package com.student.main;

import java.util.Scanner;
import com.student.dao.StudentDAO;
import com.student.model.Student;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    if (name.isEmpty() || email.isEmpty() || course.isEmpty()) {
                        System.out.println("Fields cannot be empty");
                        break;
                    }

                    dao.addStudent(new Student(name, email, course));
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    dao.searchStudentById(sid);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine();
                    System.out.print("New Course: ");
                    String newCourse = sc.nextLine();

                    dao.updateStudent(uid, newName, newEmail, newCourse);
                    break;

                case 5:
                    System.out.print("Enter Student ID to Delete: ");
                    int did = sc.nextInt();
                    dao.deleteStudent(did);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}