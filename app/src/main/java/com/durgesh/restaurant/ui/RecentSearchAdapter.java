package com.durgesh.restaurant.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.ui.homeLocation.HomeLocationActivity;

import java.util.ArrayList;

/**
 * Created by Snehal Tembare on 26/10/17.

 */

public class RecentSearchAdapter extends RecyclerView.Adapter<RecentSearchAdapter.ViewHolder> {
    private Context context;
    private HomeLocationActivity.OnItemClickListener onItemClickListener;
    private ArrayList<String> sTrendingSearchList;
    public static boolean sIsItemSelected;

    public RecentSearchAdapter(Context context, ArrayList<String> sTrendingSearchList, HomeLocationActivity.OnItemClickListener onItemClickListener) {
        this.context = context;
        this.sTrendingSearchList = sTrendingSearchList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_treanding_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String trendingPlace = sTrendingSearchList.get(position);
        holder.mRecentPlace.setText(trendingPlace);
        holder.bind(trendingPlace, onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return sTrendingSearchList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView mRecentPlace;

        public ViewHolder(View itemView) {
            super(itemView);
            mRecentPlace = (TextView) itemView.findViewById(R.id.txt_trending_place_name);
        }

        public void bind(final String trendingPlace,final HomeLocationActivity.OnItemClickListener onItemClickListener) {
            sIsItemSelected=true;
            onItemClickListener.onItemClick(trendingPlace);
        }
    }
}
