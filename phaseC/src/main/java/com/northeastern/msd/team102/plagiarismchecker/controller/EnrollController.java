package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.Enroll;
import com.northeastern.msd.team102.plagiarismchecker.service.EnrollService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for Enroll entity.
 */
@RestController
@RequestMapping("/rest/enroll")
public class EnrollController {

    @Autowired
    private EnrollService enrollService;

    public static final Logger logger = Logger.getLogger(EnrollController.class.getName());

    /**
     * findAllCoursesForUser method returns all the course for a particular userID.
     * @param userId userId
     * @return returns all the course for the particular userId.
     */
    @GetMapping("/findAllEnrollmentForUser")
    public List<Enroll> findAllEnrollmentForUser (@RequestParam("userId") String userId) {
        long userID = Long.parseLong(userId);
        return enrollService.findAllByUserId(userID);
    }
}
