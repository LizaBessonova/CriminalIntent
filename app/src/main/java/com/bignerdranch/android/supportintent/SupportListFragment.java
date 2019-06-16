package com.bignerdranch.android.supportintent;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class SupportListFragment extends Fragment {
    private static final int REQUEST_SUPPORT = 1;

    private static final String SAVED_SUBTITLE_VISIBLE = "subtitle";
    private RecyclerView mSupportRecyclerView;
    private SupportAdapter mAdapter;
    private boolean mSubtitleVisible;

    private TextView mAuthorTextWiew;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu,inflater);
        inflater.inflate(R.menu.fragment_support_list, menu);

        MenuItem subtitleItem = menu.findItem(R.id.menu_item_show_subtitle);
        if (mSubtitleVisible){
            subtitleItem.setTitle(R.string.hide_subtitle);
        } else {
            subtitleItem.setTitle(R.string.show_subtitle);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_item_new_support:
                Support support = new Support();
                SupportLab.get(getActivity()).addSupport(support);
                Intent intent = SupportPagerActivity
                        .newIntent(getActivity(), support.getId());
                startActivity(intent);
                return true;
            case R.id.menu_item_show_subtitle:
                mSubtitleVisible = !mSubtitleVisible;
                getActivity().invalidateOptionsMenu();
                updateSubtitle();
                return true;
             default:
                 return super.onOptionsItemSelected(item);
        }
    }

    private void updateSubtitle(){
        SupportLab supportLab = SupportLab.get(getActivity());
        int supportCount = supportLab.getSupports().size();
        String subtitle = getString(R.string.subtitle_format, supportCount);

        if (!mSubtitleVisible){
            subtitle = null;
        }

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.getSupportActionBar().setSubtitle(subtitle);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_support_list,container,false);

        mSupportRecyclerView = (RecyclerView)v
                .findViewById(R.id.support_recycler_view);
        mSupportRecyclerView.setLayoutManager(new LinearLayoutManager
                (getActivity()));;

        if (savedInstanceState != null){
            mSubtitleVisible = savedInstanceState.getBoolean
                    (SAVED_SUBTITLE_VISIBLE);
        }
        updateUI();
        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean(SAVED_SUBTITLE_VISIBLE, mSubtitleVisible);
    }

    private void updateUI(){
        SupportLab supportLab = SupportLab.get(getActivity());
        List<Support> supports = supportLab.getSupports();
        mAdapter = new SupportAdapter(supports);
        mSupportRecyclerView.setAdapter(mAdapter);
        

        if (mAdapter == null){
            mAdapter = new SupportAdapter(supports);
            mSupportRecyclerView.setAdapter(mAdapter);
        } else {
            //mAdapter.setSupports(supports);
            //mAdapter.notifyItemChanged();
        }

        //updateSubtitle();
    }

    public  class SupportHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mResponsibleTextView;
        private TextView mAuthorTextView;
        private TextView mThemeTextView;
        private TextView mCategoryTextView;
        private CheckBox mSolvedCheckBox;
        private Support mSupport;

        public void bindSupport(Support support){
            mSupport = support;
            mResponsibleTextView.setText(mSupport.getResponsible());
            mAuthorTextView.setText(mSupport.getAuthor());
            mThemeTextView.setText(mSupport.getTheme());
            mCategoryTextView.setText(mSupport.getCategory());
            mSolvedCheckBox.setChecked(mSupport.isSolved());
        }

        public SupportHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mResponsibleTextView = (TextView) itemView.findViewById(R.id.list_item_support_responsible_text_view);
            mAuthorTextView = (TextView) itemView.findViewById(R.id.list_item_support_author_text_view);
            mThemeTextView = (TextView) itemView.findViewById(R.id.list_item_support_theme_text_view);
            mCategoryTextView = (TextView) itemView.findViewById(R.id.list_item_support_category_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_support_solved_check_box);
        }
        @Override
        public void onClick(View v){
            Intent intent = SupportPagerActivity.newIntent(getActivity(),
                    mSupport.getId());
            startActivityForResult(intent, REQUEST_SUPPORT);
        }

        public void onActivityResult(int requestCode, int resultCode, Intent data){
            if (requestCode == REQUEST_SUPPORT){
                if(data == null){
                    return;
                }
            }
        }
    }

    private class SupportAdapter extends RecyclerView.Adapter<SupportHolder>{
        private List<Support> mSupports;
        public SupportAdapter(List<Support> supports){
            mSupports = supports;
        }
        @Override
        public SupportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater
                    .inflate(R.layout.list_item_support,parent,false);
            return new SupportHolder(v);
        }
        @Override
        public void onBindViewHolder(SupportHolder holder, int position) {
            Support support = mSupports.get(position);
            holder.bindSupport(support);
        }
        @Override
        public int getItemCount() {
            return mSupports.size();
        }

        public void setSupports(List<Support> supports){mSupports=supports;}
    }
}
