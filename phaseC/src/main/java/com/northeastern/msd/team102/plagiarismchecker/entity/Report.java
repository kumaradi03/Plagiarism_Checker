package com.northeastern.msd.team102.plagiarismchecker.entity;
import javax.persistence.*;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "report_user_association"))
    private User user1;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "report1_user_association"))
    private User user2;

    @Column(name = "percentage")
    private double percentage;

    public Report(User user1, User user2, double percentage) {
        this.user1 = user1;
        this.user2 = user2;
        this.percentage = percentage;
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
}
