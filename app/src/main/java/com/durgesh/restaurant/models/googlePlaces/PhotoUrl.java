package com.durgesh.restaurant.models.googlePlaces;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Snehal Tembare on 31/8/17.

 */
@Getter
@Setter

public class PhotoUrl implements Parcelable {
    public static final Creator<PhotoUrl> CREATOR = new Creator<PhotoUrl>() {
        @Override
        public PhotoUrl createFromParcel(Parcel in) {
            return new PhotoUrl(in);
        }

        @Override
        public PhotoUrl[] newArray(int size) {
            return new PhotoUrl[size];
        }
    };
    private Integer height;
    private String photo_reference;

    protected PhotoUrl(Parcel in) {
        height = in.readInt();
        photo_reference = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(photo_reference);
        dest.writeInt(height);
    }
}

