package edu.aitu.oop3.factories;

import edu.aitu.oop3.models.Student;
import edu.aitu.oop3.models.Course;

public class EntityFactory {

    public static Student createStudent(String name, String email) {
        return new Student(0, name, email);
    }

    public static Course createCourse(String title, String instructor, int credits) {
        return new Course.Builder()
                .setTitle(title)
                .setInstructor(instructor)
                .setCredits(credits)
                .build();
    }
}