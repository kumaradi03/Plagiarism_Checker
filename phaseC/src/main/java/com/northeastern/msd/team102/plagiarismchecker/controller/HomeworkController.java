package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.service.HomeworkService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for Homework entity.
 */
@RestController
@RequestMapping("/rest/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    public static final Logger logger = Logger.getLogger(ReportController.class.getName());

    /**
     * createHomework method creates a new homework for a particular professor.
     * @param homework homework object to be created
     * @param sUserId userId for which the homework is created.
     * @return Homework
     */
    @PostMapping("/create")
    public Homework createHomework(@RequestBody Homework homework, @RequestParam("sUserId") String sUserId) {
        long userId = Long.parseLong(sUserId);
        return homeworkService.createHomework(homework, userId);
    }

    /**
     * findAllHomeworkForUser method returns all the homework for a particular userID.
     * @param sUserId userId
     * @return returns all the homework for the particular userId.
     */
    @GetMapping("/findAllHomeworkForUser")
    public List<Homework> findAllHomeworkForUser (@RequestParam("sUserId") String sUserId) {
        long userId = Long.parseLong(sUserId);
        return homeworkService.findAllByUserId(userId);
    }
}
