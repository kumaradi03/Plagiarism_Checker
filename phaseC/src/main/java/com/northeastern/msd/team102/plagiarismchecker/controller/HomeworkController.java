package com.northeastern.msd.team102.plagiarismchecker.controller;

import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/homework")
public class HomeworkController {

    @Autowired
    private HomeworkService homeworkService;

    @PostMapping("/create")
    public Homework createHomework(@RequestBody Homework homework, @RequestParam long userId) {
        return homeworkService.createHomework(homework, userId);
    }

    @GetMapping("/findAllHomeworkForUser")
    public List<Homework> findAllHomeworkForUser (@RequestParam long userId) {
        return homeworkService.findAllByUserId(userId);
    }
}
