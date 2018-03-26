package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.Course;
import com.northeastern.msd.team102.plagiarismchecker.repository.CourseRepository;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service class for Course entity.
 */
@Component
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private UserService userService;

    public static final Logger logger = Logger.getLogger(CourseService.class.getName());

    /**
     * findAllByUserId method returns list of Homework for a given user.
     * @param userId
     * @return List of Homework
     */
    public List<Course> findAllByUserId(long userId) {

        logger.log(Level.INFO, "Returning all homeworks for userId: " + userId);
        return courseRepository.findAllByUserId(userId);
    }
}
