package com.bookworm.model;

import java.util.ArrayList;
import java.util.List;

public class PopularCategory {
    private String mCategory;

    private List<VolumeInfo> mList;

    public PopularCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public PopularCategory(String mCategory, List<VolumeInfo> list) {
        this.mCategory = mCategory;
        mList = list;
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public List<VolumeInfo> getList() {
        return mList;
    }

    public void setList(List<VolumeInfo> mList) {
        this.mList = mList;
    }
}
