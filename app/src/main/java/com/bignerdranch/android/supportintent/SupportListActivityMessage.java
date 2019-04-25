package com.bignerdranch.android.supportintent;

import android.support.v4.app.Fragment;

public class SupportListActivityMessage extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new SupportListFragmentMessage();
    }
}