package com.northeastern.msd.team102.plagiarismchecker.repository;

import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Homework entity.
 */
@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {

    /**
     * findAllByUserId method finds all homework by specified userId.
     * @param userId
     * @return List of homework for the specified userId.
     */
    List<Homework> findAllByUserId(long userId);

    /**
     * findById method returns homework for the given id.
     * @param id
     * @return homework for a given id.
     */
    Homework findById(long id);
}