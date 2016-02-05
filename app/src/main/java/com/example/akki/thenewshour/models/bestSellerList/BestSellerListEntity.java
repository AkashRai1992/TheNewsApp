package com.example.akki.thenewshour.models.bestSellerList;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 5/1/16.
 */
public class BestSellerListEntity implements Serializable {
    @SerializedName("list_name")
    public String bookName;

    @SerializedName("display_name")
    public String displayName;

    @SerializedName("newest_published_date")
    public String newestPublishedDate;

    @SerializedName("updated")
    public String updatedTime;
}
