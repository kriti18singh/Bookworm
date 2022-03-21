package com.bookworm.model;

import java.util.ArrayList;

/*public class VolumeInfo {

    private String mName;
    private String mAuthor;
    private String mDescription;

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}*/

public class VolumeInfo {
    public String title;
    public String subtitle;
    public ArrayList<String> authors;
    public String publisher;
    public String description;
    public ReadingModes readingModes;
    public int pageCount;
    public String printType;
    public ArrayList<String> categories;
    public String maturityRating;
    public boolean allowAnonLogging;
    public String contentVersion;
    public PanelizationSummary panelizationSummary;
    public ImageLinks imageLinks;
    public String language;
    public String previewLink;
    public String infoLink;
    public String canonicalVolumeLink;
    public String publishedDate;
    public ArrayList<IndustryIdentifier> industryIdentifiers;
    public double averageRating;
    public int ratingsCount;
}
