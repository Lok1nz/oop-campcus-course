package edu.aitu.oop3.repositories;

import edu.aitu.oop3.db.IDB;
import edu.aitu.oop3.models.Registration;
import edu.aitu.oop3.repositories.interfaces.IRegistrationRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationRepository implements IRegistrationRepository {
    private final IDB db;

    public RegistrationRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean registerStudent(int studentId, int courseId) {
        String sql = "INSERT INTO registrations(student_id, course_id) VALUES(?, ?)";
        try (Connection conn = db.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, studentId);
            st.setInt(2, courseId);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Registration> getAll() {
        List<Registration> registrations = new ArrayList<>();
        String sql = "SELECT id, student_id, course_id, registration_date FROM registrations";
        try (Connection conn = db.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                registrations.add(new Registration(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getInt("course_id"),
                        rs.getTimestamp("registration_date")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return registrations;
    }

    @Override
    public int getStudentCountByCourseId(int courseId) {
        String sql = "SELECT COUNT(*) FROM registrations WHERE course_id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, courseId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return 0;
    }

    @Override
    public void deleteRegistration(int studentId, int courseId) {
        String sql = "DELETE FROM registrations WHERE student_id = ? AND course_id = ?";
        try (Connection conn = db.getConnection();
             PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, studentId);
            st.setInt(2, courseId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}