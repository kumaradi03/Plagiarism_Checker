package com.northeastern.msd.team102.plagiarismchecker.repository;

import com.northeastern.msd.team102.plagiarismchecker.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
