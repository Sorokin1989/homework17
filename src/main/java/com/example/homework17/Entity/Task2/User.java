package com.example.homework17.Entity.Task2;

// Задание 2: Социальная сеть
//Описание предметной области:
//Разработайте модель данных для упрощенной социальной сети.
//Сущности:
//
//User (Пользователь)
//
//id, username, email, passwordHash, registeredAt
//
//
//Profile (Профиль)
//
//id, bio, avatarUrl, birthDate, city, country
//
//
//Post (Пост)
//
//id, content, createdAt, updatedAt, likesCount
//
//
//Comment (Комментарий)
//
//id, text, createdAt, editedAt
//
//
//Friendship (Дружба)
//
//id, requestedAt, acceptedAt, status (PENDING, ACCEPTED, REJECTED)
//
//
//Like (Лайк)
//
//id, createdAt
//
//
//
//Связи:
//
//Пользователь имеет один профиль (и наоборот)
//Пользователь может создать много постов
//Пост принадлежит одному пользователю
//Пост может иметь много комментариев
//Комментарий принадлежит одному посту и одному пользователю
//Пользователь может дружить с другими пользователями (двунаправленная связь)
//Пост может иметь много лайков от разных пользователей
//Пользователь может лайкнуть много постов

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private LocalDateTime registeredAt;

    @OneToOne
    @JoinColumn(name = "profile_id",unique = true)
    private Profile profile;

    @OneToMany(mappedBy = "user")

    private List<Post> posts=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Comment>commentList=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Like>likes=new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Post> getPosts() {
        return posts;
    }


    public List<Comment> getCommentList() {
        return commentList;
    }


    public List<Like> getLikes() {
        return likes;
    }

}
