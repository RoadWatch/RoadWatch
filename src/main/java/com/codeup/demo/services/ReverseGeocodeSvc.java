package com.codeup.demo.services;

import com.google.gson.JsonElement;
import com.mapbox.api.geocoding.v5.GeocodingCriteria;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenContext;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.Point;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

@Service
public class ReverseGeocodeSvc {

    public ReverseGeocodeSvc() {
    }

    public void getAddress(
            List<Double> cords,
            String token
    ) {
        MapboxGeocoding reverseGeocode = MapboxGeocoding.builder()
                .accessToken(token)
                .query(Point.fromLngLat(cords.get(0), cords.get(1)))
                .geocodingTypes(GeocodingCriteria.TYPE_ADDRESS)
                .build();

        reverseGeocode.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
               String zip = response.body().features().get(0).context().get(1).text();
//                System.out.println(zip);
            }

            @Override
            public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}



