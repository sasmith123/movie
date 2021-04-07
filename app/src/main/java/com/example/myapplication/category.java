package com.example.myapplication;

import java.util.List;

public class category {
    String categoryTitle;
    List<layout2> listitems2;

    public category(String categoryTitle, List<layout2> listitems2) {
        this.listitems2=listitems2;
        this.categoryTitle=categoryTitle;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public List<layout2> getlistitems2() {
        return listitems2;
    }

    public void setlistitems2(List<layout2> listitems2) {
        this.listitems2 = listitems2;
    }
}