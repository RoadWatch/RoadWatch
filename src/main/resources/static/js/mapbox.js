$(document).ready(function () {
    let points = [];
    let userPoints = []
    let key = document.querySelector("#apiKey").content;
    mapboxgl.accessToken = key;
    
    var map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v11',
        zoom: 9,
        center: [-98.4936, 29.4241],
        logoPosition: 'top-left'
    });
    
    
    
    var markerOptions = {
        color: "#FF7D4A",
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
        return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json?proximity=-98.4936, 29.4241&' + 'access_token=' + token)
            .then(function (res) {
                return res.json();
                // to get all the data from the request, comment out the following three lines...
            })
            .then(function (data) {
                return data.features[0].center
            })
    };
    
    //! ADD CITY DATA TO ARRAY
    const addCityDataToArray = () => {
        for (let i = 0; i < lowWaterPoints[0].features.length - 1; i++) {
            points.push(lowWaterPoints[0].features[i])
        }
    };
    addCityDataToArray();
    
    
    //! SET CITY MARKERS
    
    const setCityMarkers = () => {
        for (let i = 0; i < points.length - 1 && i < 9; i++) {
            const temp = points[i].geometry.coordinates;
            
            geocode(temp, key)
                .then(function (cords) {
                    let pops = new mapboxgl.Popup()
                        .setLngLat(cords)
                        .setHTML("<div id='pop-up'> " +
                            "<h6 id='property-name'>" + points[i].properties.Name + "</h6>" +
                            "<div id='property-d'>" +
                            "<p class='text-center'>" +
                            "(" + points[i].properties.Description + ")</p>" +
                            " </div>" +
                            points[i].properties.Date  + "<br>" +
                            "<a href='#city-"+(i+1)+"'>View report</a>" +
                            "</div>")
                        .addTo(map);
                    let marker = new mapboxgl.Marker(markerOptions)
                        .setLngLat(cords)
                        .setPopup(pops)
                        .togglePopup()
                        .addTo(map)
                });
        }
        
    };
    setCityMarkers();

//!function to add click events
    const addClickEventForEndorsementPost = (arr) => {
        $.each(arr, function (i) {
            $(document).on('click', `#${arr[i]}`, function () {
                let idArray = arr[i].split('-');
                let token = $("meta[name='_csrf']").attr("content");
                $.ajax({
                    url: `/endorsements/${idArray[1]}/${idArray[2]}`,
                    headers: {"X-CSRF-TOKEN": token},
                    type: 'POST',
                    success: function (result) {
                        window.location = "/map"
                        console.log("SUCCESS")
                    }
                })
            })
        })
    };



//! USER REPORTS
    const fetchUserPoints = () => {
        let userReports;
        let request = $.ajax({'url': '/map/json'});
        request.done(function (reports) {
            let endorsementButtonIds = [];
            userReports = reports;
            for (let i = 0; i < userReports.length && i < 9; i++) {
                //push buttons with id's into array
                endorsementButtonIds.push(`endorsement-${userReports[i].id}-1`);
                endorsementButtonIds.push(`endorsement-${userReports[i].id}-2`);
                
                const cord = userReports[i].query;//[parseFloat(userReports[i].longitude), parseFloat(userReports[i].latitude)];
                geocode(cord, key)
                    .then(function (cords) {
                        let html = `

            <div class="d-flex flex-wrap" id="pop-up-user">
            <h6 id="property-name-user">${userReports[i].query.toUpperCase()}</h6>
            <div id="property-d-user">
            <p>${userReports[i].description}</p>
            </div>
            ${userReports[i].dateEntered} <br>
            <a href="#${userReports[i].id}" style="margin-left: 20px">View Report</a> <br>
            `;

                        if (parseInt(userReports[i].waterInches) >= 1) {
                            html += `<div class="water-level">Water level: ${userReports[i].waterInches}</div>`;
                        } else {
                            html += `<div class="water-level">Water level: N/A</div>`;
                        }
                        for (let j = 0; j < userReports[i].jsoncategories.length; j++) {
                            html += `<span class="pills">${userReports[i].jsoncategories[j]}</span>`;
                        }

                        html += "</div>";

                        let pops = new mapboxgl.Popup()
                            .setLngLat(cords)
                            .setHTML(html)
                            .addTo(map);
                        let marker = new mapboxgl.Marker(markerOptionsUser)
                            .setLngLat(cords)
                            .setPopup(pops)
                            .togglePopup()
                            .addTo(map);
                        
                        
                    })
            }
            addClickEventForEndorsementPost(endorsementButtonIds)
        });
        request.fail(function (e) {
            console.log("e; ");
        });
    };
    
    fetchUserPoints();
    
    //! FLY TO FUNCTION
    const flyToFunc = (search) => {
        geocode(search, key)
            .then(function (result) {
                map.flyTo({
                    center: result,
                    zoom: 13,
                })
            })
    };
    
    $(document).on('click', '#zipcode-button', function (e) {
        let input = $('#zipcode-input');
        flyToFunc(input.val())
    });
    //! GET URL PARAMETERS
    const getUrlVars = () => {
        let vars = {};
        let parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
            vars[key] = value;
        });
        return vars;
    };
    
    //! SET BEXAR COUNTY CARDS

    const setBexarCountyCards = (lowWaterPoints) => {
        let html = "";
        if(lowWaterPoints.length > 0){
            for (let i = 0; i < lowWaterPoints.length; i++) {
                if(i === 10 ) break;
            html += `
<div class="card m-auto report-card county" id="city-${i+1}" >
                <img
                        src="https://search.bexar.org/Content/images/BexarLogo.png"
                        class="card-img-top px-5" alt="report_img"
                        id="report-card-img">
                <div class="card-body county-body">
                <div class="county-inner">
                                    <h5 class="card-title text-center">${lowWaterPoints[i].properties.Name}</h5>
                    <small>
                    <hr>
                        <span>Author: Bexar County</span>
                    </small>
                    <p class="card-text">${lowWaterPoints[i].properties.Description}</p>
                </div>
</div>

                    <hr>
                    <p class="ml-2">${lowWaterPoints[i].properties.Date}</p>
                </div>
`;
            }
        }
            $('#city-row').html(html);


    };
    setBexarCountyCards(points);
    
    const getCardsForSearchBar = () => {
        $(document).on('click', '#UserReportSearchButton', function (e) {
            e.preventDefault();
            let searchBarVal = $('#userReportSearch').val();
            let firstTenReports = points.slice(0,10);
            
            let filteredCountyReports = filterResultForCountyData(firstTenReports, searchBarVal);
            
            //! filter county reports

            //! Filter user reports
            let request = $.ajax({'url': '/map/json'});
            request.done(function (reports) {
                let queriedUserResults = filterResultForUserData(reports, searchBarVal)
                setQueriedCountyReports(filteredCountyReports)
                setQueriedUserReports(queriedUserResults)
            })
        })
    }
    //! The county data has different properties than user
    const filterResultForCountyData = (arr, query) => {
        let result = []
        arr.forEach((report, i) => {
            if(report.properties.Name.toLowerCase().includes(query.toLowerCase()))
                result.push(report);
            else if(report.properties.Description.toLowerCase().includes(query.toLowerCase()))
                result.push(report)
        })
        return result
    }
    
    const filterResultForUserData = (arr, query) => {
        let result = []
        arr.forEach((report, i) => {
            if(report.query.toLowerCase().includes(query.toLowerCase()))
                result.push(report)
            else if(report.description.toLowerCase().includes(query.toLowerCase))
                result.push(report)
        })
        return result
    }
    
    const setQueriedCountyReports = reports => {
        let html = ""
        reports.forEach((report,i) => {
            html += `
<div class="card m-auto report-card county" id="city-${report.properties.OBJECTID}" >
                <img
                        src="https://search.bexar.org/Content/images/BexarLogo.png"
                        class="card-img-top px-5" alt="report_img"
                        id="report-card-img">
                <div class="card-body county-body">
                <div class="county-inner">
                                    <h5 class="card-title text-center">${report.properties.Name}</h5>
                    <small>
                    <hr>
                        <span>Author: Bexar County</span>
                    </small>
                    <p class="card-text">${report.properties.Description}</p>
                </div>
</div>

                    <hr>
                    <p class="ml-2">${report.properties.Date}</p>
                </div>
`;
        })
        $('#city-row').html(html);
    }
    
    const setQueriedUserReports = reports => {
        let html = ''
        let buttonIds = []
        reports.forEach((report, i) => {
            buttonIds.push(`endorsement-${report.id}-2`)
            html += `
            <div class="card m-auto user" id="${report.id}">
                <img
                        src="${report.filePath == null ? 'https://pbs.twimg.com/profile_images/1191407906912161801/c1oHDM_9_400x400.jpg' : report.filePath}"
                        class="card-img-top px-5 py-2" alt="report_img"
                        id="report-card-img">
                        <div class="card-body user-body"
                                id="card-body">
                            <div class="user-inner">
                                <h5 class="card-title text-center">
                                ${report.query.toUpperCase()}
</h5>
                                <hr>
                                <small>
                                    Author: <span>
                                    ${report.user.username.toUpperCase()}
</span>
                                </small>
                                <p class="card-text report-description"
                                >${report.description}</p> <hr>`
                                if(report.waterInches == 0 ){
                                    html +=
                                        `<div class="water-level-html">
                                            Water Level: N/A </div>`
                                }else {
                                    html +=
                                        `<div class="water-level-html">
                                            Water Level: ${report.waterInches}". </div>`
                                }
                                html += `<div  id="card-pill-wrapper">`
            for (let j = 0; j < report.jsoncategories.length; j++) {
                html += `<span class="card-pill">${report.jsoncategories[i]}</span>`;
            }
            html += `</div>`
                                

                                   html+=     `
                                            <div class="d-flex justify-content-center">
                                            <button type="submit"
                                                class="btn btn-outline-light text-light downvote-button m-auto"
                                                id="endorsement-${report.id}-2">
                                            <i class="fas fa-road"></i>
                                            Reported cleared?
                                        </button>
                                        </div>
                                <!--                                end inner-->
                            </div>
<!--                            end-->
                        </div>



                        
                        <hr>
                        <p
                         class="ml-2"> ${report.dateEntered}</p>
            </div>
`
        })
        addClickEventForEndorsementPost(buttonIds)
        $('#card-row').html(html)
    }

    getCardsForSearchBar()
    

});



