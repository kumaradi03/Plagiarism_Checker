package com.northeastern.msd.team102.plagiarismchecker.repository;


import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u WHERE u.username = ?1 and u.password = ?2")
    User findUserByCredentials(String username, String password);

    @Query("SELECT u from User u WHERE u.username = ?1")
    User findUserByUsername(String username);

    @Query("SELECT u from User u WHERE u.id = ?1")
    User findUserByUserId(long userId);

}

