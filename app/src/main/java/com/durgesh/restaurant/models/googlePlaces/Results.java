package com.durgesh.restaurant.models.googlePlaces;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Prajakta Patil on 4/9/17.

 */
@Getter
@Setter
public class Results implements Parcelable {

    public static final Creator<Results> CREATOR = new Creator<Results>() {
        @Override
        public Results createFromParcel(Parcel source) {
            return new Results(source);
        }

        @Override
        public Results[] newArray(int size) {
            return new Results[size];
        }
    };
    private ArrayList<PhotoUrl> photos;
    private String id;
    private String place_id;
    private String icon;
    private String vicinity;
    private String scope;
    private String name;
    private String rating;
    private ArrayList<String> types;
    private String reference;
    private Opening_hours opening_hours;
    private Geometry geometry;

    public Results() {
    }

    protected Results(Parcel in) {
        this.photos = in.createTypedArrayList(PhotoUrl.CREATOR);
        this.id = in.readString();
        this.place_id = in.readString();
        this.icon = in.readString();
        this.vicinity = in.readString();
        this.scope = in.readString();
        this.name = in.readString();
        this.rating = in.readString();
        this.types = in.createStringArrayList();
        this.reference = in.readString();
        this.opening_hours = in.readParcelable(Opening_hours.class.getClassLoader());
        this.geometry = in.readParcelable(Geometry.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.photos);
        dest.writeString(this.id);
        dest.writeString(this.place_id);
        dest.writeString(this.icon);
        dest.writeString(this.vicinity);
        dest.writeString(this.scope);
        dest.writeString(this.name);
        dest.writeString(this.rating);
        dest.writeStringList(this.types);
        dest.writeString(this.reference);
        dest.writeParcelable(this.opening_hours, flags);
        dest.writeParcelable(this.geometry, flags);
    }
}
