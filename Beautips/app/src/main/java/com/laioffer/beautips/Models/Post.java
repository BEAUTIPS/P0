package com.laioffer.beautips.Models;

import java.util.Objects;

public class Post {

    String ownerId;
    String imageName;
    String postId;
    int numOfLikes;
    String imageUrl;
    String timeStamp;
    String pofileImageUrl;

//    public Post(String imageUrl){
//        this.imageUrl = imageUrl;
//    }

    public Post(String imageName){
        this.imageName = imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setPofileImageUrl(String pofileImageUrl) {
        this.pofileImageUrl = pofileImageUrl;
    }

    public String getPofileImageUrl() {
        return pofileImageUrl;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getPostId() {
        return postId;
    }

    public int getNumOfLikes() {
        return numOfLikes;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setNumOfLikes(int numOfLikes) {
        this.numOfLikes = numOfLikes;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "ownerId='" + ownerId + '\'' +
                ", postId='" + postId + '\'' +
                ", numOfLikes=" + numOfLikes +
                ", imageUrl='" + imageUrl + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return numOfLikes == post.numOfLikes &&
                Objects.equals(ownerId, post.ownerId) &&
                Objects.equals(postId, post.postId) &&
                Objects.equals(imageUrl, post.imageUrl) &&
                Objects.equals(timeStamp, post.timeStamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerId, postId, numOfLikes, imageUrl, timeStamp);
    }
}


