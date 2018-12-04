package com.bignerdranch.android.supportintent;

import java.util.Date;
import java.util.UUID;

public class Support {
    private UUID mId;
    private String mResponsible;
    private String mAuthor;
    private String mTheme;
    private String mCategory;
    private String mAuthorMessage;
    private Date mDate;
    private boolean mSolved;

    public String getAuthor() {return mAuthor;}
    public void setAuthor(String author) {mAuthor = author;}

    public Date getDate() {
        return mDate;
    }
    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isSolved() {
        return mSolved;
    }
    public void setSolved(boolean solved) {
        mSolved = solved;
    }

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

    public Support(){
        //generaciya unikal'nogo identifikatora
        mId = UUID.randomUUID();
        mDate = new Date();
    }
}
