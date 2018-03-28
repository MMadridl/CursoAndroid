package es.mgs.myapprecycler.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by android on 26/03/2018.
 */
/* Clase ListAnimals para poder coger los del JSON */
 public class ListAnimals implements Parcelable {
    ArrayList<Animals> detail= new ArrayList<>();

    public ListAnimals(ArrayList<Animals> detail) {
        this.detail = detail;
    }

    public ArrayList<Animals> getDetail() {
        return detail;
    }

    public void setDetail(ArrayList<Animals> detail) {
        this.detail = detail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.detail);
    }

    protected ListAnimals(Parcel in) {
        this.detail = in.createTypedArrayList(Animals.CREATOR);
    }

    public static final Parcelable.Creator<ListAnimals> CREATOR = new Parcelable.Creator<ListAnimals>() {
        @Override
        public ListAnimals createFromParcel(Parcel source) {
            return new ListAnimals(source);
        }

        @Override
        public ListAnimals[] newArray(int size) {
            return new ListAnimals[size];
        }
    };
}
