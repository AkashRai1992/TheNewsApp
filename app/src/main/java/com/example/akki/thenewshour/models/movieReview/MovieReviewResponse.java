package com.example.akki.thenewshour.models.movieReview;

import com.example.akki.thenewshour.models.BasicResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akki on 23/12/15.
 */
public class MovieReviewResponse extends BasicResponse implements Serializable {

    @SerializedName("results")
    public List<MovieReviewEntity> movieReviewEntity;
}
