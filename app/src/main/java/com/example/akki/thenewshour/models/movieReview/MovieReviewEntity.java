package com.example.akki.thenewshour.models.movieReview;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 23/12/15.
 */
public class MovieReviewEntity implements Serializable {
    @SerializedName("display_title")
    public String displayTitle;

    @SerializedName("mpaa_rating")
    public String movieRating;

    @SerializedName("headline")
    public String headline;

    @SerializedName("summary_short")
    public String summary_short;

    @SerializedName("byline")
    public String byline;

    @SerializedName("link")
    public MovieSuggestedLink feedMovieSuggestedLink;

    @SerializedName("multimedia")
    public MovieMultimedia movieMultimedia;

}
