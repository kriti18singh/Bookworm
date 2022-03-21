package com.bookworm.model;

import java.util.ArrayList;
import java.util.List;

public class PopularCategory {
    private String mCategory;

    private List<VolumeInfo> mList;

    public PopularCategory(String mCategory) {
        this.mCategory = mCategory;
        mList = new ArrayList<>();
    }

    public String getCategory() {
        return mCategory;
    }

    public void setCategory(String mCategory) {
        this.mCategory = mCategory;
    }

    public List<VolumeInfo> getmList() {
        return mList;
    }

    public void setmList(List<VolumeInfo> mList) {
        this.mList = mList;
    }
}
