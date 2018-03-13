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
    @JoinColumn(foreignKey = @ForeignKey(name = "fileupload_submission_association"))
    private Submission submission;

    public FileUpload (String filename, byte[] file, String mimeType) {
        this.file = file;
        this.filename = filename;
        this.mimeType = mimeType;
    }

    public FileUpload() {
        // Default Constructor
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
