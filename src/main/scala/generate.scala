import java.io.{BufferedWriter, FileOutputStream, OutputStreamWriter}
import java.util.UUID

import play.api.libs.json._


object generate extends App {
  val UNIXBASETIME = 1538172419000L
  val PAYLOADNUMBERS = 45000
  val r = new scala.util.Random
  val fileName = "webhookPayload.txt"
  val writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)))

  val placeArrivalTemplate = """{ "pilgrimVisitId":"4c4763f7646e38002cc51789", "eventType":"placeArrival", "timestamp":1548182419000, "placeEvent":{ "venues":[ { "id":"52af211911d2aa9d4a1f0e0a", "name":"Foursquare Chicago", "location":{ "address":"20 W Kinzie St", "crossStreet":"at N State St", "city":"Chicago", "state":"IL", "postalCode":"60606", "country":"US", "lat":41.889264, "lng":-87.628911 }, "categories":[ { "id":"4bf58dd8d48988d125941735", "name":"Tech Startup", "pluralName":"Tech Startups", "shortName":"Tech Startup", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/shops/technology_", "suffix":".png" }, "primary":true } ], "hierarchy":[ { "id":"577d3752498e0faef85a21c2", "name":"WeWork Kinzie", "categories":[ { "id":"4bf58dd8d48988d174941735", "name":"Coworking Space", "pluralName":"Coworking Spaces", "shortName":"Coworking Space", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/building/office_coworkingspace_", "suffix":".png" }, "primary":true } ] } ], "venueChains":[ { "id":"556e5779bd6a82902e28bcea", "name":"Foursquare" } ], "probability":0.33320653250353993 } ], "otherPossibleVenues":[ { "id":"577d3752498e0faef85a21c2", "name":"WeWork Kinzie", "location":{ "address":"20 W Kinzie St", "crossStreet":"at N Dearborn St", "city":"Chicago", "state":"IL", "postalCode":"60654", "country":"US", "lat":41.889511244213416, "lng":-87.62894332408905 }, "categories":[ { "id":"4bf58dd8d48988d174941735", "name":"Coworking Space", "pluralName":"Coworking Spaces", "shortName":"Coworking Space", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/building/office_coworkingspace_", "suffix":".png" }, "primary":true } ], "venueChains":[ { "id":"5569f639a7c8896abe7cb706", "name":"WeWork" } ] }, { "id":"5b0489c9b54618002cb921ee", "name":"Compass Regional HQ", "location":{ "address":"20 W Kinzie St Fl 15", "crossStreet":"N State St", "city":"Chicago", "state":"IL", "postalCode":"60654", "country":"US", "lat":41.889252, "lng":-87.62892 }, "categories":[ { "id":"4bf58dd8d48988d124941735", "name":"Office", "pluralName":"Offices", "shortName":"Office", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/building/default_", "suffix":".png" }, "primary":true }, { "id":"5032885091d4c4b30a586d66", "name":"Real Estate Office", "pluralName":"Real Estate Offices", "shortName":"Real Estate", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/shops/realestate_", "suffix":".png" } } ], "hierarchy":[ { "id":"4bbf57a082a2ef3b7a972cd2", "name":"20 W. Kinzie Building", "categories":[ { "id":"4bf58dd8d48988d130941735", "name":"Building", "pluralName":"Buildings", "shortName":"Building", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/building/default_", "suffix":".png" }, "primary":true } ] } ], "probability":0.09861296257083949 }, { "id":"59518d9706fb6023d22a9ad7", "name":"Southern Cut Barbeque", "location":{ "address":"20 W Kinzie St", "crossStreet":"", "city":"Chicago", "state":"IL", "postalCode":"60654", "country":"US", "lat":41.889384, "lng":-87.628605 }, "categories":[ { "id":"4bf58dd8d48988d1df931735", "name":"BBQ Joint", "pluralName":"BBQ Joints", "shortName":"BBQ", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/food/bbqalt_", "suffix":".png" }, "primary":true } ], "probability":0.04432434057492494 } ], "confidence":"high", "locationType":"venue", "arrivalTime":1548182419000 }, "lat":41.889303, "lng":-87.628898, "user":{ "adid":"40C23EBD-E21A-4ACC-A915-B1C80BDAF4FE", "userId":"CB25EFFB-C2B2-4E0F-B0E9-55C05BEFA4D4" }, "installId":"CB25EFFB-C2B2-4E0F-B0E9-55C05BEFA4D4", "sdkType":"iossdk", "segments":[ { "segmentId":162, "name":"The Foursquare Coffee Drinker - U.S." } ] }"""
  val placeDepartureTemplate = """{ "pilgrimVisitId":"4c4763f7646e38002cc51789", "eventType":"placeDeparture", "timestamp":1548201189000, "placeEvent":{ "venues":[ { "id":"52af211911d2aa9d4a1f0e0a", "name":"Foursquare Chicago", "location":{ "address":"20 W Kinzie St", "crossStreet":"at N State St", "city":"Chicago", "state":"IL", "postalCode":"60606", "country":"US", "lat":41.889264, "lng":-87.628911 }, "categories":[ { "id":"4bf58dd8d48988d125941735", "name":"Tech Startup", "pluralName":"Tech Startups", "shortName":"Tech Startup", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/shops/technology_", "suffix":".png" }, "primary":true } ], "hierarchy":[ { "id":"577d3752498e0faef85a21c2", "name":"WeWork Kinzie", "categories":[ { "id":"4bf58dd8d48988d174941735", "name":"Coworking Space", "pluralName":"Coworking Spaces", "shortName":"Coworking Space", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/building/office_coworkingspace_", "suffix":".png" }, "primary":true } ] } ], "venueChains":[ { "id":"556e5779bd6a82902e28bcea", "name":"Foursquare" } ] } ], "confidence":"high", "locationType":"venue", "arrivalTime":1548182419000, "departureTime":1548201189000 }, "lat":41.887604, "lng":-87.629599, "user":{ "adid":"40C23EBD-E21A-4ACC-A915-B1C80BDAF4FE", "userId":"CB25EFFB-C2B2-4E0F-B0E9-55C05BEFA4D4" }, "installId":"CB25EFFB-C2B2-4E0F-B0E9-55C05BEFA4D4", "sdkType":"iossdk", "segments":[ { "segmentId":162, "name":"The Foursquare Coffee Drinker - U.S." } ] }"""
  val geofenceEnterTemplate = """{ "eventType":"geofenceEnter", "timestamp":1545078269223, "geofenceEvent":{ "eventType":"entrance", "eventLat":41.8893897, "eventLng":-87.6297896, "radius":100.0, "venueId":"4a9037fef964a5209b1620e3", "categoryIds":"4bf58dd8d48988d1e0931735", "chainIds":"", "venues":[ { "id":"4a9037fef964a5209b1620e3", "name":"Einstein Bros Bagels", "location":{ "address":"400 N Dearborn St", "crossStreet":"", "city":"Chicago", "state":"IL", "postalCode":"60654", "country":"US", "lat":41.8893897, "lng":-87.6297896 }, "categories":[ { "id":"4bf58dd8d48988d179941735", "name":"Bagel Shop", "pluralName":"Bagel Shops", "shortName":"Bagels", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/food/bagels_", "suffix":".png" } }, { "id":"4bf58dd8d48988d1e0931735", "name":"Coffee Shop", "pluralName":"Coffee Shops", "shortName":"Coffee Shop", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/food/coffeeshop_", "suffix":".png" } } ], "venueChains":[ { "id":"556ce8d9aceaff43eb0588d6", "name":"Einstein Bros." } ] } ] }, "lat":41.88928251303856, "lng":-87.62870316744883, "user":{ "adid":"40C23EBD-E21A-4ACC-A915-B1C80BDAF4FE", "userId":"CB25EFFB-C2B2-4E0F-B0E9-55C05BEFA4D4" }, "installId":"CB25EFFB-C2B2-4E0F-B0E9-55C05BEFA4D4", "sdkType":"iossdk" }"""
  val geofenceDwellTemplate = """{ "eventType":"geofenceDwell", "timestamp":1545078408140, "geofenceEvent":{ "eventType":"dwell", "eventLat":41.8893897, "eventLng":-87.6297896, "radius":100.0, "venueId":"4a9037fef964a5209b1620e3", "categoryIds":"4bf58dd8d48988d1e0931735", "chainIds":"", "venues":[ { "id":"4a9037fef964a5209b1620e3", "name":"Einstein Bros Bagels", "location":{ "address":"400 N Dearborn St", "crossStreet":"", "city":"Chicago", "state":"IL", "postalCode":"60654", "country":"US", "lat":41.8893897, "lng":-87.6297896 }, "categories":[ { "id":"4bf58dd8d48988d179941735", "name":"Bagel Shop", "pluralName":"Bagel Shops", "shortName":"Bagels", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/food/bagels_", "suffix":".png" } }, { "id":"4bf58dd8d48988d1e0931735", "name":"Coffee Shop", "pluralName":"Coffee Shops", "shortName":"Coffee Shop", "icon":{ "prefix":"https://ss3.4sqi.net/img/categories_v2/food/coffeeshop_", "suffix":".png" } } ], "venueChains":[ { "id":"556ce8d9aceaff43eb0588d6", "name":"Einstein Bros." } ] } ] }, "lat":41.889335266663636, "lng":-87.62856037188838, "user":{ "adid":"40C23EBD-E21A-4ACC-A915-B1C80BDAF4FE", "userId":"CB25EFFB-C2B2-4E0F-B0E9-55C05BEFA4D4" }, "installId":"CB25EFFB-C2B2-4E0F-B0E9-55C05BEFA4D4", "sdkType":"iossdk" }"""

  for (i <- 1 to PAYLOADNUMBERS) {
    val uuid = UUID.randomUUID().toString
    val timestamp = UNIXBASETIME + 1000 * i
    val lat = r.between(-90.0, 90.0)
    val lng = r.between(-180.0, 180.0)

    val placeArrivalJSValue = Json.parse(placeArrivalTemplate)
    val placeDepartureJSValue = Json.parse(placeArrivalTemplate)
    val geofenceEnterJSValue = Json.parse(geofenceEnterTemplate)
    val geofenceDwellJSValue = Json.parse(geofenceDwellTemplate)

    val placeArrivalTransformer = (__ \ 'pilgrimVisitId ).json.update(
      __.read[JsString].map(_ => Json.toJson(uuid))
      ) andThen
      (__ \ 'timestamp ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(timestamp))
      ) andThen
      (__ \ 'lat ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(lat))
      ) andThen
      (__ \ 'lng ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(lng))
      )

    val placeDepartureTransformer = (__ \ 'pilgrimVisitId ).json.update(
      __.read[JsString].map(_ => Json.toJson(uuid))
    ) andThen
      (__ \ 'timestamp ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(timestamp + 1000 * 60))
      ) andThen
      (__ \ 'lat ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(lat))
      ) andThen
      (__ \ 'lng ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(lng))
      )

    val geofenceEnterTransformer =
      (__ \ 'timestamp ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(timestamp))
      ) andThen
      (__ \ 'lat ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(lat))
      ) andThen
      (__ \ 'lng ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(lng))
      )

    val geofenceDwellTransformer =
      (__ \ 'timestamp ).json.update(
        __.read[JsNumber].map(_ => Json.toJson(timestamp + 1000 * 60))
      ) andThen
        (__ \ 'lat ).json.update(
          __.read[JsNumber].map(_ => Json.toJson(lat))
        ) andThen
        (__ \ 'lng ).json.update(
          __.read[JsNumber].map(_ => Json.toJson(lng))
        )


    val placeArrivalResult = placeArrivalJSValue.transform(placeArrivalTransformer).asOpt.get
    writer.write(Json.stringify(placeArrivalResult) + "\n")

    val placeDepartureResult = placeArrivalJSValue.transform(placeDepartureTransformer).asOpt.get
    writer.write(Json.stringify(placeDepartureResult) + "\n")

    val geofenceEnterResult = geofenceEnterJSValue.transform(geofenceEnterTransformer).asOpt.get
    writer.write(Json.stringify(geofenceEnterResult) + "\n")

    val geofenceDwellResult = geofenceDwellJSValue.transform(geofenceDwellTransformer).asOpt.get
    writer.write(Json.stringify(geofenceDwellResult) + "\n")
//    println(Json.stringify(result))
  }

  writer.close()

}
