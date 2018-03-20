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

    @Column(name = "percentage")
    private double percentage;

    /**
     * Constructor for Report class
     * @param user1 User whose report is to be generated
     * @param user2 User against which  the report is created
     * @param fileUpload1 file for User1
     * @param fileUpload2 file for User1
     * @param homework homework for which report is generated
     * @param percentage percentage plagiarism for the two files
     */
    public Report(User user1, User user2, FileUpload fileUpload1, FileUpload fileUpload2, Homework homework, double percentage) {
        this.user1 = user1;
        this.user2 = user2;
        this.fileUpload1 = fileUpload1;
        this.fileUpload2 = fileUpload2;
        this.homework = homework;
        this.percentage = percentage;
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
    public double getPercentage() {
        return percentage;
    }

    /**
     * Setter for plagiarism percentage for the two files.
     * @param percentage
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
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
