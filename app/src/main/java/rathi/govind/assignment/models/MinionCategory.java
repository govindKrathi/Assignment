package rathi.govind.assignment.models;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Contains the information about the minions like image, name, rating and information.
 */

public class MinionCategory {
    int imgId;
    String name;

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    String information;
    Double ratings;

    public MinionCategory(int imgId, String name, String information, Double ratings) {
        this.imgId = imgId;
        this.name = name;
        this.information=information;
        this.ratings = ratings;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }


}
