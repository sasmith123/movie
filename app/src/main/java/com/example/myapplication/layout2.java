package com.example.myapplication;

public class layout2 {
    private String head1;
    private String desc1;
    private String imageurl1;


    public layout2(String head1, String desc1, String imageurl1) {
        this.head1 = head1;
        this.desc1 = desc1;
        this.imageurl1 = imageurl1;
    }


    public String getHead1() {
        return head1;
    }

    public void setHead1(String head1) {
        this.head1 = head1;
    }

    public String getDesc1() {
        return desc1;
    }

    public void setDesc1(String desc1) {
        this.desc1 = desc1;
    }

    public String getImageurl1() {
        return imageurl1;
    }

    public void setImageurl1(String imageurl1) {
        this.imageurl1 = imageurl1;
    }
}