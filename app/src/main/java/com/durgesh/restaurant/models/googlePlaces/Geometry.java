package com.durgesh.restaurant.models.googlePlaces;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Prajakta Patil on 4/9/17.

 */
@Getter
@Setter
public class Geometry implements Parcelable {

    public static final Creator<Geometry> CREATOR = new Creator<Geometry>() {
        @Override
        public Geometry createFromParcel(Parcel source) {
            return new Geometry(source);
        }

        @Override
        public Geometry[] newArray(int size) {
            return new Geometry[size];
        }
    };
    private Viewport viewport;
    private GoogleLocation location;

    public Geometry() {
    }

    protected Geometry(Parcel in) {
        this.viewport = in.readParcelable(Viewport.class.getClassLoader());
        this.location = in.readParcelable(GoogleLocation.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.viewport, flags);
        dest.writeParcelable(this.location, flags);
    }
}
