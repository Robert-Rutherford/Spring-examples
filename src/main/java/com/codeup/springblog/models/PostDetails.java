package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "postsDetails")
public class PostDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
    private long id;

    private boolean isAwesome;


    @Column(columnDefinition = "TEXT")
    private String historyOfPost;

    @Column(nullable = false)
    private String topicDescription;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private List<PostImage> postImages;

    public PostDetails(){}

//    public List<PostImage> getPostImages() {
//        return postImages;
//    }
//
//    public void setPostImages(List<PostImage> postImages) {
//        this.postImages = postImages;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isAwesome() {
        return isAwesome;
    }

    public void setAwesome(boolean awesome) {
        isAwesome = awesome;
    }

    public String getHistoryOfPost() {
        return historyOfPost;
    }

    public void setHistoryOfPost(String historyOfPost) {
        this.historyOfPost = historyOfPost;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }
}
