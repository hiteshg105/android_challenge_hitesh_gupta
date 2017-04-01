package ixigo.ixigoflight.parser;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import Util.Utils;
import ixigo.ixigoflight.entity.Fares;
import ixigo.ixigoflight.entity.FlightResponse;
import ixigo.ixigoflight.entity.Flights;
import ixigo.ixigoflight.preferences.IxigoSharedPreferences;

/**
 * Created by hitesh on 4/1/17.
 */

public class JsonParser {

    public static FlightResponse parseFlightResponse(Context context, JSONObject jsonObject) {

        FlightResponse flightResponse = null;
        try {
            flightResponse = new FlightResponse();
            ArrayList<Flights> flightsArrayLists = new ArrayList<>();
            JSONObject appendix = jsonObject.getJSONObject("appendix");
            JSONObject airlines = appendix.getJSONObject("airlines");
            JSONObject airports = appendix.getJSONObject("airports");
            JSONObject providers = appendix.getJSONObject("providers");
            Map<String, Object> airlinesMap = Utils.jsonToMap(airlines);
            for (String s : airlinesMap.keySet()) {
                IxigoSharedPreferences.putString(context, s, (String) airlinesMap.get(s));
            }
            Map<String, Object> airportsMap = Utils.jsonToMap(airports);
            for (String s : airportsMap.keySet()) {
                IxigoSharedPreferences.putString(context, s, (String) airportsMap.get(s));
            }
            Map<String, Object> providersMap = Utils.jsonToMap(providers);
            for (String s : providersMap.keySet()) {
                IxigoSharedPreferences.putString(context, s, (String) providersMap.get(s));
            }
            JSONArray flights = jsonObject.getJSONArray("flights");
            for (int i = 0; i < flights.length(); i++) {
                JSONObject flightJson = flights.getJSONObject(i);

                JSONArray faresArray = flightJson.getJSONArray("fares");
                //                ArrayList<Fares> faresArrayObject = new ArrayList<Fares>();
                for (int j = 0; j < faresArray.length(); j++) {
                    String originCode = flightJson.getString("originCode");
                    String destinationCode = flightJson.getString("destinationCode");
                    long departureTime = flightJson.getLong("departureTime");
                    long arrivalTime = flightJson.getLong("arrivalTime");
                    String airlineCode = flightJson.getString("airlineCode");
                    String classCode = flightJson.getString("class");
                    Flights flight = new Flights();
                    flight.setOriginCode(originCode);
                    flight.setAirlineCode(airlineCode);
                    flight.setArrivalTime(arrivalTime);
                    flight.setDepartureTime(departureTime);
                    flight.setClassCode(classCode);
                    flight.setDestinationCode(destinationCode);
                    JSONObject faresJson = faresArray.getJSONObject(j);
                    int providerId = faresJson.getInt("providerId");
                    int fare = faresJson.getInt("fare");
                    Fares fares = new Fares();
                    fares.setFare(fare);
                    fares.setProviderId(providerId);
                    //                    faresArrayObject.add(fares);
                    flight.setFares(fares);
                    flightsArrayLists.add(flight);
                }

            }

            flightResponse.setFlights(flightsArrayLists);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return flightResponse;
    }
}
