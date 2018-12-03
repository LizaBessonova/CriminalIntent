package com.bignerdranch.android.supportintent;

import android.support.v4.app.Fragment;

public class SupportListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return new SupportListFragment();
    }
}
