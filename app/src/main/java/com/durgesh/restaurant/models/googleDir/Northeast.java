package com.durgesh.restaurant.models.googleDir;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Prajakta Patil on 30/8/17.

 */
@Getter
@Setter
public class Northeast implements Parcelable {
    public static final Creator<Northeast> CREATOR = new Creator<Northeast>() {
        @Override
        public Northeast createFromParcel(Parcel source) {
            return new Northeast(source);
        }

        @Override
        public Northeast[] newArray(int size) {
            return new Northeast[size];
        }
    };
    private String lng;
    private String lat;

    public Northeast() {
    }

    protected Northeast(Parcel in) {
        this.lng = in.readString();
        this.lat = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.lng);
        dest.writeString(this.lat);
    }
}
