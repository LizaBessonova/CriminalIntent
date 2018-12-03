package com.bignerdranch.android.supportintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Date;
import java.util.UUID;

public class SupportFragment extends Fragment {

    private Support mSupport;
    private TextView mAuthorTextView;
    private TextView mResponsibleTextView;
    private TextView mThemeTextView;
    private TextView mCategoryTextView;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID supportId = (UUID) getActivity().getIntent()
                .getSerializableExtra(SupportActivity.EXTRA_SUPPORT_ID);
        mSupport = SupportLab.get(getActivity()).getSupport(supportId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_support, container, false);

        mAuthorTextView = (TextView)v.findViewById(R.id.support_author);
        mAuthorTextView.setText(mSupport.getAuthor());

        mResponsibleTextView = (TextView)v.findViewById(R.id.support_responsible);
        mResponsibleTextView.setText(mSupport.getResponsible());

        mThemeTextView = (TextView)v.findViewById(R.id.support_theme);
        mThemeTextView.setText(mSupport.getTheme());

        mCategoryTextView = (TextView)v.findViewById(R.id.support_category);
        mCategoryTextView.setText(mSupport.getCategory());

        mDateButton = (Button)v.findViewById(R.id.support_date);
        //mDateButton.setText(mSupport.getDate().toString());
        mDateButton.setEnabled(false);
        updateDateAndTime();

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.support_solved);
        mSolvedCheckBox.setChecked(mSupport.isSolved());
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mSupport.setSolved(b);
            }
        });
        return v;
    }
    private void updateDateAndTime() {
        Date d = mSupport.getDate();
        CharSequence c = DateFormat.format("EEEE, MMM dd, yyyy", d);
        //CharSequence t = DateFormat.format("h:mm", d);
        mDateButton.setText(c);
    }
}
