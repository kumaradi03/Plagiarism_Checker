package com.northeastern.msd.team102.plagiarismchecker.entity;
import javax.persistence.*;

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

    public Report(User user1, User user2, FileUpload fileUpload1, FileUpload fileUpload2, Homework homework, double percentage) {
        this.user1 = user1;
        this.user2 = user2;
        this.fileUpload1 = fileUpload1;
        this.fileUpload2 = fileUpload2;
        this.homework = homework;
        this.percentage = percentage;
    }

    public Report() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public FileUpload getFileUpload1() {
        return fileUpload1;
    }

    public void setFileUpload1(FileUpload fileUpload1) {
        this.fileUpload1 = fileUpload1;
    }

    public FileUpload getFileUpload2() {
        return fileUpload2;
    }

    public void setFileUpload2(FileUpload fileUpload2) {
        this.fileUpload2 = fileUpload2;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }
}
