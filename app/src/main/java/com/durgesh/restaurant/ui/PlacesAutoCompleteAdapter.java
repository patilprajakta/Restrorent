package com.durgesh.restaurant.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import com.durgesh.restaurant.models.Prediction;
import com.durgesh.restaurant.ui.map.PlaceAPI;

import java.util.ArrayList;

import static com.durgesh.restaurant.ui.map.PlaceAPI.PREDICTIONS;

/**
 * Created by Snehal Tembare on 26/9/17.

 */

public class PlacesAutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {

    private Context mContext;
    private int mResource;
    private LayoutInflater mInflater;

    public PlaceAPI mPlaceAPI;

    public PlacesAutoCompleteAdapter(Context context, int resource) {
        super(context, resource);

        mContext = context;
        mResource = resource;
        mPlaceAPI = new PlaceAPI(mContext);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return PREDICTIONS.size();
    }

    @Override
    public String getItem(int position) {
        String s=PREDICTIONS.get(position).getDescription();
        return PREDICTIONS.get(position).getDescription();
    }
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                            mPlaceAPI.autocomplete(constraint.toString());

                    ArrayList<String> arrayList=new ArrayList<>();
                    for (Prediction p:PREDICTIONS){
                        arrayList.add(p.getDescription());
                    }

                    filterResults.values = arrayList;
                    filterResults.count = arrayList.size();
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }
        };

        return filter;
    }


}