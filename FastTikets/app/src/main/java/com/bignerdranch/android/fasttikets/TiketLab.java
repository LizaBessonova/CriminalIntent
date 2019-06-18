package com.bignerdranch.android.fasttikets;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class TiketLab {
    private static TiketLab sTiketLab;
    private List<Tiket> mTikets;

    public static TiketLab get(Context context){
        if (sTiketLab == null) {
            sTiketLab = new TiketLab(context);
        }
        return sTiketLab;
    }

    private TiketLab(Context context){
        mTikets = new ArrayList<>();
        for (int i=0;i<10;i++){
            Tiket tiket = new Tiket();
            tiket.setAuthor("Author "+i);
            tiket.setResponsible("Responsible #"+i);
            tiket.setTheme("Theme #"+i);
            tiket.setCategory("Category #"+i);
            if (i % 2 == 0) tiket.setClosed(false);
            else tiket.setClosed(true);
            mTikets.add(tiket);
        }
    }

    public List<Tiket> getTikets(){
        return mTikets;
    }

    public Tiket getTiket(UUID id){
        for (Tiket tiket : mTikets){
            if (tiket.getId().equals(id)){
                return tiket;
            }
        }
        return null;
    }
}
