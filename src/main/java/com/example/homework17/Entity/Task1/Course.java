package com.example.homework17.Entity.Task1;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double credits;
    private String description;

    @OneToMany(mappedBy = "course")

     private List<Enrollment> enrollments;

    @OneToOne
    @JoinColumn(name = "professor_id",unique = true)
    private Professor professor;

    public Course() {
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCredits() {
        return credits;
    }

    public void setCredits(Double credits) {
        this.credits = credits;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Enrollment> getEnrollments() {
        return enrollments;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
