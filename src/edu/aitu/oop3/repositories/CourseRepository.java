package edu.aitu.oop3.repositories;
import edu.aitu.oop3.models.Course;
import edu.aitu.oop3.db.IDB;
import edu.aitu.oop3.repositories.interfaces.ICourseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements ICourseRepository {
    private final IDB db;

    public CourseRepository(IDB db) {
        this.db = db;
    }

    @Override
    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();
        String sql = "SELECT id, title, instructor, credits FROM courses";

        try (Connection conn = db.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                courses.add(new Course(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("instructor"),
                        rs.getInt("credits")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при получении курсов: " + e.getMessage());
        }
        return courses;
    }

    @Override
    public Course getById(int id) {
        return null;
    }
}