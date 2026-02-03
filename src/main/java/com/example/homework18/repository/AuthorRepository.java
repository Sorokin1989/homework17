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

    Optional<Author> getAuthorByEmailEqualsIgnoreCase(String email);//1 способ

    @Query(value = "SELECT * FROM authors WHERE LOWER(email) = LOWER(:email)", nativeQuery = true)
        // 2 способ
    Optional<Author> getAuthorByEmailEqualsIgnoreCase2(String email);


//    @Query("select new com.example.homework18.dto.AuthorDto(a.id,a.name,a.surname) from Author a where lower(a.email)=lower(:email)")
//    Optional<AuthorDto> getAuthorByEmailEqualsIgnoreCase3(@Param("email") String email); //3 способ

    // 5.---------------------------------------------------------------------------
    List<Author> getAuthorByEmailEndingWith(String email);// 1 способ


    @Query(value = "SELECT * FROM authors WHERE email LIKE '%' + ?1", nativeQuery = true) // 2 способ
    List<Author> getAuthorByEmailEndingWith2(String email);

//    @Query("select new com.example.homework18.dto.AuthorDto(a.id,a.name,a.surname,a.active) from Author a where a.email LIKE '%' + ?1")
//    List<AuthorDto>getAuthorByEmailEndingWith3(String email);// 3 способ

    // 6.--------------------------------------------------------------------------------

    Long countAuthorByAge(Integer age); // 1 способ

    @Query(value = "SELECT COUNT(*) FROM authors WHERE age = :age",nativeQuery = true)// 2 способ
    Long countAuthorByAge2(Integer age);


    // 7.-----------------------------------------------------------------------------------

//    boolean existsByEmail(String email);// 1 способ


    @Query(value = "SELECT CAST(CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS BIT) " +
            "FROM authors WHERE email = ?1",nativeQuery = true)
    boolean existsByEmail2(String email); // 2 способ

    // 8.------------------------------------------------------------------------------------






}
