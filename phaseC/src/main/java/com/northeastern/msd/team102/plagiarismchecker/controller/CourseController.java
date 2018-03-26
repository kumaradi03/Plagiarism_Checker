package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.Course;
import com.northeastern.msd.team102.plagiarismchecker.service.CourseService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for Course entity.
 */
@RestController
@RequestMapping("/rest/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    public static final Logger logger = Logger.getLogger(CourseController.class.getName());

    /**
     * findAllHomeworkForUser method returns all the homework for a particular userID.
     * @param userId userId
     * @return returns all the homework for the particular userId.
     */
    @GetMapping("/findAllCoursesForUser")
    public List<Course> findAllCoursesForUser (@RequestParam("userId") String userId) {
        long userID = Long.parseLong(userId);
        return courseService.findAllByUserId(userID);
    }
}
