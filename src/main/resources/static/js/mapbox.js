$(document).ready(function () {
    let key = document.querySelector("#apiKey").content;
    mapboxgl.accessToken = key
    
    var map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v11',
        zoom: 9,
        center: [-98.4936, 29.4241]
    });
    
    var markerOptions = {
        color: "#038f07",
        draggable: false
    };
    var markerOptionsUser = {
        color: "blue",
        draggable: false
    };
    
    var marker = new mapboxgl.Marker(markerOptions)
        .setLngLat([-98.4936, 29.4241])
        .addTo(map);
    
    //!GEO CODE
    const geocode = (search, token) => {
        let baseUrl = 'https://api.mapbox.com';
        let endPoint = '/geocoding/v5/mapbox.places/';
        return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
            .then(function(res) {
                return res.json();
                // to get all the data from the request, comment out the following three lines...
            })
            .then(function(data) {
                return data.features[0].center;
            });
    }
    
    //! ADD CITY DATA TO ARRAY
    let points = [];
    const addCityDataToArray = () => {
        for (let i = 0; i < lowWaterPoints[0].features.length - 1; i++) {
            points.push(lowWaterPoints[0].features[i]);
        }
    }
    addCityDataToArray()
    
    
    //! SET CITY MARKERS
    
    const setCityMarkers = () => {
    console.log("AA")
        for (let i = 0; i < points.length - 1 && i < 9; i++) {
            
            const temp = points[i].geometry.coordinates;
            
            geocode(temp, key)
                .then(function (cords) {
                let pops = new mapboxgl.Popup()
                    .setLngLat(cords)
                    .setHTML("<em><h2>"+points[i].properties.Name+"</em></h2>")
                    .addTo(map);
                let marker = new mapboxgl.Marker(markerOptions)
                    .setLngLat(cords)
                    .setPopup(pops)
                    .togglePopup()
                    .addTo(map);
            });
    }

        //! IM NOT SURE WHAT THIS BUTTON FUNCTION IS DOING
        // $("button").click(function () {
        //     var userInput = $("input").val();
        //     console.log(userInput);
        //     geocode(userInput, key)
        //         .then(function (result) {
        //             marker.setLngLat(result);
        //             map.flyTo({center: result});
        //         });
        // });
    }
    setCityMarkers()
    
    
//! USER REPORTS
    let userReports;
    
    
    var request = $.ajax({'url': '/map/json'});
    request.done(function (reports) {
        userReports = reports;
        for (let i = 0; i < userReports.length && i < 9; i++) {
            
            const cord = [parseFloat(userReports[i].longitude), parseFloat(userReports[i].latitude)];
            geocode(cord, key).then(function (cords) {
                let html =`
            <em><h2>${userReports[i].description}</h2></em>
            <form action="/endorsement" method="post">
            <input type="hidden" name="\${_csrf.parameterName}" value="\${_csrf.token}"/>
            <input type="text" name="id" id="id" value="${userReports[i].id}" hidden>
            <input type="text" name="value" id="value" value="1" hidden>
            <button type="submit">Still there</button>
</form> `
                
                var pops = new mapboxgl.Popup()
                    .setLngLat(cords)
                    .setHTML(html)
                    .addTo(map);
                var marker = new mapboxgl.Marker(markerOptionsUser)
                    .setLngLat(cords)
                    .setPopup(pops)
                    .togglePopup()
                    .addTo(map);
                
                
            });
    

    
            function geocode(search, token) {
                var baseUrl = 'https://api.mapbox.com';
                var endPoint = '/geocoding/v5/mapbox.places/';
                return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
                    .then(function (res) {
                        return res.json();
                        // to get all the data from the request, comment out the following three lines...
                    })
                    .then(function (data) {
                        
                        return data.features[0].center;
                    });
            }
            
            //! THIS BUTTON FUNCTION
            // $("button").click(function () {
            //     var userInput = $("input").val();
            //     geocode(userInput, key)
            //         .then(function (result) {
            //             marker.setLngLat(result);
            //             map.flyTo({center: result});
            //         });
            // })
            
            
            
            
        }
    });
    
    

})