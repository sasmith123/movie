package com.example.myapplication;

public class row_item {
    private String head;
    private String desc;
    private String imageUrl;
    private String desc1;
    private String date;


    public row_item(String head, String desc, String imageUrl,String desc1,String date) {
        this.head = head;
        this.desc = desc;
        this.imageUrl= imageUrl;
        this.desc1=desc1;
        this.date=date;
    }

    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDesc1() {
        return desc1;
    }

    public String getDate() {
        return date;
    }
}
