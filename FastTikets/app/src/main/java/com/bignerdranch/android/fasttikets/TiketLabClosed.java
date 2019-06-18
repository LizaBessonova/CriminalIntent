package com.bignerdranch.android.fasttikets;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class TiketLabClosed {
    private static TiketLabClosed sTiketLabClosed;
    private List<Tiket> mTikets;

    public static TiketLabClosed get(Context context){
        if (sTiketLabClosed == null) {
            sTiketLabClosed = new TiketLabClosed(context);
        }
        return sTiketLabClosed;
    }

    private TiketLabClosed(Context context){
        mTikets = new ArrayList<>();
        for (int i=0;i<1;i++){
            Tiket tiket = new Tiket();
            tiket.setAuthor("Author "+i);
            tiket.setResponsible("Responsible #"+i);
            tiket.setTheme("Theme #"+i);
            tiket.setCategory("Category #"+i);
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
