package com.PostApplication.SocialMedia;

public class SimplePost implements Post{
    private String message;
    @Override
    public void setMessage(String message) {
        this.message = message;
    }
  public void init(){
        System.out.println("SimplePost init");
  }

    @Override
    public String getMessage() {
        return this.message;
    }
}
