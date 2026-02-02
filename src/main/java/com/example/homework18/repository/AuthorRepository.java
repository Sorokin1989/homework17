package com.example.homework18.repository;

import com.example.homework18.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> getAuthorById(Long id); //1 способ

    //    @Query(value = "select a from Author a where a.id=:id")
    @Query(value = "select * from authors where id=:id", nativeQuery = true)
    //2 способ
    Optional<Author> getAuthorById2(@Param("id") Long id);
}
