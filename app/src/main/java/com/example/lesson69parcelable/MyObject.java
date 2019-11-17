package com.example.lesson69parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyObject implements Parcelable {
    private final static String LOG_TAG = "myLogs";

    private String s;
    private int i;

    public MyObject(String s, int i) {
        Log.d(LOG_TAG, "MyObject(String s, int i)");
        this.s = s;
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public int getI() {
        return i;
    }

    private MyObject(Parcel in) {
        Log.d(LOG_TAG, "MyObject(Parcel parcel)");
        s = in.readString();
        i = in.readInt();
    }

    public static final Creator<MyObject> CREATOR = new Creator<MyObject>() {
        // распаковываем объект из Parcel
        @Override
        public MyObject createFromParcel(Parcel in) {
            Log.d(LOG_TAG, "createFromParcel");
            return new MyObject(in);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }
    // упаковываем объект в Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.d(LOG_TAG, "writeToParcel");
        dest.writeString(s);
        dest.writeInt(i);
    }
}
