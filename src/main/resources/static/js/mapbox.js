"use strict";


mapboxgl.accessToken = mapboxToken;


// map centering on San antonio
mapboxgl.accessToken = mapboxToken;
var map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/christopheraguirre210/ck2p39yeu1a061cks2xymzrtb',
    zoom: 15,
    center: [-98.4936, 29.4241]
    // pitch: 45
});

var markerOptions = {
    color: "#038f07",
    draggable: true
};

var restaurants = [
    {
        name: "Spaghetti Warehouse",
        location: "1226 E Houston St, San Antonio, TX 78205",
        description: "It's a good spaghetti!"
    },
    {
        name: "Mexican Manhattan",
        location: "110 Soledad St, San Antonio, TX 78205",
        description: "Lovely margaritas!"
    },
    {
        name: "River Center Mall",
        location: "849 E Commerce St, San Antonio, TX 78205",
        description: "The food court is pretty diverse."
    }
];


restaurants.forEach(function (restaurant,index) {
    geocode(restaurant.location, mapboxToken).then(function (result) {


        var pops = new mapboxgl.Popup()
            .setLngLat(result)
            .setHTML("<em><h2>"+restaurant.name+"</em></h2>" + "<br>" + restaurant.location + "<br>" + restaurant.description)
            .addTo(map);
        var marker = new mapboxgl.Marker(markerOptions)
            .setLngLat(result)
            .setPopup(pops)
            .togglePopup()
            .addTo(map);
        console.log("This is " + index + " foods!");
    });



function geocode(search, token) {
    var baseUrl = 'https://api.mapbox.com';
    var endPoint = '/geocoding/v5/mapbox.places/';
    return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
        .then(function(res) {
            return res.json();
            // to get all the data from the request, comment out the following three lines...
        }).then(function(data) {
            return data.features[0].center;
        });
}


    $("button").click(function () {
        var userInput = $("input").val();
        console.log(userInput);
        geocode(userInput, mapboxToken)
            .then(function (result) {
                console.log(result);
                marker.setLngLat(result);
                map.flyTo({center: result});
            });
    });
});

