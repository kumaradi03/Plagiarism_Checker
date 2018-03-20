package com.northeastern.msd.team102.plagiarismchecker.repository;

import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Report entity.
 */
@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    /**
     * findAllByHomeworkIdAndUser1Id method returns all reports for specified homework id and user id.
     * @param hwId homework Id
     * @param userId user Id
     * @return List of reports.
     */
    List<Report> findAllByHomeworkIdAndUser1Id(long hwId, long userId);
}
