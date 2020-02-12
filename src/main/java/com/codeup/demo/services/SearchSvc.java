package com.codeup.demo.services;

import com.mapbox.api.geocoding.v5.MapboxGeocoding;

import javax.security.auth.callback.Callback;

public class SearchSvc {
    private String query;

    public SearchSvc(String query) {
        this.query = query;
    }

//    String token = "pk.eyJ1IjoiYW1iZXJsb3Zlc2NhdHMxNCIsImEiOiJjazIyZ3J4b2wxdThhM2RsMmRxaGZxdWhzIn0" +
//            ".uXec6Sexsl65YNbQ89Neng";
//    MapboxGeocoding mapboxGeocoding =
//            MapboxGeocoding.builder()
//                    .accessToken()
//                    .query("codeup")
//                    .build();

//    mapbo
//    client.enqueue(new Callback<GeocoderResponse>)
}
