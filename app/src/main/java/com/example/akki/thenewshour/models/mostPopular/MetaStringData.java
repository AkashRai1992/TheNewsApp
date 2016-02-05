package com.example.akki.thenewshour.models.mostPopular;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akki on 15/12/15.
 */
public class MetaStringData  implements Serializable {
    @SerializedName("web_url")
    public String web_url;

    @SerializedName("snippet")
    public String snippet;

    @SerializedName("lead_paragraph")
    public String lead_paragraph;

}
