package com.example.watcher;

public class Contacts {
    private String username,image,type;

    public Contacts(String username, String image, String type) {
        this.username = username;
        this.image = image;
        this.type = type;
    }

    public Contacts() {
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
