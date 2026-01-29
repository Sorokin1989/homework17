package com.example.homework17.Entity.Task2;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private LocalDateTime createdAt;


   @ManyToOne
   @JoinColumn(name = "post_id")
   private Post post;

   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;
}
