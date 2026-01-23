package edu.aitu.oop3.repositories.interfaces;

import edu.aitu.oop3.models.Registration;
import java.util.List;

public interface IRegistrationRepository {
    boolean registerStudent(int studentId, int courseId);
    List<Registration> getAll();
    int getStudentCountByCourseId(int courseId);
    void deleteRegistration(int studentId, int courseId);
}