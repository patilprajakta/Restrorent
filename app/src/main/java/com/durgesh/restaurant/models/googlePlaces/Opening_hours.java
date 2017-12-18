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
public class Opening_hours implements Parcelable {

    public static final Creator<Opening_hours> CREATOR = new Creator<Opening_hours>() {
        @Override
        public Opening_hours createFromParcel(Parcel source) {
            return new Opening_hours(source);
        }

        @Override
        public Opening_hours[] newArray(int size) {
            return new Opening_hours[size];
        }
    };
    private String open_now;
    private ArrayList<String> weekday_text;

    public Opening_hours() {
    }

    protected Opening_hours(Parcel in) {
        this.open_now = in.readString();
        this.weekday_text = in.createStringArrayList();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.open_now);
        dest.writeStringList(this.weekday_text);
    }
}
