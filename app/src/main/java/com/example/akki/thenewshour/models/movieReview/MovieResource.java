package com.example.akki.thenewshour.models.movieReview;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 23/12/15.
 */
public class MovieResource implements Serializable {

    @SerializedName("type")
    public String type;

    @SerializedName("src")
    public String src;

    @SerializedName("height")
    public String height;

    @SerializedName("width")
    public String width;
}
