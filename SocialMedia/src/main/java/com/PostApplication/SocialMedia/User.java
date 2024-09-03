package com.PostApplication.SocialMedia;

public interface User {
    public void setName(String name);

    public String getName();

    public void setPostList(PostList postList);

    public PostList getPostList();
}
