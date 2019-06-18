package com.bignerdranch.android.fasttikets;

import android.content.Context;
import android.content.Intent;

import java.util.UUID;

public class TiketActivity {
    public static final String EXTRA_TIKET_ID =
        "com.bignerdranch.android.fasttikets.tiket_id";

    public static Intent newIntent(Context packageContext, UUID tiketId){
        Intent intent = new Intent(packageContext, TiketActivity.class);
        intent.putExtra(EXTRA_TIKET_ID, tiketId);
        return intent;
    }

    protected TiketFragment createFragment(){return new TiketFragment();}
}
