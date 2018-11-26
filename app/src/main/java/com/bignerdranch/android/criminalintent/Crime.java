package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mResponsible;
    private String mAuthor;
    private String mTheme;
    private String mCategory;
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

    public UUID getId() {
        return mId;
    }

    public Crime(){
        //generaciya unikal'nogo identifikatora
        mId = UUID.randomUUID();
        mDate = new Date();
    }
}
