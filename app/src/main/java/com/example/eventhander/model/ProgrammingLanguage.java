package com.example.eventhander.model;

public class ProgrammingLanguage {
    private String name;
    private int img;
    private String description;

    public ProgrammingLanguage() {
    }

    public ProgrammingLanguage(String name, int img, String description) {
        this.name = name;
        this.img = img;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
