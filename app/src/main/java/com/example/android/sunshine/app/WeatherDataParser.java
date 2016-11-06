package com.example.android.sunshine.app;

/**
 * Created by rishav on 06/11/16.
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

    /**
     * Given a string of the form returned by the api call:
     * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
     * retrieve the maximum temperature for the day indicated by dayIndex
     * (Note: 0-indexed, so 0 would refer to the first day).
     */
    public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
            throws JSONException {

        JSONObject root = new JSONObject(weatherJsonStr);
        JSONArray weatherlist = root.getJSONArray("list");


        JSONObject curDay = weatherlist.getJSONObject(dayIndex);
        double maxTemp = curDay.getJSONObject("temp").getDouble("max");

        return maxTemp;
    }

}
