package com.dlnu.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Objects;

public class Blog {
    private int id;
    private String title;
    private String content;
    private int userId;
    private Timestamp postTime;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", postTime=" + postTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return id == blog.id && userId == blog.userId && Objects.equals(title, blog.title) && Objects.equals(content, blog.content) && Objects.equals(postTime, blog.postTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, userId, postTime);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPostTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(postTime);
    }

    public void setPostTime(Timestamp postTime) {
        this.postTime = postTime;
    }

    public Blog(int id, String title, String content, int userId, Timestamp postTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.postTime = postTime;
    }

    public Blog() {
    }
}
