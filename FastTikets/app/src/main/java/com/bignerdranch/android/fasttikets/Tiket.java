package com.bignerdranch.android.fasttikets;

import java.util.UUID;

public class Tiket {
    private UUID mId;
    private String mResponsible;
    private String mAuthor;
    private String mTheme;
    private String mCategory;
    private String mAuthorMessage;

    public String getAuthor() {return mAuthor;}
    public void setAuthor(String author) {mAuthor = author;}

    public String getResponsible() {
        return mResponsible;
    }
    public void setResponsible(String responsible) {
        mResponsible = responsible;
    }

    public String getTheme() { return mTheme; }
    public void setTheme(String theme) { mTheme = theme; }

    public String getCategory() { return mCategory; }
    public void setCategory(String category) { mCategory = category; }

    public String getAuthorMessage() { return mAuthorMessage; }
    public void setAuthorMessage(String authorMessage) { mAuthorMessage = authorMessage; }

    public UUID getId() {
        return mId;
    }

    public Tiket(){
        //generaciya unikal'nogo identifikatora
        mId = UUID.randomUUID();
    }
}
