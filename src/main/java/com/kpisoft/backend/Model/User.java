package com.kpisoft.backend.Model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User
{
    private long id;
    private long BlogId;
    private String BlogTitle;
    private String BlogBody;

    public User() {

    }

    public User(long BlogId, String BlogTitle, String BlogBody) {
        this.BlogId = BlogId;
        this.BlogTitle = BlogTitle;
        this.BlogBody = BlogBody;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "Blog_Id", nullable = false)
    public long getBlogId() {
        return BlogId;
    }
    public void setBlogId(long BlogId) {
        this.BlogId = BlogId;
    }

    @Column(name = "Blog_Title", nullable = false)
    public String getBlogTitle() {
        return BlogTitle;
    }
    public void setBlogTitle(String BlogTitle) {
        this.BlogTitle = BlogTitle;
    }

    @Column(name = "Blog_Body", nullable = false)
    public String getBlogBody() {
        return BlogBody;
    }
    public void setBlogBody(String BlogBody) {
        this.BlogBody = BlogBody;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", BlogId=" + BlogId + ", BlogTitle=" + BlogTitle + ", BlogBody=" + BlogBody
                + "]";
    }

}

