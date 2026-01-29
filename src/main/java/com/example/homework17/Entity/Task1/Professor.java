package com.example.homework17.Entity.Task1;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private  String firstName;
   private  String lastName;
   private  String email;
   private String department;



   @ManyToOne
   @JoinColumn(name = "faculty_id")
   private Department faculty;

   @OneToOne(mappedBy = "professor")

   private Course course;

    public Professor() {
    }

    public Long getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Department getFaculty() {
        return faculty;
    }

    public void setFaculty(Department faculty) {
        this.faculty = faculty;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
