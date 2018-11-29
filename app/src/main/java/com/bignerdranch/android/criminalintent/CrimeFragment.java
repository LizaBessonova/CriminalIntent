package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.UUID;

public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private TextView mAuthorTextView;
    private TextView mResponsibleTextView;
    private TextView mThemeTextView;
    private TextView mCategoryTextView;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID crimeId = (UUID) getActivity().getIntent()
                .getSerializableExtra(CrimeActivity.EXTRA_CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mAuthorTextView = (TextView)v.findViewById(R.id.crime_author);
        mAuthorTextView.setText(mCrime.getAuthor());

        mResponsibleTextView = (TextView)v.findViewById(R.id.crime_responsible);
        mResponsibleTextView.setText(mCrime.getResponsible());

        mThemeTextView = (TextView)v.findViewById(R.id.crime_theme);
        mThemeTextView.setText(mCrime.getTheme());

        mCategoryTextView = (TextView)v.findViewById(R.id.crime_category);
        mCategoryTextView.setText(mCrime.getCategory());

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        //mDateButton.setText(mCrime.getDate().toString());
        mDateButton.setEnabled(false);
        updateDateAndTime();

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setChecked(mCrime.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCrime.setSolved(b);
            }
        });
        return v;
    }
    private void updateDateAndTime() {
        Date d = mCrime.getDate();
        CharSequence c = DateFormat.format("EEEE, MMM dd, yyyy", d);
        //CharSequence t = DateFormat.format("h:mm", d);
        mDateButton.setText(c);
    }
}
