package Homework6;

import java.io.IOException;
public class Main {
    static String cityName = "saint petersburg";
    static String cityID;
    static String forecastJSON;

    public static void main(String[] args) {
        WeatherApp weatherApp = new WeatherApp();
        try {
            cityID = weatherApp.searchCityByName(cityName);
            forecastJSON = weatherApp.get5DayForecast(cityID);
            System.out.println("Result = " + forecastJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}