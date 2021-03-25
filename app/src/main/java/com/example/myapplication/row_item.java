package com.example.myapplication;

public class row_item {
    private String head;
    private String desc;
    private String imageUrl;

    public row_item(String head, String desc,String imageUrl) {
        this.head = head;
        this.desc = desc;
        this.imageUrl= imageUrl;
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
}
