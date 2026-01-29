package com.example.homework17.Entity.Task1;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate enrollmentDate;
    private Integer grade;
    private String status;

    private Double attendance;
    private Integer midtermScore;
    private Integer finalScore;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment() {
    }

    public Long getId() {
        return id;
    }


    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getAttendance() {
        return attendance;
    }

    public void setAttendance(Double attendance) {
        this.attendance = attendance;
    }

    public Integer getMidtermScore() {
        return midtermScore;
    }

    public void setMidtermScore(Integer midtermScore) {
        this.midtermScore = midtermScore;
    }

    public Integer getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(Integer finalScore) {
        this.finalScore = finalScore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
