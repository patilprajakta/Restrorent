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
public class Southwest implements Parcelable {
    public static final Creator<Southwest> CREATOR = new Creator<Southwest>() {
        @Override
        public Southwest createFromParcel(Parcel source) {
            return new Southwest(source);
        }

        @Override
        public Southwest[] newArray(int size) {
            return new Southwest[size];
        }
    };
    private String lng;
    private String lat;

    public Southwest() {
    }

    protected Southwest(Parcel in) {
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
