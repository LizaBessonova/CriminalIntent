package com.bignerdranch.android.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mId;
    private String mTitle;
    private String mAuthor;
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

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;
    }

    public Crime(){
        //generaciya unikal'nogo identifikatora
        mId = UUID.randomUUID();
        mDate = new Date();
    }
}
