package Homework6;

import okhttp3.*;
import java.io.IOException;
public class WeatherApp {
    public final String apiKey = "QfRAWNPVcQG5PvxrVGy1KHRHB1GLLH2u";
    public String cityID; // = "295212" ID Санкт-Петербурга

    public String searchCityByName(String cityName) throws IOException {

        OkHttpClient citySearchClient = new OkHttpClient
                .Builder()
                .build();

        HttpUrl citySearchURL = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("locations/v1/cities/search")
                .query("apikey=" + apiKey + "&q=" + cityName)
                .build();

        Request citySearchRequest = new Request.Builder()
                .url(citySearchURL)
                .get()
                .build();

        Response citySearchResponse = citySearchClient.newCall(citySearchRequest).execute();

        String citySearchResponseBody = citySearchResponse.body().string();
        cityID = citySearchResponseBody.substring(21, 27);

        return cityID;
    }

    public String get5DayForecast(String cityID) throws IOException {
        OkHttpClient forecastHttpClient = new OkHttpClient();
        HttpUrl forecastUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/5day/" + cityID)
                .query("apikey=" + apiKey)
                .build();

        System.out.println(forecastUrl);

        Request forecastRequest = new Request.Builder()
                .url(forecastUrl)
                .get()
                .build();

        Response forecastResponse = forecastHttpClient.newCall(forecastRequest).execute();

        System.out.println(forecastResponse.isSuccessful());
        System.out.println(forecastResponse.code());
        //System.out.println(forecastResponse.headers());
        String forecastResponseJSON = forecastResponse.body().string();

        return forecastResponseJSON;
    }
}