package com.example.akki.thenewshour.models.movieReview;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 23/12/15.
 */
public class MovieSuggestedLink implements Serializable {

    @SerializedName("type")
    public String articleType;

    @SerializedName("url")
    public String url;

    @SerializedName("suggested_link_text")
    public String suggested_link_text;
}
