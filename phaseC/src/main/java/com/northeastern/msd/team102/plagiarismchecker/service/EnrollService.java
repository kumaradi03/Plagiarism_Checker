package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.Enroll;
import com.northeastern.msd.team102.plagiarismchecker.repository.EnrollRepository;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Service class for Enroll entity.
 */
@Component
public class EnrollService {

    @Autowired
    private EnrollRepository enrollRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    public static final Logger logger = Logger.getLogger(EnrollService.class.getName());

    /**
     * findAllByUserId method returns list of enrollments for a given user.
     * @param userId
     * @return List of Enroll
     */
    public List<Enroll> findAllByUserId(long userId) {
        logger.log(Level.INFO, "Returns all courses for userId: " + userId);
        return enrollRepository.findAllByUserId(userId);
    }
}
