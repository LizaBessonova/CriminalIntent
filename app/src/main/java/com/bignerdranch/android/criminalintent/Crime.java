package com.bignerdranch.android.criminalintent;

import java.util.UUID;

public class Crime {
    private UUID mId;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    private String mTitle;

    public UUID getId() {
        return mId;
    }

    public Crime(){
        //generaciya unikal'nogo identifikatora
        mId = UUID.randomUUID();
    }
}
