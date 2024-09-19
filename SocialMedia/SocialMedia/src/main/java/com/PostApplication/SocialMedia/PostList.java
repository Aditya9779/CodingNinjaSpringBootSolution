package com.PostApplication.SocialMedia;

import java.util.ArrayList;

public interface PostList {
    public ArrayList<Post> getPosts();
    public void setPosts(Post post);
    public Post getPosts(int index);
    public int size();
}
