package com.example.akki.thenewshour.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 24/12/15.
 */
public class BasicResponse implements Serializable {
    @SerializedName("status")
    public String status;

    @SerializedName("copyright")
    public String Copyright;
}
