package es.mgs.myapprecycler.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by android on 15/03/2018.
 */

public class Animals implements Parcelable {
    // int img;
    @SerializedName("Image")
    String img;
    String name;
    String cientificname;
    String ubicacion;

    public Animals(String img, String nombre, String nombreCientifico, String ubicacion) {
        this.img = img;
        this.name = nombre;
        this.cientificname = nombreCientifico;
        this.ubicacion = ubicacion;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getCientificname() {
        return cientificname;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.img);
        dest.writeString(this.name);
        dest.writeString(this.cientificname);
        dest.writeString(this.ubicacion);
    }

    protected Animals(Parcel in) {
        this.img = in.readString();
        this.name = in.readString();
        this.cientificname = in.readString();
        this.ubicacion = in.readString();
    }

    public static final Parcelable.Creator<Animals> CREATOR = new Parcelable.Creator<Animals>() {
        @Override
        public Animals createFromParcel(Parcel source) {
            return new Animals(source);
        }

        @Override
        public Animals[] newArray(int size) {
            return new Animals[size];
        }
    };
}
