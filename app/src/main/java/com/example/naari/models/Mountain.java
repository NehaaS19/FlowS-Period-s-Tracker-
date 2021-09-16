package com.example.naari.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Mountain implements Parcelable {

    // create implementation Parcelable to this class
    private String name,  photo, description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Mountain() {
    }

    protected Mountain(Parcel in) {
        name = in.readString();
        photo = in.readString();
        description = in.readString();
    }

    public static final Creator<Mountain> CREATOR = new Creator<Mountain>() {
        @Override
        public Mountain createFromParcel(Parcel in) {
            return new Mountain(in);
        }

        @Override
        public Mountain[] newArray(int size) {
            return new Mountain[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(photo);
        parcel.writeString(description);
    }
}

