package com.bignerdranch.android.fasttikets;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.UUID;

@SuppressLint("ValidFragment")
class TiketFragment extends Fragment {
    private Tiket mTiket;
    private Tiket mMessage;
    private EditText mAuthorTextView;
    private EditText mResponsibleTextView;
    private EditText mThemeTextView;
    private EditText mCategoryTextView;
    private TextView mAuthorMessage;

    private RecyclerView mTiketRecyclerViewMessage;
   // private TiketAdapterMessage mAdapterMessage;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID tiketId = (UUID) getActivity().getIntent()
                .getSerializableExtra(TiketActivity.EXTRA_TIKET_ID);
        mTiket = TiketLab.get(getActivity()).getTiket(tiketId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tiket, container, false);
        mTiketRecyclerViewMessage = (RecyclerView) v.findViewById(R.id.tiket_recycler_view_message);
        mTiketRecyclerViewMessage.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAuthorTextView = (EditText) v.findViewById(R.id.tiket_author);
//        mAuthorTextView.setText(mTiket.getAuthor());

        mResponsibleTextView = (EditText) v.findViewById(R.id.tiket_responsible);
//        mResponsibleTextView.setText(mTiket.getResponsible());

        mThemeTextView = (EditText) v.findViewById(R.id.tiket_theme);
//        mThemeTextView.setText(mTiket.getTheme());

        mCategoryTextView = (EditText) v.findViewById(R.id.tiket_category);
//        mCategoryTextView.setText(mTiket.getCategory());

//         updateUI();
        return v;
    }

//    private void updateUI() {
//        MessageLab messageLab = MessageLab.get(getActivity());
//        List<Tiket> tikets = messageLab.getTikets();
//        mAdapterMessage = new TiketAdapterMessage(tikets);
//        mTiketRecyclerViewMessage.setAdapter(mAdapterMessage);
//    }
//
//    //Создание списка сообщений
//    private class TiketAdapterMessage extends RecyclerView.Adapter<TiketHolderMessage> {
//        private List<Tiket> mTikets;
//
//        public TiketAdapterMessage(List<Tiket> tikets) {
//            mTikets = tikets;
//        }
//
//        @Override
//        public TiketHolderMessage onCreateViewHolder(ViewGroup parent, int viewType) {
//            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
//            View v = layoutInflater
//                    .inflate(R.layout.list_item_message, parent, false);
//            return new TiketHolderMessage(v);
//        }
//
//        @Override
//        public void onBindViewHolder(TiketHolderMessage holder, int position) {
//            Tiket tiket = mTikets.get(position);
//            holder.bindTiketMessage(tiket);
//        }
//
//        @Override
//        public int getItemCount() {
//            return mTikets.size();
//        }
//    }
//
//    public class TiketHolderMessage extends RecyclerView.ViewHolder {
//        private TextView mAuthorMessageTextView;
//        private Tiket mTiket;
//
//        public void bindTiketMessage(Tiket tiket) {
//            mTiket = tiket;
//            mAuthorMessageTextView.setText(mTiket.getAuthorMessage());
//        }
//
//        public TiketHolderMessage(View itemView) {
//            super(itemView);
//            mAuthorMessageTextView = (TextView) itemView.findViewById(R.id.list_item_tiket_author_message_text_view);
//        }
//    }
}