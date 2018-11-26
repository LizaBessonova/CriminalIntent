package com.bignerdranch.android.criminalintent;

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

public class CrimeListFragment extends Fragment {
    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_crime_list,container,false);

        mCrimeRecyclerView = (RecyclerView)v.findViewById(R.id.crime_recycler_view);
        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));;
        updateUI();
        return v;
    }

    private void updateUI(){
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        mAdapter = new CrimeAdapter(crimes);
        mCrimeRecyclerView.setAdapter(mAdapter);
    }

    public  class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mResponsibleTextView;
        private TextView mAuthorTextView;
        private TextView mThemeTextView;
        private TextView mCategoryTextView;
        private CheckBox mSolvedCheckBox;
        private Crime mCrime;

        public void bindCrime(Crime crime){
            mCrime = crime;
            mResponsibleTextView.setText(mCrime.getResponsible());
            mAuthorTextView.setText(mCrime.getAuthor());
            mThemeTextView.setText(mCrime.getTheme());
            mCategoryTextView.setText(mCrime.getCategory());
            mSolvedCheckBox.setChecked(mCrime.isSolved());
        }

        public CrimeHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mResponsibleTextView = (TextView) itemView.findViewById(R.id.list_item_crime_responsible_text_view);
            mAuthorTextView = (TextView) itemView.findViewById(R.id.list_item_crime_author_text_view);
            mThemeTextView = (TextView) itemView.findViewById(R.id.list_item_crime_theme_text_view);
            mCategoryTextView = (TextView) itemView.findViewById(R.id.list_item_crime_category_text_view);
            mSolvedCheckBox = (CheckBox) itemView.findViewById(R.id.list_item_crime_solved_check_box);
        }
        @Override
        public void onClick(View v){
            Intent intent = CrimeActivity.newIntent(getActivity(), mCrime.getId());
            startActivity(intent);
        }
    }

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater
                    .inflate(R.layout.list_item_crime,parent,false);
            return new CrimeHolder(v);
        }
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bindCrime(crime);
        }
        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }
}
