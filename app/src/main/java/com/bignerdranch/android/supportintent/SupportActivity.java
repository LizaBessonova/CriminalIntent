package com.bignerdranch.android.supportintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class SupportActivity extends SingleFragmentActivity {
    private static final String EXTRA_SUPPORT_ID =
            "com.bignerdranch.android.criminalintent.support_id";

    public static Intent newIntent(Context packageContext, UUID supportId){
        Intent intent = new Intent(packageContext, SupportActivity.class);
        intent.putExtra(EXTRA_SUPPORT_ID, supportId);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        UUID supportId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_SUPPORT_ID);
        return SupportFragment.newInstance(supportId);
    }
}
