package com.recSystem.Entity.DO;

public class Author {
    private int authorId;
    private String authorName;

    public Author(int author_id, String author_name) {
        this.authorId = author_id;
        this.authorName = author_name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
