package com.PostApplication.SocialMedia;

public class Customer implements User {
    private String name;
    PostList postList;

    @Override
    public void setName(String name) {
        this.name = name;
    }
    public void init(){
        System.out.println("Customer init");
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setPostList(PostList postList) {
        this.postList = postList;
    }

    @Override
    public PostList getPostList() {
        return this.postList;
    }
}
