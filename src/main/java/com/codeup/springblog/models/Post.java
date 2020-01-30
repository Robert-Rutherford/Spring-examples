package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 200)
    private String body;

    @OneToOne
    private PostDetails postDetails;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Post(){
    }

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public Post(long id, String title, String body){
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
