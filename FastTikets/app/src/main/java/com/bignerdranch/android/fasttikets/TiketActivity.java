package com.bignerdranch.android.fasttikets;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.UUID;

public class TiketActivity extends FragmentActivity{
    public static final String EXTRA_TIKET_ID =
        "com.bignerdranch.android.fasttikets.tiket_id";

    public static Intent newIntent(Context packageContext, UUID tiketId){
        Intent intent = new Intent(packageContext, TiketActivity.class);
        intent.putExtra(EXTRA_TIKET_ID, tiketId);
        return intent;
    }

    protected Fragment createFragment(){
        return TiketFragment.newInstance();
    }

    @LayoutRes
    protected int getLayoutResId(){
        return R.layout.content_nav;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.container);

        if (fragment == null){
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.container, fragment)
                    .commit();
        }
    }
}
