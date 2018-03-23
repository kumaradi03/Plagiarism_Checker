package com.northeastern.msd.team102.plagiarismchecker.entity;
import javax.persistence.*;

/**
 * Report entity.
 */
@Entity
public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "report_user1_association"))
    private User user1;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "report_user2_association"))
    private User user2;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "report1_file1_association"))
    private FileUpload fileUpload1;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "report1_file2_association"))
    private FileUpload fileUpload2;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "report1_homework_association"))
    private Homework homework;

    @Column(name = "percentageCompareHashMap")
    private double percentageCompareHashMap;

    @Column(name = "percentageCompareTrees")
    private double percentageCompareTrees;

    @Column(name = "percentageCompareLevenshteinDistance")
    private double percentageCompareLevenshteinDistance;

    @Column(name = "percentageCompareAll")
    private double percentageCompareAll;

    /**
     * Constructor for Report class
     * @param user1 User whose report is to be generated
     * @param user2 User against which  the report is created
     * @param fileUpload1 file for User1
     * @param fileUpload2 file for User1
     * @param homework homework for which report is generated
     * @param percentageCompareHashMap percentage plagiarism for the two files using HashMap.
     * @param percentageCompareTrees percentage plagiarism for the two files using Trees.
     * @param percentageCompareLevenshteinDistance percentage plagiarism for the two files using LevenshteinDistance.
     */
    public Report(User user1, User user2, FileUpload fileUpload1, FileUpload fileUpload2, Homework homework,
                  double percentageCompareHashMap, double percentageCompareTrees,
                  double percentageCompareLevenshteinDistance, double percentageCompareAll) {
        this.user1 = user1;
        this.user2 = user2;
        this.fileUpload1 = fileUpload1;
        this.fileUpload2 = fileUpload2;
        this.homework = homework;
        this.percentageCompareHashMap = percentageCompareHashMap;
        this.percentageCompareTrees = percentageCompareTrees;
        this.percentageCompareLevenshteinDistance = percentageCompareLevenshteinDistance;
        this.percentageCompareAll = percentageCompareAll;
    }

    /**
     * Default constructor
     */
    public Report() {

    }

    /**
     * Getter for reportId.
     * @return returns the Id of the generated report.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for reportId.
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter for User whose report is to be generated.
     * @return User object
     */
    public User getUser1() {
        return user1;
    }

    /**
     * Setter for User whose report is to be generated.
     * @param user1
     */
    public void setUser1(User user1) {
        this.user1 = user1;
    }

    /**
     * Getter for User against which  the report is created.
     * @return User object
     */
    public User getUser2() {
        return user2;
    }

    /**
     * Setter for User against which  the report is created.
     * @param user2
     */
    public void setUser2(User user2) {
        this.user2 = user2;
    }

    /**
     * Getter for plagiarism percentage for the two files.
     * @return double percentage.
     */
    public double getPercentageCompareHashMap() {
        return percentageCompareHashMap;
    }

    /**
     * Setter for plagiarism percentage for the two files.
     * @param percentageCompareHashMap
     */
    public void setPercentageCompareHashMap(double percentageCompareHashMap) {
        this.percentageCompareHashMap = percentageCompareHashMap;
    }

    /**
     * Getter for plagiarism percentage for the two files.
     * @return double percentage.
     */
    public double getpercentageCompareTrees() {
        return percentageCompareTrees;
    }

    /**
     * Setter for plagiarism percentage for the two files.
     * @param percentageCompareTrees
     */
    public void setpercentageCompareTrees (double percentageCompareTrees) {
        this.percentageCompareTrees = percentageCompareTrees;
    }

    /**
     * Getter for plagiarism percentage for the two files.
     * @return double percentage.
     */
    public double getpercentageCompareLevenshteinDistance() {
        return percentageCompareLevenshteinDistance;
    }

    /**
     * Setter for plagiarism percentage for the two files.
     * @param percentageCompareLevenshteinDistance
     */
    public void setpercentageCompareLevenshteinDistancep (double percentageCompareLevenshteinDistance) {
        this.percentageCompareLevenshteinDistance = percentageCompareLevenshteinDistance;
    }

    /**
     * Getter for plagiarism percentage for the two files.
     * @return double percentage.
     */
    public double getPercentageCompareAll() {
        return percentageCompareAll;
    }

    /**
     * Setter for plagiarism percentage for the two files.
     * @param percentageCompareAll
     */
    public void setPercentageCompareAll(double percentageCompareAll) {
        this.percentageCompareAll = percentageCompareAll;
    }

    /**
     * Getter for file for User1.
     * @return file for user1.
     */
    public FileUpload getFileUpload1() {
        return fileUpload1;
    }

    /**
     * Setter for file for User1.
     * @param fileUpload1
     */
    public void setFileUpload1(FileUpload fileUpload1) {
        this.fileUpload1 = fileUpload1;
    }

    /**
     * Getter for file for User2.
     * @return file for user2.
     */
    public FileUpload getFileUpload2() {
        return fileUpload2;
    }

    /**
     * Setter for file for User2.
     * @param fileUpload2
     */
    public void setFileUpload2(FileUpload fileUpload2) {
        this.fileUpload2 = fileUpload2;
    }

    /**
     * Getter for homework for which report is generated.
     * @return homework for which the particular report is generated.
     */
    public Homework getHomework() {
        return homework;
    }

    /**
     * Setter for homework for which report is generated.
     * @param homework
     */
    public void setHomework(Homework homework) {
        this.homework = homework;
    }
}
