package com.northeastern.msd.team102.plagiarismchecker.repository;


import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.id,u.name,u.password,u.username FROM user u WHERE u.username = ?1 AND u.password= ?2")
    User findUserByCredentials(String username, String password);
}

