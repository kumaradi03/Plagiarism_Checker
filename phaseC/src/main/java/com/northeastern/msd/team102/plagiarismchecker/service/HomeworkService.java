package com.northeastern.msd.team102.plagiarismchecker.service;

import com.northeastern.msd.team102.plagiarismchecker.entity.Homework;
import com.northeastern.msd.team102.plagiarismchecker.entity.User;
import com.northeastern.msd.team102.plagiarismchecker.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Autowired
    private UserService userService;

    public Homework createHomework(Homework homework, long userId)
    {
        User user = userService.findUserByUserId(userId);
        homework.setUser(user);
        return homeworkRepository.save(homework);
    }

    public List<Homework> findAllByUserId(long userId) {
        return homeworkRepository.findAllByUserId(userId);
    }
}
