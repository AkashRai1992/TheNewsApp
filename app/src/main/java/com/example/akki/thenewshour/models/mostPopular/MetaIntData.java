package com.example.akki.thenewshour.models.mostPopular;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 15/12/15.
 */
public class MetaIntData  implements Serializable {
    @SerializedName("hits")
    public int hits;

    @SerializedName("time")
    public int time;

    @SerializedName("offset")
    public int offset;
}
