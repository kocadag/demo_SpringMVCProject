package com.bekirkocadag.crud.models;

import javax.persistence.*;

/**
 * @author H.Bekir Kocadag
 */
@Entity
@Table(name = "library", schema = "library")
public class LibraryModel {

    public LibraryModel() {
    }

    public LibraryModel(long id, String bookName, String writerName) {
        this.id = id;
        this.bookName = bookName;
        this.writerName = writerName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String bookName;

    @Column(nullable = false)
    private String writerName;

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
}
