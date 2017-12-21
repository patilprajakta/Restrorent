package com.durgesh.restaurant.ui.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.durgesh.restaurant.R;
import com.durgesh.restaurant.models.googleDir.RootGoogleDir;
import com.durgesh.restaurant.models.googlePlaces.Place;
import com.durgesh.restaurant.models.googlePlaces.Results;
import com.durgesh.restaurant.models.googlePlaces.RootGooglePlaces;
import com.durgesh.restaurant.network.ApiClient;
import com.durgesh.restaurant.network.ApiHelper;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Prajakta Patil on 6/9/17.

 */
public class NearbyPlacesAdapter extends RecyclerView.Adapter<NearbyPlacesAdapter.MyViewHolder> {

    public RootGooglePlaces rootGooglePlaces;
    public ArrayList<Results> resultsArrayList;
    private Context mContext;
    private ArrayList<Place> placeArrayList;

    private NearbyPlacesAdapter.OnCardItemClickListener onCardItemClickListener;

    public NearbyPlacesAdapter(Context mContext, int selectedCardPos, ArrayList<Place> placeArrayList,
                               ArrayList<Results> resultsArrayList, RootGooglePlaces rootGooglePlaces,
                               NearbyPlacesAdapter.OnCardItemClickListener onCardItemClickListener) {
        this.mContext = mContext;
        this.rootGooglePlaces = rootGooglePlaces;
        this.resultsArrayList = resultsArrayList;
        this.placeArrayList = placeArrayList;
        this.onCardItemClickListener = onCardItemClickListener;
        int selectedCardPos1 = selectedCardPos;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_places, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ApiHelper service;
        holder.bind(position, resultsArrayList.get(position), onCardItemClickListener);
        holder.mTxtHotelName.setText(rootGooglePlaces.getResults().get(position).getName());
        if (rootGooglePlaces.getResults().get(position).getRating() != null) {
            holder.mTxtRating.setText(rootGooglePlaces.getResults().get(position).getRating());
        } else {
            holder.mTxtRating.setText("0.0");
        }
        holder.mTxtHotelName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, holder.mTxtHotelName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        service = ApiClient.getClient(mContext).create(ApiHelper.class);
        Place place = placeArrayList.get(position);
        final Call<ResponseBody> call1 = service.searchPhotos(place.getPhoto());
        call1.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response != null) {
                    if (response.body() != null) {
                        Bitmap bm = BitmapFactory.decodeStream(response.body().byteStream());
                        int targetWidth = bm.getWidth();
                        double aspectRatio = (double) bm.getHeight() / (double) bm.getWidth();
                        int targetHeight = (int) (targetWidth * aspectRatio);
                        holder.mImgHotel.setImageBitmap(Bitmap.createScaledBitmap(bm, targetWidth, targetHeight, false));

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

        if (ApiClient.getClient(mContext) != null) {
            service = ApiClient.getClient(mContext).create(ApiHelper.class);
            String srcLat = "18.499502";
            String srcLng = "73.821873";
            String lat = rootGooglePlaces.getResults().get(position).getGeometry().getLocation().getLat();
            String lng = rootGooglePlaces.getResults().get(position).getGeometry().getLocation().getLng();

            Call<RootGoogleDir> call = service.getGoogleDir(srcLat + "," + srcLng,
                    lat + "," + lng);
            call.enqueue(new Callback<RootGoogleDir>() {
                @Override
                public void onResponse(Call<RootGoogleDir> call, Response<RootGoogleDir> response) {
                    if (response.isSuccessful()) {

                        for (int i = 0; i < response.body().getRoutes().size(); i++) {

                            if (response.body().getRoutes().get(i).getLegs().get(i).getDuration().getText() != null) {
                                String duration = response.body().getRoutes().get(i).getLegs().get(i).getDuration().getText();
                                holder.mTxtDuration.setText(duration);
                            } else {
                                holder.mTxtDuration.setText("0.0" + " mins");

                            }
                            if (response.body().getRoutes().get(i).getLegs().get(i).getDistance().getValue() != null) {
                                Float mile = (Float.parseFloat(response.body().getRoutes().get(i).getLegs().get(i).getDistance().getValue()))
                                        / 1609.34f;
                                String distance = String.format("%.2f", mile);
                                holder.mTxtDist.setText(distance + " mi");
                            } else {
                                holder.mTxtDist.setText("0.0" + " mi");
                            }
                        }
                    }
                }

                @Override
                public void onFailure(Call<RootGoogleDir> call, Throwable t) {
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return rootGooglePlaces.getResults().size();
    }

    public interface OnCardItemClickListener {
        void onCardClick(int position, Results results);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTxtHotelName, mTxtDist, mTxtDuration, mTxtRating;
        private ImageView mImgHotel;
        private CardView mCardView;

        public MyViewHolder(View view) {
            super(view);
            mTxtHotelName =view.findViewById(R.id.txtHotelName);
            mTxtDist =view.findViewById(R.id.txtHotelDist);
            mTxtDuration =view.findViewById(R.id.txtHotelDur);
            mTxtRating = view.findViewById(R.id.txtRating);
            mCardView = view.findViewById(R.id.cardView);
            mImgHotel =view.findViewById(R.id.imgCardHotel);
        }

        public void bind(final int position,
                         final Results results,
                         final NearbyPlacesAdapter.OnCardItemClickListener onCardItemClickListener) {
            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCardItemClickListener.onCardClick(position, results);
                }
            });
        }
    }
}