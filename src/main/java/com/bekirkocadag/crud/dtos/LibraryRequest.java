package com.bekirkocadag.crud.dtos;

import java.io.Serializable;

/**
 * @author H.Bekir Kocadag
 */
public class LibraryRequest implements Serializable{
    private static final long serialVersionUID = 1L;

    private String bookName;
    private String writerName;

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
