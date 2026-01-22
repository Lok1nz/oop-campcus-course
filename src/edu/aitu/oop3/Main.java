package edu.aitu.oop3;

import edu.aitu.oop3.db.DatabaseConnection;
import edu.aitu.oop3.db.IDB;
import edu.aitu.oop3.models.Course;
import edu.aitu.oop3.repositories.CourseRepository;
import edu.aitu.oop3.repositories.interfaces.ICourseRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IDB db = new DatabaseConnection();
        ICourseRepository repo = new CourseRepository(db);

        System.out.println("--- All Courses ---");
        List<Course> allCourses = repo.getAll();
        if (allCourses.isEmpty()) {
            System.out.println("No courses found in database.");
        } else {
            for (Course c : allCourses) {
                System.out.println(c);
            }
        }

        System.out.println("\n--- Finding Course #1 ---");
        Course course = repo.getById(1);
        if (course != null) {
            System.out.println("Found: " + course);
        } else {
            System.out.println("Course not found!");
        }
    }
}