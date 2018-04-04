package com.northeastern.msd.team102.plagiarismchecker.service;
import com.northeastern.msd.team102.plagiarismchecker.entity.*;
import com.northeastern.msd.team102.plagiarismchecker.repository.UsageStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import java.util.Date;
import java.util.List;

/**
 * Service class for UserStatistics entity.
 */
@Component
public class UsageStatisticsService {

    @Autowired
    private UsageStatisticsRepository usageStatisticsRepository;

    public static final Logger logger = Logger.getLogger(UsageStatisticsService.class.getName());

    /**
     * inserting Usage statistics data
     * @param usageStatistics
     */
    public void createUserStatistics(UsageStatistics usageStatistics) {
        logger.log(Level.INFO, "Saving user statistics for Professor: " + usageStatistics.getProfessor().getUsername()
        + " for Student: " + usageStatistics.getStudent().getUsername()
        + " for Course: " + usageStatistics.getCourse().getName()
        + " for Homework: " + usageStatistics.getHomework().getName());
        usageStatisticsRepository.save(usageStatistics);
    }

    public void generateStatistics(Date timestamp, User professor, User student, Course course,
                               Homework homework, double compareCount, String algoType) {
        logger.log(Level.INFO, "Generating usage statistics for " + professor.getUsername());
        UsageStatistics userStats = new UsageStatistics(timestamp, professor, student, course, homework, compareCount, algoType);
        createUserStatistics(userStats);
    }

    public List<UsageStatistics> findAllUsageStatisticsByProfessor(long userId) {
        logger.log(Level.INFO, "Returning all usage statistics summary for userid: " + userId);
        return usageStatisticsRepository.findAllByProfessor_Id(userId);
    }

}