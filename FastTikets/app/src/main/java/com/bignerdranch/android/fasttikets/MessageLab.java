package com.bignerdranch.android.fasttikets;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MessageLab {
    private static MessageLab sMessageLab;
    private List<Tiket> mTikets;

    public static MessageLab get(Context context){
        if (sMessageLab == null) {
            sMessageLab = new MessageLab(context);
        }
        return sMessageLab;
    }
    private MessageLab(Context context){
        mTikets = new ArrayList<>();
        for (int i=0;i<10;i++){
            Tiket tiket = new Tiket();
            tiket.setAuthorMessage("Author Message #"+i);
            mTikets.add(tiket);
        }
    }

    public List<Tiket> getTikets(){
        return mTikets;
    }

}
