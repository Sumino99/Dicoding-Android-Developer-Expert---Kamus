package com.ysn.dicodingandroiddeveloperexpert_kamus.ui.dashboard.fragments.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ysn.dicodingandroiddeveloperexpert_kamus.R;
import com.ysn.dicodingandroiddeveloperexpert_kamus.model.KataKamus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by yudisetiawan on 9/30/17.
 */

public class AdapterSearchingKeyword extends RecyclerView.Adapter<AdapterSearchingKeyword.ViewHolder> {

    private final String TAG = getClass().getSimpleName();
    private List<KataKamus> listDataKataKamus;
    private ListenerAdapterSearchingKeyword listenerAdapterSearchingKeyword;

    public AdapterSearchingKeyword(List<KataKamus> listDataKataKamus,
                                   ListenerAdapterSearchingKeyword listenerAdapterSearchingKeyword) {
        this.listDataKataKamus = listDataKataKamus;
        this.listenerAdapterSearchingKeyword = listenerAdapterSearchingKeyword;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_adapter_searching_keyword, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewWorditemAdapterSearchingKeyword
                .setText(listDataKataKamus.get(position).getFromWord());
    }

    @Override
    public int getItemCount() {
        return listDataKataKamus.size();
    }

    public void refreshData(List<KataKamus> listDataKataKamusSearching) {
        this.listDataKataKamus = listDataKataKamusSearching;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_view_word_item_adapter_searching_keyword)
        TextView textViewWorditemAdapterSearchingKeyword;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.relative_layout_item_adapter_searching_keyword)
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.relative_layout_item_adapter_searching_keyword:
                    listenerAdapterSearchingKeyword.onClickItemKeyword(
                            listDataKataKamus.get(getAdapterPosition())
                    );
                    break;
            }
        }
    }

    public interface ListenerAdapterSearchingKeyword {

        void onClickItemKeyword(KataKamus katakamusSelected);

    }

}
