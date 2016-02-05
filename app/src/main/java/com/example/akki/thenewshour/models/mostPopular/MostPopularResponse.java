package com.example.akki.thenewshour.models.mostPopular;

import com.example.akki.thenewshour.models.BasicResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 15/12/15.
 */
public class MostPopularResponse extends BasicResponse
        implements Serializable {
    @SerializedName("response")
    public MostPopularEntity mostPopularEntity;


}
