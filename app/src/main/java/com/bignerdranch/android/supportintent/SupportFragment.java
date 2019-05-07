package com.bignerdranch.android.supportintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SupportFragment extends Fragment {

    private Support mSupport;
    private Support mMessage;
    private TextView mAuthorTextView;
    private TextView mResponsibleTextView;
    private TextView mThemeTextView;
    private TextView mCategoryTextView;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private TextView mAuthorMessage;

    private RecyclerView mSupportRecyclerViewMessage;
    private SupportAdapterMessage mAdapterMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID supportId = (UUID) getActivity().getIntent()
                .getSerializableExtra(SupportActivity.EXTRA_SUPPORT_ID);
        mSupport = SupportLab.get(getActivity()).getSupport(supportId);
    }

    @Override
    public void onPause(){
        super.onPause();

        SupportLab.get(getActivity())
                .updateSupport(mSupport);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_support, container, false);
        mSupportRecyclerViewMessage = (RecyclerView)v.findViewById(R.id.support_recycler_view_message);
        mSupportRecyclerViewMessage.setLayoutManager(new LinearLayoutManager(getActivity()));;

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

        updateUI();
        return v;
    }

    private void updateUI(){
        MessageLab messageLab = MessageLab.get(getActivity());
        List<Support> supports = messageLab.getSupports();
        mAdapterMessage = new SupportAdapterMessage(supports);
        mSupportRecyclerViewMessage.setAdapter(mAdapterMessage);
    }
//Создание списка сообщений
    private class SupportAdapterMessage extends RecyclerView.Adapter<SupportHolderMessage>{
        private List<Support> mSupports;
        public SupportAdapterMessage(List<Support> supports){
            mSupports = supports;
        }
        @Override
        public SupportHolderMessage onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater
                    .inflate(R.layout.list_item_message,parent,false);
            return new SupportHolderMessage(v);
        }
        @Override
        public void onBindViewHolder(SupportHolderMessage holder, int position) {
            Support support = mSupports.get(position);
            holder.bindSupportMessage(support);
        }
        @Override
        public int getItemCount() {
            return mSupports.size();
        }
    }

    public  class SupportHolderMessage extends RecyclerView.ViewHolder {
        private TextView mAuthorMessageTextView;
        private Support mSupport;

        public void bindSupportMessage(Support support){
            mSupport = support;
            mAuthorMessageTextView.setText(mSupport.getAuthorMessage());
        }

        public SupportHolderMessage(View itemView){
            super(itemView);
            mAuthorMessageTextView = (TextView) itemView.findViewById(R.id.list_item_support_author_message_text_view);
        }
    }



    private void updateDateAndTime() {
        Date d = mSupport.getDate();
        CharSequence c = DateFormat.format("EEEE, MMM dd, yyyy", d);
        //CharSequence t = DateFormat.format("h:mm", d);
        mDateButton.setText(c);
    }
}
