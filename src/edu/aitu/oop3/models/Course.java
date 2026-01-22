package edu.aitu.oop3.models;

public class Course {
    private int id;
    private String title;
    private String instructor;
    private int credits;
    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public int getCredits() { return credits; }
    public Course(int id, String title, String instructor, int credits) {
        this.id = id;
        this.title = title;
        this.instructor = instructor;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{id=" + id + ", title='" + title + "', instructor='" + instructor + "'}";
    }
}
