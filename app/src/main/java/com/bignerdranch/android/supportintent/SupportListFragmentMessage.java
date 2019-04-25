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

public class SupportListFragmentMessage extends Fragment {
    private RecyclerView mMessageRecyclerView;
    private MessageAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_support,container,false);

        mMessageRecyclerView = (RecyclerView)v.findViewById(R.id.support_recycler_view_message);
        mMessageRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));;
        return v;
    }

    public  class SupportHolder extends RecyclerView.ViewHolder{
        private TextView mAuthorMessageTextView;
        private Support mSupport;

        public void bindSupport(Support support){
            mSupport = support;
            mAuthorMessageTextView.setText(mSupport.getAuthorMessage());
        }

        public SupportHolder(View itemView){
            super(itemView);
            mAuthorMessageTextView = (TextView) itemView.findViewById(R.id.list_item_support_author_message_text_view);
        }
    }

    private class MessageAdapter extends RecyclerView.Adapter<SupportHolder>{
        private List<Support> mSupports;
        public MessageAdapter(List<Support> supports){
            mSupports = supports;
        }
        @Override
        public SupportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater
                    .inflate(R.layout.list_item_message,parent,false);
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
