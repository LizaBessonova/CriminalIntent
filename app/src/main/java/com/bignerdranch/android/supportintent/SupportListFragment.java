package com.bignerdranch.android.supportintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class SupportListFragment extends Fragment {
    private RecyclerView mSupportRecyclerView;
    private SupportAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_support_list,container,false);

        mSupportRecyclerView = (RecyclerView)v.findViewById(R.id.support_recycler_view);
        mSupportRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));;
        updateUI();
        return v;
    }

    private void updateUI(){
        SupportLab supportLab = SupportLab.get(getActivity());
        List<Support> supports = supportLab.getSupports();
        mAdapter = new SupportAdapter(supports);
        mSupportRecyclerView.setAdapter(mAdapter);
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
            Intent intent = SupportActivity.newIntent(getActivity(), mSupport.getId());
            startActivity(intent);
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
    }
}
