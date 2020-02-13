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

    public SearchSvc() {}
    public void executeSearch(
            String query, String token
    ){
        MapboxGeocoding mapboxGeocoding =
                MapboxGeocoding.builder()
                        .accessToken(token)
                        .query("codeup")
                        .build();
        mapboxGeocoding.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                List<CarmenFeature> results = response.body().features();
                if(results.size() > 0){
                    List<Double> center = results.get(0).center().coordinates();
                    Double firstPoint = center.get(0);
                    System.out.println("FIRSTPOINT"+firstPoint);

                }
            }

            @Override
            public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {

            }
        });

    }

}



