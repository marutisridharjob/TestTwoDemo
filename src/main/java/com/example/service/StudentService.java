package com.example.service;

import com.example.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        // Add some dummy data
        students.add(new Student("John", "Doe", 20, "123 Main St", "Springfield", "IL", "62704"));
        students.add(new Student("Jane", "Smith", 22, "456 Oak St", "Chicago", "IL", "60616"));
    }

    public List<Student> getStudents() {
        return students;
    }

    public Optional<Student> getStudentById(int id) {
        return id < students.size() ? Optional.of(students.get(id)) : Optional.empty();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(int id, Student student) {
        if (id < students.size()) {
            students.set(id, student);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        if (id < students.size()) {
            students.remove(id);
            return true;
        }
        return false;
    }
}