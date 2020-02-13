package com.codeup.demo.services;

import com.codeup.demo.Repos.Reports;
import com.codeup.demo.models.Report;
import com.codeup.demo.models.User;
import com.mapbox.api.geocoding.v5.MapboxGeocoding;
import com.mapbox.api.geocoding.v5.models.CarmenFeature;
import com.mapbox.api.geocoding.v5.models.GeocodingResponse;
import com.mapbox.geojson.Point;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;
import java.util.List;
@Service
public class GeocodeSvc {
    private Reports reportsDao;
    private UserSvc userSvc;


    public GeocodeSvc(Reports reportsDao, UserSvc userSvc) {
        this.reportsDao = reportsDao;
        this.userSvc = userSvc;
    }

    public void executeSearch(
            String query, String token, User user, Report report
    ){
        List<Double> functionLevelCoordinates = new ArrayList<>();
        String functionLevelZipcode;
        MapboxGeocoding mapboxGeocoding =
                MapboxGeocoding.builder()
                        .accessToken(token)
                        .query(query)
                        .build();

        mapboxGeocoding.enqueueCall(new Callback<GeocodingResponse>() {
            @Override
            public void onResponse(Call<GeocodingResponse> call, Response<GeocodingResponse> response) {
                List<CarmenFeature> results = response.body().features();
                if(results.size() > 0){
                    //! LNG, LAT
                  List<Double> coordinates = results.get(0).center().coordinates();
                  String zipcode = response.body().features().get(0).context().get(1).text();
                  createReport(coordinates,zipcode, user, report);
//                    System.out.println("Cords: "+coordinates.toString());
//                    String carmen = response.body().features().get(0).toString();
                }
            }

            @Override
            public void onFailure(Call<GeocodingResponse> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });

    }
    //! THE API DATA CAN ONLY BE HANDLED BY PASSING PARAMETERS
    private void createReport(
            List<Double> coords,
            String zip,
            User user,
            Report report
    ){
        int zipcode = checkIfZipcodeIsDigits(zip) ?
                Integer.parseInt(zip) : 78205;
        System.out.println("ziip: "+ zipcode);
        Double lng = coords.get(0);
        Double lat = coords.get(1);

        //update report
        report.setZipcode(zipcode);
        report.setLongitude(lng.toString());
        report.setLatitude(lat.toString());
        report.setUser(user);
        reportsDao.save(report);
        System.out.println(report.toString());
        System.out.println(report.getUser().getFirstName());
    }

    private boolean checkIfZipcodeIsDigits(String zipcode){
        return zipcode.matches("[0-9]{5}");
    }


}



