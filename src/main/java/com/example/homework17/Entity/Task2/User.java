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

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String passwordHash;
    private LocalDateTime registeredAt;
}
