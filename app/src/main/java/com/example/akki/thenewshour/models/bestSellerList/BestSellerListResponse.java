package com.example.akki.thenewshour.models.bestSellerList;

import com.example.akki.thenewshour.models.BasicResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akki on 5/1/16.
 */
public class BestSellerListResponse extends BasicResponse implements Serializable {
    @SerializedName("results")
    public List<BestSellerListEntity> bestSellerListEntityList;
}
