package com.northeastern.msd.team102.plagiarismchecker.repository;

import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long>{
    List<Homework> findAllByUserId(long userId);
}