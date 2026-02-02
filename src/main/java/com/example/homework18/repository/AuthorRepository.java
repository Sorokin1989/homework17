package com.example.homework18.repository;

import com.example.homework18.dto.AuthorDto;
import com.example.homework18.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    // 1. -----------------------------------------------------------------
    Optional<Author> getAuthorById(Long id); //1 способ

    //    @Query(value = "select a from Author a where a.id=:id")
    @Query(value = "select * from authors where id=:id", nativeQuery = true)
//2 способ
    Optional<Author> getAuthorById2(Long id);

    @Query(value = "select new com.example.homework18.dto.AuthorDto(a.id,a.name,a.surname)from Author a where a.id=:id")
    Optional<AuthorDto> getAuthorById3(Long id); //3 способ
    // 2. --------------------------------------------------------------------

    List<Author> getAuthorByActive(boolean active);//1 способ

    @Query(value = "SELECT * FROM authors WHERE active = 1", nativeQuery = true)
//2 способ
    List<Author> getAuthorByActive2();
//    @Query(value = "select new com.example.homework18.dto.AuthorDto(a.id,a.name,a.surname,a.active) from Author a where a.active=true")
//    List<AuthorDto>getAuthorByActive3();//3 способ
    // 3. ---------------------------------------------------------------------------

    List<Author> getAuthorByAgeAfter(Integer age); //1 способ

    @Query(value = "SELECT * FROM authors WHERE age >= :age", nativeQuery = true)
    List<Author> getAuthorByAgeAfter2(@Param("age") Integer age); // 2 способ

//    @Query(value = "select new com.example.homework18.dto.AuthorDto(a.id,a.name,a.surname) from Author a where a.age>=:age")
//    List<AuthorDto>getAuthorByAgeAfter3(Integer age); // 3 способ

    // 4. -----------------------------------------------------------------------


}
