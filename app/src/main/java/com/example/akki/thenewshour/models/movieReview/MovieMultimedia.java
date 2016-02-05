package com.example.akki.thenewshour.models.movieReview;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 23/12/15.
 */
public class MovieMultimedia implements Serializable {
    @SerializedName("resource")
    public MovieResource movieResource;
}
