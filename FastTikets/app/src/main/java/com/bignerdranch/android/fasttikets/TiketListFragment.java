package com.bignerdranch.android.fasttikets;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TiketListFragment extends Fragment {
    private RecyclerView mTiketRecyclerView;
    private TiketAdapter mAdapter;
    private int mX;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_tiket_list,container,false);

        mTiketRecyclerView = (RecyclerView)v.findViewById(R.id.tiket_r_v);
        mTiketRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));;
        updateUI();
        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        updateUI();
    }

    private void updateUI(){
        TiketLab tiketLab = TiketLab.get(getActivity());
        List<Tiket> tikets = tiketLab.getTikets();
        //if (mAdapter == null) {
            mAdapter = new TiketAdapter(tikets);
            mTiketRecyclerView.setAdapter(mAdapter);
        //} else {
            mAdapter.notifyItemChanged(mX);
        //}
    }

    public  class TiketHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mResponsibleTextView;
        private TextView mAuthorTextView;
        private TextView mThemeTextView;
        private TextView mCategoryTextView;
        private Tiket mTiket;

        public void bindTiket(Tiket tiket){
            mTiket = tiket;
            mResponsibleTextView.setText(mTiket.getResponsible());
            mAuthorTextView.setText(mTiket.getAuthor());
            mThemeTextView.setText(mTiket.getTheme());
            mCategoryTextView.setText(mTiket.getCategory());
        }

        public TiketHolder(View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mResponsibleTextView = (TextView) itemView.findViewById(R.id.list_item_tiket_responsible_text_view);
            mAuthorTextView = (TextView) itemView.findViewById(R.id.list_item_tiket_author_text_view);
            mThemeTextView = (TextView) itemView.findViewById(R.id.list_item_tiket_theme_text_view);
            mCategoryTextView = (TextView) itemView.findViewById(R.id.list_item_tiket_category_text_view);
        }
        @Override
        public void onClick(View v){
            mX = getAdapterPosition();

            Intent intent = TiketActivity.newIntent(getActivity(), mTiket.getId());
            startActivity(intent);
        }
    }

    private class TiketAdapter extends RecyclerView.Adapter<TiketHolder>{
        private List<Tiket> mTikets;
        public TiketAdapter(List<Tiket> tikets){
            mTikets = tikets;
        }
        @Override
        public TiketHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater
                    .inflate(R.layout.list_item_tiket,parent,false);
            return new TiketHolder(v);
        }
        @Override
        public void onBindViewHolder(TiketHolder holder, int position) {
            Tiket tiket = mTikets.get(position);
            holder.bindTiket(tiket);
        }
        @Override
        public int getItemCount() {
            return mTikets.size();
        }
    }
}