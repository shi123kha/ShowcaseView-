package com.example.cogxio.showcaseview;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by cogxio on 15/7/16.
 */
public class ShowcaseListArray implements Parcelable {

    float x, y;
    int width;
    String arr;
    int height;

    public ShowcaseListArray(float X, float Y, int width,int height, String arr) {
        this.x = X;
        this.y = Y;
        this.width = width;
        this.arr=arr;
        this.height=height;
        Log.e("float values", "" + X + Y + width);

    }


    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth()

    {
        return width;
    }

    public int getHeight()
    {
        Log.e("height",""+height);
        return height;

    }
    public String gettext()

    {
        return arr;
    }

    @Override
    public void writeToParcel(Parcel dest, int arg1) {
        // TODO Auto-generated method stub
        dest.writeFloat(x);
        dest.writeFloat(y);
        dest.writeInt(width);
        dest.writeInt(height);
        dest.writeString(arr);
    }
    public ShowcaseListArray(Parcel in) {
        x = in.readFloat();
        y = in.readFloat();
        width = in.readInt();
        height=in.readInt();
        arr=in.readString();
    }

    public static final Parcelable.Creator<ShowcaseListArray> CREATOR = new Parcelable.Creator<ShowcaseListArray>() {
        public ShowcaseListArray createFromParcel(Parcel in) {
            return new ShowcaseListArray(in);
        }

        public ShowcaseListArray[] newArray(int size) {
            return new ShowcaseListArray[size];
        }
    };

}
