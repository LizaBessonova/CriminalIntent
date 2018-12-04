package com.bignerdranch.android.supportintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SupportLab {
    private static SupportLab sSupportLab;
    private List<Support> mSupports;

    public static SupportLab get(Context context){
        if (sSupportLab == null) {
            sSupportLab = new SupportLab(context);
        }
        return sSupportLab;
    }
    private SupportLab(Context context){
        mSupports = new ArrayList<>();
        for (int i=0;i<10;i++){
            Support support = new Support();
            support.setAuthor("Author "+i);
            support.setAuthorMessage("Author Message "+i);
            support.setResponsible("Responsible #"+i);
            support.setTheme("Theme #"+i);
            support.setCategory("Category #"+i);
            support.setSolved(i%2==0);
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
