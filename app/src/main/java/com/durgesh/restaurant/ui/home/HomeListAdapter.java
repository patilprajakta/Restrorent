package com.durgesh.restaurant.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.models.googlePlaces.Place;
import com.durgesh.restaurant.network.ApiClient;
import com.durgesh.restaurant.ui.homeLocation.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Snehal Tembare on 30/8/17.

 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {
    private Context mContext;
     private ArrayList<Place> placeArrayList;
    private OnItemClickListener onItemClickListener;
    private com.durgesh.restaurant.network.ApiHelper service;
    private int TARGET_WIDTH=356;
    private float DISTANCE_IN_MILES=1609.34f;

    public HomeListAdapter(Context context, ArrayList<Place> placeArrayList,
                           OnItemClickListener onItemClickListener) {
        this.mContext = context;
        this.placeArrayList = placeArrayList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_home,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        service = ApiClient.getGoogleClient(mContext).create(com.durgesh.restaurant.network.ApiHelper.class);

        Place place=placeArrayList.get(position);
        holder.mTxtRestName.setText(place.getName());
        holder.mTxtRatingCount.setText(String.valueOf(place.getRating()));

        if (place.getOpeningHours()!=null && place.getOpeningHours().isOpen_now()){
            holder.mLayoutHotelStatus.setVisibility(View.VISIBLE);
            holder.mRelativeLayout.setAlpha((float) 0.5);
        }else {
            holder.mLayoutHotelStatus.setVisibility(View.GONE);
            holder.mRelativeLayout.setAlpha(1);
        }
        float mile = (place.getDistance())/DISTANCE_IN_MILES;
        holder.mTxtDistance.setText(String.format("%.2f",mile)+"mile");

        Picasso.with(mContext).load(place.getPhoto()).into(holder.mImgRestaurant);

        final Call<ResponseBody> callSearchPhotos = service.searchPhotos(place.getPhoto());
        callSearchPhotos.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null) {
                    if (response.body() != null) {
                        Bitmap bm = BitmapFactory.decodeStream(response.body().byteStream());
                        double aspectRatio = (double) bm.getHeight() / (double) bm.getWidth();
                        int targetHeight = (int) (TARGET_WIDTH * aspectRatio);

                        holder.mImgRestaurant.setImageBitmap(Bitmap.createScaledBitmap(bm, TARGET_WIDTH, targetHeight, false));

                    }else {
                        holder.mImgRestaurant.setImageResource(R.drawable.ic_hotel);
                    }
                }
            }


            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        holder.bind(place,onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return placeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImgRestaurant;
        private TextView mTxtRestName;
        private TextView mTxtRatingCount;
        private TextView mTxtDistance;
        private TextView mTxtRestType;
        private LinearLayout mLayoutHotelStatus;
        private RelativeLayout mRelativeLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            mImgRestaurant=itemView.findViewById(R.id.img_restaurant);
            mTxtRestName=itemView.findViewById(R.id.txt_rest_name);
            mTxtRatingCount= itemView.findViewById(R.id.txt_rating_count);
            mTxtDistance=itemView.findViewById(R.id.txt_distance);
            mTxtRestType=  itemView.findViewById(R.id.txt_type);
            mLayoutHotelStatus=itemView.findViewById(R.id.layouthotelstatus);
            mRelativeLayout =  itemView.findViewById(R.id.parent_layout);
        }

        public void bind(final Place place, final OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(place);
                }
            });
        }
    }
}
