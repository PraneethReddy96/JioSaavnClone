package com.example.saavn_app_praneeth.Response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseModel {

    @SerializedName("resultCount")
    private Integer resultCount;

    @SerializedName("results")
    private List<ResultsItem> results;

    public Integer getResultCount(){
        return resultCount;
    }

    public List<ResultsItem> getResults(){
        return results;
    }
}