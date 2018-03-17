package com.northeastern.msd.team102.plagiarismchecker.entity;

import javax.persistence.*;

@Entity
public class FileUpload {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "filename")
    private String filename;
    @Column(name = "file")
    @Lob
    private byte[] file;
    @Column(name = "mimeType")
    private String mimeType;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fileUpload_homework_association"))
    private Homework homework;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "user_homework_association"))
    private User user;


    public FileUpload (String filename, byte[] file, String mimeType) {
        this.file = file;
        this.filename = filename;
        this.mimeType = mimeType;
    }

    public FileUpload() {
        // Default Constructor
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
