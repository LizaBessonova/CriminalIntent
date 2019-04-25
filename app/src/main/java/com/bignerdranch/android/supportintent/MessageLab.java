package com.bignerdranch.android.supportintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageLab {
    private static MessageLab sMessageLab;
    private List<Support> mSupports;

    public static MessageLab get(Context context){
        if (sMessageLab == null) {
            sMessageLab = new MessageLab(context);
        }
        return sMessageLab;
    }
    private MessageLab(Context context){
        mSupports = new ArrayList<>();
        for (int i=0;i<4;i++){
            Support support = new Support();
            support.setAuthorMessage("Author Message "+i);
            mSupports.add(support);
        }
    }

    public List<Support> getSupports(){
        return mSupports;
    }

    public Support getSupport(UUID id){
        for (Support support : mSupports){
            if (support.getId().equals(id)){
                return support;
            }
        }
        return null;
    }
}
