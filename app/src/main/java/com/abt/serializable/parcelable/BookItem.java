package com.abt.serializable.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @描述： @BookItem
 * @作者： @黄卫旗
 * @创建时间： @23/06/2018
 */
public class BookItem implements Parcelable {
    public String mName;
    public long mLastTime;
    public String mTitle;
    public String mPath;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeLong(this.mLastTime);
        dest.writeString(this.mTitle);
        dest.writeString(this.mPath);
    }

    public BookItem() {
    }

    protected BookItem(Parcel in) {
        this.mName = in.readString();
        this.mLastTime = in.readLong();
        this.mTitle = in.readString();
        this.mPath = in.readString();
    }

    public static final Parcelable.Creator<BookItem> CREATOR = new Parcelable.Creator<BookItem>() {
        @Override
        public BookItem createFromParcel(Parcel source) {
            return new BookItem(source);
        }

        @Override
        public BookItem[] newArray(int size) {
            return new BookItem[size];
        }
    };
}
