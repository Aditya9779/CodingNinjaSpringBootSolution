package com.PostApplication.SocialMedia;

import java.util.ArrayList;

public class SimplePostList implements PostList {
    private Post post;
    private ArrayList<Post> postList;

    /*Just after the creation its init method is called */
    public void init() {
        Post post1 = new SimplePost();
        post1.setMessage("This message will be come form databases from init method");
        postList.add(post1);
    }
    /*Just before the closing destroy method is called(only for singleton)*/
    public void destroy() {
        System.out.println("Post destroyed");
    }

    /*Imp Always initiliaze*/
    public SimplePostList() {
        this.postList = new ArrayList<Post>();
    }

    @Override
    public ArrayList<Post> getPosts() {
        return this.postList;
    }

    @Override
    public void setPosts(Post post) {
        this.postList.add(post);
    }

    @Override
    public Post getPosts(int index) {
        return postList.get(index);
    }

    @Override
    public int size() {
        return this.postList.size();
    }
}
