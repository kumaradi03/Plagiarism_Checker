package com.northeastern.msd.team102.plagiarismchecker.entity;

import javax.persistence.*;

/**
 * Homework entity.
 */
@Entity
public class Homework {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "homework_user_association"))
    private User user;

    /**
     * Constructor for Homework class
     */
    public Homework() {
        //Default Constructor
    }

    /**
     * Getter for HoemworkId
     * @return the hwId.
     */
    public long getId() {
        return id;
    }

    /**
     * Getter for User who created the homework.
     * @return User object
     */
    public User getUser() {
        return user;
    }

    /**
     * Setter for User.
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Getter for fetching the name of the homework
     * @return name of the homework
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for setting the name of the homework
     * @param name name of the homework to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for homework description
     * @return returns the homework description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for homework description
     * @param description homework description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}

