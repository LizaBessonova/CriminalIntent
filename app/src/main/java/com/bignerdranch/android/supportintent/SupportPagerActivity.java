package com.bignerdranch.android.supportintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class SupportPagerActivity extends AppCompatActivity {
    private static final String EXTRA_SUPPORT_ID =
            "com.bignerdranch.android.supportintent.support_id";

    private ViewPager mViewPager;
    private List<Support> mSupports;


    public static Intent newIntent(Context packageContext, UUID supportId){
        Intent intent = new Intent(packageContext, SupportPagerActivity.class);
        intent.putExtra(EXTRA_SUPPORT_ID, supportId);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_pager);

        UUID supportId = (UUID) getIntent()
                .getSerializableExtra(EXTRA_SUPPORT_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_support_pager_view_pager);

        mSupports = SupportLab.get(this).getSupports();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Support support = mSupports.get(position);
                return SupportFragment.newInstance(support.getId());
            }

            @Override
            public int getCount() {
                return mSupports.size();
            }
        });

        for (int i=0;i<mSupports.size();i++){
            if (mSupports.get(i).getId().equals(supportId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
