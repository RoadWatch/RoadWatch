"use strict";

// mapboxgl.accessToken = mapboxToken;
let key = document.querySelector("#apiKey").textContent
mapboxgl.accessToken= document.querySelector("#apiKey").textContent
console.log("Key: ", key)

var lowWaterPoints = [
    {
        "type": "FeatureCollection",
        "features": [
            {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 1,
                    "Name": "Mauermann and Comanche Creek",
                    "CartID": "LWC_7070216",
                    "GlobalID": "6db52200-28d4-4238-86d0-1524edeece25"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.52055074595118, 29.283865969732013]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 2,
                    "Name": "Ledgestone at Mount Joy",
                    "CartID": "LWC_7070119",
                    "GlobalID": "c7de69ea-a028-4620-9b06-2802838b1947"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.46283686914663, 29.592721601054468]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 3,
                    "Name": "Leslie Rd 1850 ft SW of Braun Rd",
                    "CartID": "LWC_7070237",
                    "GlobalID": "afc98057-91b9-488f-b723-76568632b32e"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.68652676357398, 29.532384878183315]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 4,
                    "Name": "S Hausman Rd 4700 ft N of Prue Rd",
                    "CartID": "LWC_7070242",
                    "GlobalID": "e27e6322-a2ab-44b5-ab25-8de6e8c6723a"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.65576186956932, 29.557267451510135]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 5,
                    "Name": "Oak Knoll 500 ft E of E Horseshoe Bend",
                    "CartID": "LWC_7070255",
                    "GlobalID": "30112767-3e2b-4532-9b63-8d63a9fa8edf"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.59206068546892, 29.47311581341163]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 6,
                    "Name": "Bitters Rd 175 ft W of NE Entrance Rd",
                    "CartID": "LWC_7070173",
                    "GlobalID": "95b8e1e0-b5bd-43a4-a964-bc493f0873b1"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4577169958933, 29.539623370138283]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 7,
                    "Name": "Gibbs Sprawl 800 ft NE of Castle Cross",
                    "CartID": "LWC_7070189",
                    "GlobalID": "460ed7be-8666-4857-a033-705318668597"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.36906283685715, 29.4841101605612]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 8,
                    "Name": "New Sulphur Springs",
                    "CartID": "LWC_7070230",
                    "GlobalID": "d8584b5d-f241-495d-ad95-5ba27d298c24"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.34313652544323, 29.358785679399652]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 9,
                    "Name": "Villamain and Shane Rd at Railroad",
                    "CartID": "LWC_7070233",
                    "GlobalID": "8e479a63-3864-4281-86ea-dada455626d0"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.44325430590169, 29.317268755296976]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 10,
                    "Name": "Briarmall at Briarcrest Dr",
                    "CartID": "LWC_7070130",
                    "GlobalID": "e24a94d0-5d94-4630-bd8d-01d69232f9f3"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.40382826275778, 29.58031228972349]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 11,
                    "Name": "Jung at Salado Mud Creek Tributary A",
                    "CartID": "LWC_7070129",
                    "GlobalID": "30bc7b66-cd67-47ba-a0b3-dadf3c0bf131"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.41288414495504, 29.580156521443953]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 12,
                    "Name": "Judson Rd at Lookout Rd",
                    "CartID": "LWC_7070131",
                    "GlobalID": "c78d0158-4b7a-40b3-9cd6-5e5989b40409"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.36523239026869, 29.567591888988126]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 13,
                    "Name": "Blakely 200 ft W of Vandiver",
                    "CartID": "LWC_7070188",
                    "GlobalID": "ba6b0500-b922-4167-92d8-645403cc09d3"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.44284990297996, 29.485676298149755]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 14,
                    "Name": "Mission Parkway at San Antonio River",
                    "CartID": "LWC_7070213",
                    "GlobalID": "a92a316e-6b97-42b5-ad7d-80491d0b5b3a"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.47361574127233, 29.354500635672046]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 15,
                    "Name": "George Rd W of NW Military Hwy",
                    "CartID": "LWC_7070111",
                    "GlobalID": "64cfed76-9018-4933-9e8f-455c97973107"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.54059201247998, 29.56198757679116]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 16,
                    "Name": "Cave Ln",
                    "CartID": "LWC_7070182",
                    "GlobalID": "526aef5a-8053-44ee-929e-49a41fb1cc6f"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.44871019937632, 29.50872138234499]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 17,
                    "Name": "Old Corpus Christi S of Henderson Ct",
                    "CartID": "LWC_7070226",
                    "GlobalID": "ea84bcc9-0099-475f-967e-b4148a9c6c7d"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.45465648806339, 29.34196175910289]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 18,
                    "Name": "W Quill Dr at Heather Hill",
                    "CartID": "LWC_7070159",
                    "GlobalID": "05b03778-9ea7-4652-966a-85410e79dc2d"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.57368572907107, 29.46630322828386]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 19,
                    "Name": "North Loop 150 ft SE of W North Loop Rd",
                    "CartID": "LWC_7070151",
                    "GlobalID": "a135fb83-55c4-490b-a484-e90957e8a094"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4880786734873, 29.554014072200868]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 20,
                    "Name": "Nancy Carole Way 300 ft W of Southton",
                    "CartID": "LWC_7070232",
                    "GlobalID": "7194fdd5-cd77-4022-a8b2-a0c7e40ce953"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.43392286848861, 29.3203460733273]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 21,
                    "Name": "Majestic",
                    "CartID": "LWC_7070258",
                    "GlobalID": "dd89e621-5394-4bed-b0d6-f16af08976a2"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.59490377054195, 29.47079653976991]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 22,
                    "Name": "Nacogdoches Rd at Bulverde",
                    "CartID": "LWC_7070176",
                    "GlobalID": "4db56cbb-73bc-4fde-b9e4-726c8c476d5f"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.41822707919724, 29.543603621957484]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 23,
                    "Name": "Danville and Overbrook",
                    "CartID": "LWC_7070161",
                    "GlobalID": "e3e4bdbd-5654-4556-b933-0ab391c0307a"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.55155828509969, 29.480449357703034]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 24,
                    "Name": "Southwell 200 ft S of Verbena",
                    "CartID": "LWC_7070137",
                    "GlobalID": "a5f9d117-98d0-4ccc-85ae-ee0a8d4d4f38"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.58987679103689, 29.536488299254167]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 25,
                    "Name": "Southton Rd 4700 ft W of IH-37",
                    "CartID": "LWC_7070234",
                    "GlobalID": "40061979-78ae-4cfa-ac09-479aa66b2223"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.40862453420925, 29.289144713099237]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 26,
                    "Name": "Vicar 100 ft E of Perrin Beitel",
                    "CartID": "LWC_7070185",
                    "GlobalID": "9a7d23d1-b4be-4b98-986c-5240d2da4223"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.40950709129072, 29.511864732014253]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 27,
                    "Name": "N Verde Rd at French Creek",
                    "CartID": "LWC_7070246",
                    "GlobalID": "5b98eac8-0405-4df2-be64-b0458fe20876"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.64699906092227, 29.54109733365742]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 28,
                    "Name": "Bulverde Rd at Mud Creek Tributary A",
                    "CartID": "LWC_7070123",
                    "GlobalID": "9591a4bf-555a-43f9-a906-1d87c0eb3f71"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.42000147298359, 29.578471495929065]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 29,
                    "Name": "Rice Rd at Salado Creek",
                    "CartID": "LWC_7070249",
                    "GlobalID": "3d2e1c54-1b05-4eb9-99ec-21737a2860ec"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.41829561371462, 29.40887436376099]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 30,
                    "Name": "Ira Lee N of Austin Hwy",
                    "CartID": "LWC_7070187",
                    "GlobalID": "20453963-493b-456a-8724-3a0515cee7f6"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.42170092400814, 29.500134791251504]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 31,
                    "Name": "Stahl Rd S of Jung",
                    "CartID": "LWC_7070126",
                    "GlobalID": "cfcb3c6d-0e74-44b2-96e5-5dd4d0e692d2"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4065745212429, 29.573095620467623]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 32,
                    "Name": "Horal Dr at Revlon",
                    "CartID": "LWC_7070239",
                    "GlobalID": "79d196a0-2d41-415f-af7d-6bb91c72d9cb"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.65671560901664, 29.403433396729444]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 33,
                    "Name": "West Ave N of W North Loop Rd",
                    "CartID": "LWC_7070148",
                    "GlobalID": "99b6ba88-1815-4c3d-b365-2594f8978688"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.49812186261325, 29.556979964608885]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 34,
                    "Name": "Hausman Rd 200 ft E of Babcock",
                    "CartID": "LWC_7070101",
                    "GlobalID": "715e1827-4561-4c67-b769-8b69be3ed330"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.63074781375695, 29.572082445238426]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 35,
                    "Name": "Martinique",
                    "CartID": "LWC_7070201",
                    "GlobalID": "dbc9369b-5455-428a-b975-9d5114bd6a90"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62657693180637, 29.408051197688266]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 36,
                    "Name": "Lockhill 250 ft E of White Bonnet",
                    "CartID": "LWC_7070134",
                    "GlobalID": "26d5ed69-b565-4df4-81df-9d8b1e242739"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.60495979523147, 29.541721307331628]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 37,
                    "Name": "Vance Jackson at Orsinger Rd",
                    "CartID": "LWC_7070144",
                    "GlobalID": "a716eb67-8d15-4858-bf72-8c8a09586587"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.56714738287025, 29.549064560870743]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 38,
                    "Name": "S Verde Rd at French Creek",
                    "CartID": "LWC_7070245",
                    "GlobalID": "25629b38-5281-4833-8862-2276e07e55a9"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.64678387605339, 29.539133768236454]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 39,
                    "Name": "Southton Rd 2000 ft W of IH-37",
                    "CartID": "LWC_7070235",
                    "GlobalID": "67adf026-0da4-473d-a56f-d24c1831b502"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.40102642756447, 29.284279988080822]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 40,
                    "Name": "Leonhardt 500 ft S of Encante",
                    "CartID": "LWC_7070179",
                    "GlobalID": "a17bad6f-3a85-4b74-b24e-40fdf7309530"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.39160463340059, 29.547991460094863]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 41,
                    "Name": "Old Grissom 500 ft E of Culebra",
                    "CartID": "LWC_7070157",
                    "GlobalID": "2bb598b7-223e-46bc-bb93-723ea08cf56d"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.6532117203418, 29.475490299360004]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 42,
                    "Name": "Military and Westbriar",
                    "CartID": "LWC_7070198",
                    "GlobalID": "92a9e6d2-b7a6-4b5d-b80b-d4c92beef70d"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62918286928608, 29.409833464822796]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 43,
                    "Name": "Harness Lane 480 ft N of Marbach Rd",
                    "CartID": "LWC_7070199",
                    "GlobalID": "cf936a93-d7b3-4675-9c2d-93d654946abe"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.64705520351792, 29.419164692633576]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 44,
                    "Name": "Sleepy Hollow at Sunburst",
                    "CartID": "LWC_7070142",
                    "GlobalID": "0ead794a-61c0-4266-8e87-5b33adaa151c"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.56463671932919, 29.553558150113272]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 45,
                    "Name": "W North Loop Rd 1300 ft E of West Ave",
                    "CartID": "LWC_7070150",
                    "GlobalID": "e56e9a6c-a204-4038-9e0b-c9f2e51ddf2a"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.49533388671253, 29.555059691149854]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 46,
                    "Name": "Elm Creek at Jones Maltsberger",
                    "CartID": "LWC_7070122",
                    "GlobalID": "31e969f9-21cb-4ea4-9bfb-d3b163d76982"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.43464827051827, 29.595473380861332]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 47,
                    "Name": "Braun Rd 1300 ft NE of FM 1604",
                    "CartID": "LWC_7070236",
                    "GlobalID": "d73dd98b-c055-4c04-bdb4-17ff4c1f7dc3"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.68584880655351, 29.537699407447043]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 48,
                    "Name": "Mission Parkway S of Napier",
                    "CartID": "LWC_7070212",
                    "GlobalID": "41abe5b8-0ba9-45c7-aacf-13f7132a96d1"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.47161479396354, 29.353619450123343]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 49,
                    "Name": "Meadow Way 450 ft N of Marbach Rd",
                    "CartID": "LWC_7070200",
                    "GlobalID": "7e732303-7278-4568-9985-ebb399e248c4"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.64506458066371, 29.419140525688608]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 50,
                    "Name": "Westfield",
                    "CartID": "LWC_7070203",
                    "GlobalID": "93fb1f1e-e630-46dd-b4c6-547ae4f87199"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62658165846324, 29.406370135513907]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 51,
                    "Name": "Copperhill",
                    "CartID": "LWC_7070118",
                    "GlobalID": "f218b2c7-5c59-46ce-8f60-e86283544ebf"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.46109552165767, 29.5956915504944]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 52,
                    "Name": "Ray Ellison 300' N of Medina Base",
                    "CartID": "LWC_7070206",
                    "GlobalID": "09a301d4-20b0-44cb-9a41-a0b6911c92b8"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.64726949073159, 29.374792518716475]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 53,
                    "Name": "WW White at Rosillo Creek",
                    "CartID": "LWC_7070227",
                    "GlobalID": "87b2c6ac-1c57-4074-8daa-b37adc3436c9"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.39550181028109, 29.34760623348301]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 54,
                    "Name": "Nopal N of Fair Ave",
                    "CartID": "LWC_7070222",
                    "GlobalID": "92d143a3-22ec-4210-8e2b-e9a37b428ddd"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.45899595120086, 29.38517381287135]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 55,
                    "Name": "Bitters Rd 2600 ft W of NE Entrance",
                    "CartID": "LWC_7070171",
                    "GlobalID": "cd757a77-9842-4347-9163-8ff42a131e3d"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4635094771845, 29.54389249010927]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 56,
                    "Name": "Parkway 500 ft E of Callaghan",
                    "CartID": "LWC_7070253",
                    "GlobalID": "d7c74aba-e8c1-4634-9edc-fd2db78dca4b"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.59003996718309, 29.47675674031271]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 57,
                    "Name": "Verbena 1000 ft W of Southwell",
                    "CartID": "LWC_7070138",
                    "GlobalID": "2aebdff2-d0e0-4023-9233-3fc5eea3b366"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.59318754959277, 29.53699933741353]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 58,
                    "Name": "Devine 400 ft N of Dick Friedrich",
                    "CartID": "LWC_7070164",
                    "GlobalID": "3cc6038e-5884-4761-8d89-591fe43b8cd6"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4791327764859, 29.47986593288543]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 59,
                    "Name": "Weidner S of Leonhardt",
                    "CartID": "LWC_7070180",
                    "GlobalID": "390720eb-f6da-473b-ad50-e7223570147f"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.3822954720657, 29.547939071951664]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 60,
                    "Name": "Petaluma 2900 ft W of Bascum",
                    "CartID": "LWC_7070214",
                    "GlobalID": "e061e6c9-880e-4b2c-aae7-c6a13d3241d3"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.50155458779055, 29.33912569702478]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 61,
                    "Name": "New Sulphur Springs E of Beck",
                    "CartID": "LWC_7070231",
                    "GlobalID": "288416ec-6536-4155-a82b-a3fe1a7b53d2"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.31951006447683, 29.353860982678558]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 62,
                    "Name": "NE Entrance Rd 215 ft N of Bitters",
                    "CartID": "LWC_7070174",
                    "GlobalID": "b515f9ff-b627-4641-a5e0-abac116058ee"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4566910901674, 29.53962038299775]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 63,
                    "Name": "Prue Rd 1500 ft N of Bandera Rd",
                    "CartID": "LWC_7070243",
                    "GlobalID": "9c1198e2-8107-48dc-8ce2-92573ec6330a"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.65185560973238, 29.543724908919458]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 64,
                    "Name": "Sugar Crest",
                    "CartID": "LWC_7070117",
                    "GlobalID": "69d8914a-e00c-4a45-8d5e-0b203bbfb7ef"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.45968077942146, 29.59685145387294]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 65,
                    "Name": "New Sulphur Springs E of Jasper",
                    "CartID": "LWC_7070229",
                    "GlobalID": "597de57f-da3a-44d1-ba55-29b36a6131e0"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.37218874499267, 29.365453642090024]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 66,
                    "Name": "Arvil",
                    "CartID": "LWC_7070196",
                    "GlobalID": "3c5aac75-f7fe-4887-9334-4341f496ee58"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.61495399655554, 29.4116175130558]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 67,
                    "Name": "S New Braunfels at Koehler Ct",
                    "CartID": "LWC_7070223",
                    "GlobalID": "5c8a6547-7cba-4e4a-ab31-8bafedb9a66f"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4596244454888, 29.36570204545251]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 68,
                    "Name": "SilverCrest 100 ft NW of Majestic",
                    "CartID": "LWC_7070254",
                    "GlobalID": "d3bfeead-4336-4a86-b7ac-912d5176d89f"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.5962165245514, 29.47348088023184]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 69,
                    "Name": "Tallahasse",
                    "CartID": "LWC_7070202",
                    "GlobalID": "d2ac90c0-a966-4961-b8bb-6f848a52ec43"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62658155421147, 29.40722078108735]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 70,
                    "Name": "Stahl Rd N of Bell",
                    "CartID": "LWC_7070125",
                    "GlobalID": "96841928-1729-4691-8f19-0ef5de33fd44"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.40981231421551, 29.57070414741464]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 71,
                    "Name": "Mission Parkway",
                    "CartID": "LWC_7070225",
                    "GlobalID": "d2e54c19-80b4-4375-a4fa-c778dc6e2db9"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.46371690483006, 29.34633979380257]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 72,
                    "Name": "Weidner 500 ft N of Schertz",
                    "CartID": "LWC_7070181",
                    "GlobalID": "7977a07a-45c6-4162-bbd3-aec4bc3b1da3"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.38231939776625, 29.54311437414821]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 73,
                    "Name": "Dreamland at RR Crossing",
                    "CartID": "LWC_7070146",
                    "GlobalID": "35241972-2b20-4768-b18e-26f2cb33edcb"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.53995786694341, 29.53693469745158]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 74,
                    "Name": "W Commerce between Pinn Rd and Military",
                    "CartID": "LWC_7070193",
                    "GlobalID": "5e13d7fc-dfb6-4a0d-83ae-246c824480a0"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62902092837884, 29.436262622448]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 75,
                    "Name": "White Bonnet S of Lockhill",
                    "CartID": "LWC_7070135",
                    "GlobalID": "06c97e09-b911-4698-9b1e-d165f4699146"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.6056511963601, 29.541094951869738]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 76,
                    "Name": "Silvercrest between Woodside and Horseshoe",
                    "CartID": "LWC_7070158",
                    "GlobalID": "dc0b46fc-ad58-459f-a03b-fe05b1dbb5f0"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.5986059472474, 29.47344106253786]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 77,
                    "Name": "Classen Rd 800 feet NW of Stahl Rd",
                    "CartID": "LWC_7070128",
                    "GlobalID": "e8a21bde-2eeb-4158-9c37-548b28405149"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.40277055180113, 29.580140808675687]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 78,
                    "Name": "Gibbs Sprawl at Rosillo Creek",
                    "CartID": "LWC_7070190",
                    "GlobalID": "71b75c13-367e-477e-bf7d-2174a93f134b"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.3778624043907, 29.477797583035553]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 79,
                    "Name": "Hausman Rd 4200 ft W of IH-10",
                    "CartID": "LWC_7070105",
                    "GlobalID": "0d0aa44e-2390-4776-a3df-6eed24ea78bd"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.60747005887464, 29.572436143291824]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 80,
                    "Name": "Creekview W of Currency",
                    "CartID": "LWC_7070192",
                    "GlobalID": "9fedc42b-17dd-4a7b-9cdf-5a110d449881"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.41787658831348, 29.442353494780747]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 81,
                    "Name": "Old Seguin at Salado Creek",
                    "CartID": "LWC_7070191",
                    "GlobalID": "c2976284-9084-402e-b388-3e589e1dc200"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4236550477784, 29.450773506800946]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 82,
                    "Name": "McCullough 500 ft S of Jackson Keller",
                    "CartID": "LWC_7070154",
                    "GlobalID": "fa6610b3-7284-4405-8db5-68f40227a7bc"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.49172395954972, 29.49101064634547]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 83,
                    "Name": "Vance Jackson S of Treehill",
                    "CartID": "LWC_7070145",
                    "GlobalID": "f69866d1-a223-4bc2-a802-416b41d5d4dd"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.5599923183881, 29.543904297841113]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 84,
                    "Name": "Old Babcock Rd 2300 ft S of Nickle",
                    "CartID": "LWC_7070109",
                    "GlobalID": "af1364cc-b71b-4dd9-82f3-9edbbf9c6578"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.6276749174098, 29.563170462643473]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 85,
                    "Name": "Maltsberger Ln 925 ft E of San Pedro",
                    "CartID": "LWC_7070152",
                    "GlobalID": "6fc476c2-85e8-4d9b-8df2-234f182638c9"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.48146443076058, 29.55653438292866]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 86,
                    "Name": "Oak Knoll",
                    "CartID": "LWC_7070256",
                    "GlobalID": "ce8ac79c-24e5-4077-b655-14145f696d98"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.59864449478208, 29.471440619504712]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 87,
                    "Name": "Old Blanco Rd N of Voelcker",
                    "CartID": "LWC_7070112",
                    "GlobalID": "b09f016e-07db-4047-87a7-fdedf6ca535b"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.520413262616, 29.5638842469131]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 88,
                    "Name": "2100 Blk of Pinn Rd",
                    "CartID": "LWC_7070195",
                    "GlobalID": "30917a43-3359-46f6-b6cc-a4984c2123bc"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62402847646077, 29.410588801756322]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 89,
                    "Name": "Old Babcock Rd 3700 ft S of Nickle",
                    "CartID": "LWC_7070110",
                    "GlobalID": "00801dcd-e72d-49a8-9ff6-7b89fc41b1ef"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62608418692736, 29.560647050125148]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 90,
                    "Name": "N Graytown Rd at Tributary C to Salitrillo Creek",
                    "CartID": "LWC_7070250",
                    "GlobalID": "d4eda8c3-e21d-4127-bb21-b6a7bf656968"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.28926502164178, 29.4908598052083]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 91,
                    "Name": "Biscayne",
                    "CartID": "LWC_7070204",
                    "GlobalID": "9fccab09-1dcf-4a74-890f-387a96bc75a8"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62658927599367, 29.405521730501125]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 92,
                    "Name": "McCullough at Barbara",
                    "CartID": "LWC_7070153",
                    "GlobalID": "7d0ad17c-e43f-4971-a4fa-73d109b45c00"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.49174006283664, 29.503131327488344]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 93,
                    "Name": "Pinn Rd 1320 ft S of West Commerce",
                    "CartID": "LWC_7070194",
                    "GlobalID": "b8ab5452-98b8-4bfc-b7c8-a995b967e8b7"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.62370130094678, 29.432810230195305]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 94,
                    "Name": "New Sulphur Springs at Rosillo Creek",
                    "CartID": "LWC_7070248",
                    "GlobalID": "6d4ae58d-3478-4ba9-8522-d8b094d8a3e2"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.39230642577716, 29.37171913298069]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 95,
                    "Name": "Hildebrand at Kendall",
                    "CartID": "LWC_7070168",
                    "GlobalID": "56a1fc22-5929-4a77-bd43-2cb33cd96678"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.48828520411405, 29.466501863360175]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 96,
                    "Name": "S Hausman Rd 4300 ft N of Prue Rd",
                    "CartID": "LWC_7070240",
                    "GlobalID": "f898ace5-bb23-43a7-939a-87a7ce579668"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.65576120012685, 29.556009025305727]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 97,
                    "Name": "Hausman Rd at  Roadrunner",
                    "CartID": "LWC_7070102",
                    "GlobalID": "8db174cc-dd33-41fe-a60a-b002c81df001"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.6284706425135, 29.57212377021035]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 98,
                    "Name": "Ray Ellison at Old Valley Hi",
                    "CartID": "LWC_7070205",
                    "GlobalID": "23c67806-81b3-4507-8f0c-451aa1a9ba56"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.64788482459869, 29.37592518096698]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 99,
                    "Name": "Encino Park 2000 ft SW of Southwell",
                    "CartID": "LWC_7070139",
                    "GlobalID": "d50be344-210b-4b20-aa72-edcc12810980"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.5948170431716, 29.532404380175223]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 100,
                    "Name": "Oak Glen at Haskin",
                    "CartID": "LWC_7070183",
                    "GlobalID": "3da3b7ea-0a71-4f62-8aeb-b2cf4b93b895"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.44456281711575, 29.510816809800765]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 101,
                    "Name": "S Hausman Rd 3300 ft N of Prue Rd",
                    "CartID": "LWC_7070241",
                    "GlobalID": "01432830-6c00-4a16-af5e-fb00c18c011a"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.6557614727178, 29.553234218991793]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 102,
                    "Name": "Orsinger 250 W of Sleepy Hollow",
                    "CartID": "LWC_7070143",
                    "GlobalID": "426ff178-e16a-4746-9051-03bf7e578d87"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.56379421088748, 29.552536414791206]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 103,
                    "Name": "Old Fredericksburg Rd North of 1604",
                    "CartID": "LWC_7070103",
                    "GlobalID": "9af82ff3-b466-41d1-8c74-1b67c7c0c715"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.60247088685928, 29.59314548420551]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 104,
                    "Name": "West Ave at W North Loop Rd",
                    "CartID": "LWC_7070149",
                    "GlobalID": "1521e668-9ea7-4252-b8b5-3eb9043bcd67"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.50021020427293, 29.554804840231615]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 105,
                    "Name": "Cheever",
                    "CartID": "LWC_7070175",
                    "GlobalID": "a8493698-4356-4b71-880f-a310e7c51d10"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.45606591270976, 29.5176772674839]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 106,
                    "Name": "Ray Ellison at Hidden Valley",
                    "CartID": "LWC_7070207",
                    "GlobalID": "8c2e484f-a2b3-43b0-bc79-68176b1cdaf3"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.64341692001736, 29.367370935959617]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 107,
                    "Name": "Kingkrest E of Longleaf",
                    "CartID": "LWC_7070217",
                    "GlobalID": "a9dcc5ca-031c-4124-81af-e8293d06b2a7"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.41362580759768, 29.432694327153772]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 108,
                    "Name": "NE Entrance Rd 1000 ft S of Starcrest",
                    "CartID": "LWC_7070172",
                    "GlobalID": "53a6b7c4-43c1-4c84-9ac2-4383388b5218"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.45225596497635, 29.544032039209416]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 109,
                    "Name": "Old Babcock Rd 500 ft S of Nickle",
                    "CartID": "LWC_7070108",
                    "GlobalID": "f6a955f3-d949-4d47-a906-18a47a7a4c44"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.63090149226942, 29.566503939166317]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 110,
                    "Name": "Jung Rd at Mud Creek Tributary A",
                    "CartID": "LWC_7070124",
                    "GlobalID": "4ceb6d8a-6089-426c-b6dd-260edcf7b9cf"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.41940657722095, 29.578535511482887]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 111,
                    "Name": "Rittiman Rd at Salado Creek",
                    "CartID": "LWC_7070247",
                    "GlobalID": "fdd5bf83-555a-4a1a-95c4-3d5a730ed547"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.41678191408275, 29.484874631136066]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 112,
                    "Name": "Austin Hwy E of Ira Lee",
                    "CartID": "LWC_7070186",
                    "GlobalID": "1970dd51-8d79-4a2d-b365-b22419afce62"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.42125162459257, 29.50005879343583]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 113,
                    "Name": "Vandiver and Irvington",
                    "CartID": "LWC_7070184",
                    "GlobalID": "488d8e26-06ff-45e3-98ca-a90771b19da8"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.4421240608572, 29.493996199356488]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 114,
                    "Name": "Rodriguez and Leon Creek",
                    "CartID": "LWC_7070197",
                    "GlobalID": "c1a0c977-0162-4fc6-8f32-40388e1d8df8"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.61442476802813, 29.411657075683948]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 115,
                    "Name": "Old Camp Bullis Road at Leon Creek",
                    "CartID": "LWC_7070104",
                    "GlobalID": "c57c15d7-9af9-4f67-aa53-38331f354d6d"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.59893135974136, 29.621849697564446]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 116,
                    "Name": "Hiawatha E of Nopal",
                    "CartID": "LWC_7070221",
                    "GlobalID": "d9c1b166-6289-43c1-af60-a7b209853cc4"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.45799540808649, 29.386518756897967]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 117,
                    "Name": "Darwin between Kepler & Kettering",
                    "CartID": "LWC_7070160",
                    "GlobalID": "f9930fe6-6c55-4540-b5f3-d329c1ce1a79"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.59914202758132, 29.462817313682976]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 118,
                    "Name": "Judson Rd 100 ft SE of Lookout Rd",
                    "CartID": "LWC_7070132",
                    "GlobalID": "340e524a-c348-4c83-9352-d47bab1b605a"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.36520868738626, 29.56709805499574]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 119,
                    "Name": "Easterling S of Culebra",
                    "CartID": "LWC_7070156",
                    "GlobalID": "fcff5764-31d1-4a8a-8f4d-9dc5037d7e83"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.69149060609924, 29.48723568817737]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 120,
                    "Name": "Covel and Medio Creek",
                    "CartID": "LWC_7070208",
                    "GlobalID": "b1e7fb01-4eb6-4716-ab3c-2f5f11c8b5af"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.64638738183294, 29.350414945817164]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 121,
                    "Name": "Leslie Rd 3200 ft SW of Braun Rd",
                    "CartID": "LWC_7070238",
                    "GlobalID": "6daf3bc6-c64c-40f7-bf32-6476db39ed2e"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.68832904480573, 29.528821211207198]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 122,
                    "Name": "Nacogdoches Rd 750 ft S of Old Perrin Beitel",
                    "CartID": "LWC_7070177",
                    "GlobalID": "442c8dd0-5d88-416b-a9b6-2984db613027"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.41362574456116, 29.546732314130885]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 123,
                    "Name": "Jung Rd N of Stahl Rd",
                    "CartID": "LWC_7070127",
                    "GlobalID": "d328db99-a60d-4580-bf9a-07af14a6112c"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.40587778748704, 29.57480862589961]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 124,
                    "Name": "Quinta at Vista",
                    "CartID": "LWC_7070218",
                    "GlobalID": "73178069-8d66-464c-aaa2-1876009a8949"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.43422916870477, 29.39620140924858]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 125,
                    "Name": "Hausman Rd 1000 ft W of Babcock",
                    "CartID": "LWC_7070107",
                    "GlobalID": "d44c05e1-e3ae-4bf2-a0eb-d03a0acdf96e"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.63531892457657, 29.57192175521697]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 126,
                    "Name": "Medical Dr 2000 ft W of Wurzbach",
                    "CartID": "LWC_7070141",
                    "GlobalID": "cd696477-1f66-428b-8bbf-4166964d2d1a"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.58606385146888, 29.5110469551374]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 127,
                    "Name": "Contour Drive 500 ft E of McCullough",
                    "CartID": "LWC_7070155",
                    "GlobalID": "45d7df6e-aff9-4cb4-98fe-60a2cc469dbb"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.49006062508448, 29.484283832690856]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 128,
                    "Name": "West Ave S of Interpark",
                    "CartID": "LWC_7070116",
                    "GlobalID": "6545d6d7-db2f-451f-b860-674f4fdaad48"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.49409257421739, 29.56103107806346]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 129,
                    "Name": "Old OConnor N of Lookout Rd",
                    "CartID": "LWC_7070178",
                    "GlobalID": "41673632-99eb-43df-ad4d-afd63254e78d"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.37905701313969, 29.554428190779664]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 130,
                    "Name": "E Horseshoe Bend and Oakwood",
                    "CartID": "LWC_7070257",
                    "GlobalID": "4508107a-44f1-4656-a1e0-ed4e77ec591e"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.59299379466047, 29.472349837693354]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 131,
                    "Name": "Encino Grande S of Paso Del Norte",
                    "CartID": "LWC_7070114",
                    "GlobalID": "df61c591-472e-4e0c-a721-3ea4bf392ef8"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.47195379582963, 29.583157081557232]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 132,
                    "Name": "HollyHock 600 W of Babcock",
                    "CartID": "LWC_7070136",
                    "GlobalID": "c029830d-f8f4-4ced-adfe-c3c13afeac03"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.60813396455309, 29.53280329109988]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 133,
                    "Name": "Spencer Ln E of Balcones",
                    "CartID": "LWC_7070163",
                    "GlobalID": "254037a8-55a0-4dbb-a682-b2f17d4dd888"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.54051310471057, 29.484295236662927]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 134,
                    "Name": "Springhill",
                    "CartID": "LWC_7070120",
                    "GlobalID": "3cfb7a34-4010-48af-928a-f03d8676bbbc"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.46413982058057, 29.592638967516148]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 135,
                    "Name": "Danvers",
                    "CartID": "LWC_7070106",
                    "GlobalID": "ad2845bf-ff9d-4e97-be51-3d823be021d5"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.63342848907902, 29.570055327766724]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 136,
                    "Name": "Algerita Dr 1000 ft NW of Vance Jackson",
                    "CartID": "LWC_7070147",
                    "GlobalID": "1a78e436-3608-4e71-96ee-e3159604f987"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.53773663008828, 29.53031582514234]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 137,
                    "Name": "New Sulphur Springs N of Lodi",
                    "CartID": "LWC_7070228",
                    "GlobalID": "746e9dfc-3d73-4f83-9b91-41d5bec36a17"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.36412489203127, 29.364176705258437]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 138,
                    "Name": "Paso Del Norte 700 ft W of San Pedro",
                    "CartID": "LWC_7070113",
                    "GlobalID": "3a0df003-63be-4db2-9f26-fb2ef01f5d65"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.47372094709488, 29.583855768071544]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 139,
                    "Name": "E Mulberry at San Antonio River",
                    "CartID": "LWC_7070165",
                    "GlobalID": "1a67bd3a-3be1-48e8-abab-5623b87fea49"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.47593251597824, 29.45620650406397]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 140,
                    "Name": "Lookout Rd 200 ft SW of Topperwein",
                    "CartID": "LWC_7070133",
                    "GlobalID": "ced5e5a9-0643-4ff3-82b7-6653c822b02b"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.35722583850631, 29.569771928239785]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 141,
                    "Name": "Rio Seco 680 N of Brook Hollow",
                    "CartID": "LWC_7070115",
                    "GlobalID": "ac080538-159c-43b8-9c5c-33b6c2219add"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.468958559921, 29.57814194809769]
                }
            }, {
                "type": "Feature",
                "properties": {
                    "OBJECTID": 142,
                    "Name": "East of Padre Dr. at E. Pyron Street Bridge",
                    "CartID": "LWC_7070260",
                    "GlobalID": "79221ce2-e62f-4a03-a7ae-6299588d9814"
                },
                "geometry": {
                    "type": "Point",
                    "coordinates": [-98.47211049626361, 29.35856881675632]
                }
            }
        ]
    }
];


// map centering on San antonio
mapboxgl.accessToken = mapboxToken;
var map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/streets-v11',
    zoom: 10,
    center: [-98.4936, 29.4241]
    // pitch: 45
});

var markerOptions = {
    color: "#038f07",
    draggable: false
};

var marker = new mapboxgl.Marker(markerOptions)
    .setLngLat([-98.4936, 29.4241])
    .addTo(map);

var coordinates = $('#coordinates');


function onDragEnd(){
    var lngLat = marker.getLngLat();
}

marker.on('dragend', function () {
    var lngLat = marker.getLngLat();
});

marker.on('dragend', onDragEnd);

let points = [];
for (let i = 0; i < lowWaterPoints[0].features.length - 1; i++) {
    points.push(lowWaterPoints[0].features[i]);
}


for (let i = 0; i < points.length - 1 && i < 9; i++) {
    const temp = points[i].geometry.coordinates;
    // console.log(temp[0]);
    // console.log(temp[1]);

    geocode(temp, mapboxToken).then(function (cords) {
        var pops = new mapboxgl.Popup()
            .setLngLat(cords)
            .setHTML("<em><h2>"+points[i].properties.Name+"</em></h2>")
            .addTo(map);
        var marker = new mapboxgl.Marker(markerOptions)
            .setLngLat(cords)
            .setPopup(pops)
            .togglePopup()
            .addTo(map);
        console.log(points[i].properties.Name);
    });
    function geocode(search, token) {
        var baseUrl = 'https://api.mapbox.com';
        var endPoint = '/geocoding/v5/mapbox.places/';
        return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
            .then(function(res) {
                return res.json();
                // to get all the data from the request, comment out the following three lines...
            })
            .then(function(data) {
                return data.features[0].center;
            });
    }

    $("button").click(function () {
        var userInput = $("input").val();
        console.log(userInput);
        geocode(userInput, mapboxToken)
            .then(function (result) {
                marker.setLngLat(result);
                map.flyTo({center: result});
            });
    });
}
//! USER REPORTS
if (userReports !== null || userReports.length <= 0) {
    for (let i = 0; i < userReports.length - 1 && i < 9; i++) {
        const cord = [userReports.longitude, userReports.latitude];

        geocode(cord, mapboxToken).then(function (cords) {
            var pops = new mapboxgl.Popup()
                .setLngLat(cords)
                .setHTML("<em><h2>" + points[i].properties.Name + "</em></h2>")
                .addTo(map);
            var marker = new mapboxgl.Marker(markerOptions)
                .setLngLat(cords)
                .setPopup(pops)
                .togglePopup()
                .addTo(map);
            console.log(points[i].properties.Name);
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

        $("button").click(function () {
            var userInput = $("input").val();
            console.log(userInput);
            geocode(userInput, mapboxToken)
                .then(function (result) {
                    marker.setLngLat(result);
                    map.flyTo({center: result});
                });
        })
    }
}
//!



// lowWaterPoints[0].features.forEach(function (point) {
//     geocode(point.coordinates, mapboxToken).then(function (result) {
//
//         var pops = new mapboxgl.Popup()
//             .setLngLat(result)
//             .setHTML("<em><h2>"+point.properties.Name+"</em></h2>")
//             .addTo(map);
//         var marker = new mapboxgl.Marker(markerOptions)
//             .setLngLat(result)
//             .setPopup(pops)
//             .togglePopup()
//             .addTo(map);
//         console.log(point.properties.Name);
//     });
//
//     function geocode(search, token) {
//         var baseUrl = 'https://api.mapbox.com';
//         var endPoint = '/geocoding/v5/mapbox.places/';
//         return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
//             .then(function(res) {
//                 return res.json();
//                 // to get all the data from the request, comment out the following three lines...
//             }).then(function(data) {
//                 return data.features[0].center;
//             });
//     }
//
//     $("button").click(function () {
//         var userInput = $("input").val();
//         console.log(userInput);
//         geocode(userInput, mapboxToken)
//             .then(function (result) {
//                 marker.setLngLat(result);
//                 map.flyTo({center: result});
//             });
//     });
// });