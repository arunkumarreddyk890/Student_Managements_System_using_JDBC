package com.student.dao;

import java.sql.*;
import com.student.model.Student;
import com.student.util.DBConnection;

public class StudentDAO {

    // ADD STUDENT
    public void addStudent(Student s) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "INSERT INTO students(name,email,course) VALUES(?,?,?)")) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());

            ps.executeUpdate();
            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // VIEW ALL STUDENTS
    public void viewStudents() {
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM students")) {

        	System.out.println("ID🆔||        NAME👩🏿       ||          Email✉️          ||          Course📖       || State🗺     ");
            System.out.println("==============================================================================================================");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + "   || " +
                        rs.getString("name") + " || " +
                        rs.getString("email") + " || " +
                        rs.getString("course")+" || "+
                        rs.getString("state")
                        );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔍 SEARCH STUDENT BY ID
    public void searchStudentById(int id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "SELECT * FROM students WHERE id=?")) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Student Found:");
                System.out.println("ID🆔||        NAME👩🏿       ||          Email✉️          ||         Course📖       || State🗺     ");
                System.out.println("==============================================================================================================");
                System.out.println(
                        rs.getInt("id") + "   || " +
                        rs.getString("name") + " || " +
                        rs.getString("email") + " || " +
                        rs.getString("course")+ " || " +
                        rs.getString("state")
                        );
            } else {
                System.out.println("Student Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✏️ UPDATE STUDENT
    public void updateStudent(int id, String name, String email, String course) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "UPDATE students SET name=?, email=?, course=? WHERE id=?")) {

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student Updated Successfully");
            } else {
                System.out.println("Student ID Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(
                             "DELETE FROM students WHERE id=?")) {

            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Student Deleted");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}