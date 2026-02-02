package com.example.homework18.controller;

import com.example.homework18.entity.Author;
import com.example.homework18.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    // ========================================
    // ЗАДАНИЕ 1: Найти автора по ID
    // ========================================
    // Задача: Найти одного автора по его ID
    // Вернуть: Optional<Author>
    // SQL который должен сгенерироваться: SELECT * FROM authors WHERE id = ?
    // Пример использования: findByIdCustom(5L) → найдет автора с id=5

    // Напиши метод здесь:

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> findAuthorById(@PathVariable Long id) {

//        Optional<Author>author=authorRepository.getAuthorById(id);  //1 способ
//        if (author.isPresent())
//      return  new ResponseEntity<>(author,HttpStatus.OK);
//        else
//            return new ResponseEntity<>(Optional.empty(),HttpStatus.NOT_FOUND);
//
        Optional<Author> author = authorRepository.getAuthorById2(id);  //2 способ
        if (author.isPresent())
            return new ResponseEntity<>(author, HttpStatus.OK);
        else
            return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);

//        Optional<AuthorDto>authorDto=authorRepository.getAuthorById3(id);
//        if(authorDto.isPresent()){
//            return new ResponseEntity<>(authorDto,HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(Optional.empty(),HttpStatus.NOT_FOUND);
    }

    // ========================================
    // ЗАДАНИЕ 2: Найти всех активных авторов
    // ========================================
    // Задача: Найти всех авторов где поле active = true
    // Вернуть: List<Author>
    // SQL: SELECT * FROM authors WHERE active = true
    // Пример: findByActiveTrue() → найдет всех активных

    // Напиши метод здесь:

    @GetMapping("/active")
    public ResponseEntity<List<Author>> findAuhtorActive() {
//       List<Author>authors= authorRepository.getAuthorByActive(true); //1 способ
//           return new ResponseEntity<>(authors,HttpStatus.OK);


        List<Author> authors = authorRepository.getAuthorByActive2();//2 способ
        return new ResponseEntity<>(authors, HttpStatus.OK);

//        List<AuthorDto> authors=authorRepository.getAuthorByActive3();
//        return new ResponseEntity<>(authors,HttpStatus.OK); // 3 способ


    }


    // ========================================
    // ЗАДАНИЕ 3: Найти авторов старше определенного возраста
    // ========================================
    // Задача: Найти авторов где age >= заданного значения
    // Параметр: Integer minAge
    // Вернуть: List<Author>
    // SQL: SELECT * FROM authors WHERE age >= ?
    // Пример: findByAgeGreaterThanEqual(25) → все >= 25 лет

    // Напиши метод здесь:

    @GetMapping("/minAge")
    public ResponseEntity<List<Author>> findAuthorMoreMinAge(@RequestParam(defaultValue = "0") Integer minAge) {

//    List<Author> authors=authorRepository.getAuthorByAgeAfter(minAge);
//    return new ResponseEntity<>(authors,HttpStatus.OK); 1 способ

        List<Author> authors = authorRepository.getAuthorByAgeAfter2(minAge);
        return new ResponseEntity<>(authors, HttpStatus.OK); // 2 способ


//        List<AuthorDto>authorDtos=authorRepository.getAuthorByAgeAfter3(minAge);
//        return new ResponseEntity<>(authorDtos,HttpStatus.OK); // 3 способ


    }


    // ========================================
    // ЗАДАНИЕ 4: Найти автора по email (игнорируя регистр)
    // ========================================
    // Задача: Найти автора по email, не учитывая большие/маленькие буквы
    // Параметр: String email
    // Вернуть: Optional<Author>
    // SQL: SELECT * FROM authors WHERE LOWER(email) = LOWER(?)
    // Пример: findByEmailIgnoreCase("JOHN@MAIL.COM") → найдет john@mail.com

    // Напиши метод здесь:

    @GetMapping("/email")
    public ResponseEntity<Optional<Author>> findAuthorByEmail(@RequestParam String email) {
//        Optional<Author>author=authorRepository.getAuthorByEmailEqualsIgnoreCase(email); // 1 способ
//        if (author.isPresent()){
//            return new ResponseEntity<>(author,HttpStatus.OK);
//        }
//        else return new ResponseEntity<>(Optional.empty(),HttpStatus.NOT_FOUND);


        Optional<Author> author = authorRepository.getAuthorByEmailEqualsIgnoreCase2(email);
        if (author.isPresent()) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        } else return new ResponseEntity<>(Optional.empty(), HttpStatus.NOT_FOUND);// 2 способ


//        Optional<AuthorDto>authorDto=authorRepository.getAuthorByEmailEqualsIgnoreCase3(email);
//        if (authorDto.isPresent()){
//            return new ResponseEntity<>(authorDto,HttpStatus.OK);
//        }
//        else
//            return new ResponseEntity<>(Optional.empty(),HttpStatus.NOT_FOUND);// 3 способ
    }


    // ========================================
    // ЗАДАНИЕ 5: Найти авторов, у которых email заканчивается на домен
    // ========================================
    // Задача: Найти всех авторов с email заканчивающимся на определенный текст
    // Параметр: String domain
    // Вернуть: List<Author>
    // SQL: SELECT * FROM authors WHERE email LIKE ?
    // Пример: findByEmailEndingWith("@gmail.com") → все с gmail

    // Напиши метод здесь:


    // ========================================
    // ЗАДАНИЕ 6: Подсчитать количество авторов определенного возраста
    // ========================================
    // Задача: Подсчитать сколько авторов имеют указанный возраст
    // Параметр: Integer age
    // Вернуть: Long (количество)
    // SQL: SELECT COUNT(*) FROM authors WHERE age = ?
    // Пример: countByAge(30) → вернет 5 (если 5 авторов 30 лет)

    // Напиши метод здесь:


    // ========================================
    // ЗАДАНИЕ 7: Проверить существует ли автор с данным email
    // ========================================
    // Задача: Проверить есть ли автор с таким email
    // Параметр: String email
    // Вернуть: boolean (true если существует)
    // SQL: SELECT COUNT(*) > 0 FROM authors WHERE email = ?
    // Пример: existsByEmail("test@mail.com") → true/false

    // Напиши метод здесь:


    // ========================================
    // ЗАДАНИЕ 8: Найти топ-5 самых молодых авторов
    // ========================================
    // Задача: Найти 5 самых молодых авторов (отсортировать по возрасту ASC)
    // Параметров нет
    // Вернуть: List<Author>
    // SQL: SELECT TOP 5 * FROM authors ORDER BY age ASC
    // Пример: findTop5ByOrderByAgeAsc() → 5 самых молодых

    // Напиши метод здесь:


    // ========================================
    // ЗАДАНИЕ 9: Найти авторов по имени ИЛИ фамилии
    // ========================================
    // Задача: Найти авторов где name = X ИЛИ surname = Y
    // Параметры: String name, String surname
    // Вернуть: List<Author>
    // SQL: SELECT * FROM authors WHERE name = ? OR surname = ?
    // Пример: findByNameOrSurname("John", "Smith") → найдет John X или Y Smith

    // Напиши метод здесь:


    // ========================================
    // ЗАДАНИЕ 10: Найти авторов с именем содержащим подстроку (игнорируя регистр)
    // ========================================
    // Задача: Найти авторов где name содержит указанный текст (без учета регистра)
    // Параметр: String namePart
    // Вернуть: List<Author>
    // SQL: SELECT * FROM authors WHERE LOWER(name) LIKE LOWER(?)
    // Пример: findByNameContainingIgnoreCase("john") → найдет "John", "JOHNSON", "johnny"

    // Напиши метод здесь:
}
