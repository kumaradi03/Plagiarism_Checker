package com.northeastern.msd.team102.plagiarismchecker.repository;

import com.northeastern.msd.team102.plagiarismchecker.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    /**
     * findAllByUserId method finds all courses by specified userId.
     * @param userId
     * @return List of course for the specified userId.
     */
    List<Course> findAllByUserId(long userId);
}
