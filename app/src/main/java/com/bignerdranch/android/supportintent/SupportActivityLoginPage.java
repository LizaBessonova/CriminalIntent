package com.bignerdranch.android.supportintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import java.util.UUID;

public class SupportActivityLoginPage extends SingleFragmentActivity{
    public static Intent newIntent(Context packageContext){
        Intent intent = new Intent(packageContext, SupportActivityLoginPage.class);
        return intent;
    }

    @Override
    protected Fragment createFragment(){
        return new SupportLoginPage();
    }
}
