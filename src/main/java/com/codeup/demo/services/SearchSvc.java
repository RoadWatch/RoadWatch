package com.codeup.demo.services;

import com.mapbox.api.geocoding.v5.MapboxGeocoding;

import javax.security.auth.callback.Callback;

public class SearchSvc {
    private String query;
    private String token;

    public SearchSvc(String query, String token) {
        this.query = query;
        this.token = token;
    }
    public void executeSearch(){
        MapboxGeocoding mapboxGeocoding =
                MapboxGeocoding.builder()
                        .accessToken(this.token)
                        .query("codeup")
                        .build();


    }

}



