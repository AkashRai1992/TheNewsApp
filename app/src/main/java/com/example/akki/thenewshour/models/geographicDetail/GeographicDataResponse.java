package com.example.akki.thenewshour.models.geographicDetail;

import com.example.akki.thenewshour.models.BasicResponse;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akki on 26/12/15.
 */
public class GeographicDataResponse extends BasicResponse implements Serializable {
    @SerializedName("results")
    public List<GeographicDetailEntity> geographicDetailList;
}
