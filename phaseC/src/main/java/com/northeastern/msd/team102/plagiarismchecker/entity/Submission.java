package com.northeastern.msd.team102.plagiarismchecker.entity;

import javax.persistence.*;

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "submission_homework_association"))
    private Homework homework;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "user_homework_association"))
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
