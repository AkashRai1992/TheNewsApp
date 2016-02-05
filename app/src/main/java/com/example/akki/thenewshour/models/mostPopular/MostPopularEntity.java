package com.example.akki.thenewshour.models.mostPopular;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akki on 15/12/15.
 */
public class MostPopularEntity implements Serializable {
    @SerializedName("meta")
    public MetaIntData metaIntData;

    @SerializedName("docs")
    public List<MetaStringData> basicEntities;
}
