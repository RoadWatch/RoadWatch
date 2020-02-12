package com.codeup.demo.services;

import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
@Service
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
        mapboxGeocoding.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                List<CarmenFeature> results = response.body().features();
                if(results.size() > 0){
                    Point center = results.get(0).center();
                    System.out.println("CENTER"+center);
                }
            }

            @Override
            public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {

            }
        });

    }

}



