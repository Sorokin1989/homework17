package com.example.homework17.Entity.Task1;

//Задание 1: Система управления университетом
//Описание предметной области:
//Создайте систему для управления университетом со следующими сущностями:
//Сущности:
//
//Student (Студент)
//
//id, firstName, lastName, email, enrollmentDate
//
//
//Course (Курс)
//
//id, name, credits, description
//
//
//Professor (Профессор)
//
//id, firstName, lastName, email, department
//
//
//Enrollment (Запись на курс)
//
//id, enrollmentDate, grade, status
//Дополнительная информация: attendance (посещаемость), midtermScore, finalScore
//
//
//Department (Факультет)
//
//id, name, building, budget
//
//
//
//Связи:
//
//Один студент может записаться на много курсов (через Enrollment)
//Один курс может иметь много студентов (через Enrollment)
//Один профессор принадлежит одному факультету
//Один факультет имеет много профессоров
//Один курс ведет один профессор
//
//Требования:
//Часть 1: Определение связей
//
//Определите все связи (OneToOne, OneToMany, ManyToOne, ManyToMany)
//Укажите, где использовать промежуточную сущность Enrollment вместо прямой ManyToMany
//Определите владеющую и обратную сторону для каждой связи
//Укажите, где нужны unique = true для OneToOne связей






public class Student {
}
