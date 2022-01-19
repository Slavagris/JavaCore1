package Homework7;
/**
* JavaСore 1 Homework#7-8
*
* @author Slava Grishin
* version 17.01.2022
* 
*/
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

public class AccuweatherForecastModel implements WeatherForecast {
    // apiKey = "QfRAWNPVcQG5PvxrVGy1KHRHB1GLLH2u";
    public final String apiKey = "4IE3E0H7RIW6xId5Yefwqw1CwoAhlJQz";

    Connection addConnection = null;
    Connection getDataConnection = null;

    @Override
    public void getWeatherForecast(int option, String cityName) throws IOException, SQLException, ClassNotFoundException {

        ObjectMapper forecastObjectMapper = new ObjectMapper();

        String cityID = getCityIDByName(cityName);
        if (cityID.equals("(empty)")) return;

        OkHttpClient forecastClient = new OkHttpClient.Builder().build();

        switch (option) {
            case 1: { // Прогноз на 1 день
                HttpUrl oneDayForecastURL = new HttpUrl.Builder()
                        .scheme("http")
                        .host("dataservice.accuweather.com")
                        .addPathSegments("forecasts/v1/daily/1day/" + cityID)
                        .addQueryParameter("apikey", apiKey)
                        .addQueryParameter("metric", "true")
                        .build();

                Request oneDayForecastRequest = new Request.Builder()
                        .url(oneDayForecastURL)
                        .get()
                        .build();

                Response oneDayForecastResponse = forecastClient.newCall(oneDayForecastRequest).execute();

                String oneDayForecastResponseBody = oneDayForecastResponse.body().string();

                if (!oneDayForecastResponseBody.equals("[]")) {
                    DailyForecast oneDayForecast = forecastObjectMapper.readValue(oneDayForecastResponseBody, DailyForecast.class);
                    printForecast(oneDayForecast, cityName);
                    saveForecastToDB(oneDayForecast, cityName);
                }
                break;
            }
            case 2: {  // Прогноз на 5 дней

                HttpUrl fiveDaysForecastURL = new HttpUrl.Builder()
                        .scheme("http")
                        .host("dataservice.accuweather.com")
                        .addPathSegments("forecasts/v1/daily/5day/" + cityID)
                        .addQueryParameter("apikey", apiKey)
                        .addQueryParameter("metric", "true")
                        .build();

                Request fiveDaysForecastRequest = new Request.Builder()
                        .url(fiveDaysForecastURL)
                        .get()
                        .build();

                Response fiveDaysForecastResponse = forecastClient.newCall(fiveDaysForecastRequest).execute();

                String fiveDaysForecastResponseBody = fiveDaysForecastResponse.body().string();

                if (!fiveDaysForecastResponseBody.equals("[]")) {
                    DailyForecast fiveDaysForecast = forecastObjectMapper.readValue(fiveDaysForecastResponseBody, DailyForecast.class);
                    printForecast(fiveDaysForecast, cityName);
                    saveForecastToDB(fiveDaysForecast, cityName);
                }
                break;
            }
        }
    }

    private String getCityIDByName(String cityName) throws IOException {
        String cityID = "(empty)";

        OkHttpClient citySearchClient = new OkHttpClient.Builder()
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

        ObjectMapper citySearchObjectMapper = new ObjectMapper();

        if (!citySearchResponseBody.equals("[]")) {
            cityID = citySearchObjectMapper.readTree(citySearchResponseBody).get(0).at("/Key").asText();
        }
        return cityID;
    }


    public void printForecast(DailyForecast forecast, String cityName) {

        ArrayList<DailyForecasts> dailyForecasts = new ArrayList<>(forecast.getDailyForecasts());
        System.out.println("Прогноз погоды с " + dailyForecasts.get(0).getDate().substring(0, 10) + " в городе " + cityName);
        System.out.println();

        Iterator<DailyForecasts> iter = dailyForecasts.iterator();
        while (iter.hasNext()) {
            DailyForecasts dailyForecastIter = iter.next();
            System.out.println("Дата: " + dailyForecastIter.getDate().substring(0, 10) + "; " +
                    "максимальная температура " +
                    dailyForecastIter.getTemperatureObject().getMaximumObject().getValue() +
                    dailyForecastIter.getTemperatureObject().getMaximumObject().getUnit() + ", " +
                    "минимальная температура " +
                    dailyForecastIter.getTemperatureObject().getMinimumObject().getValue() +
                    dailyForecastIter.getTemperatureObject().getMinimumObject().getUnit()
            );
        }
        System.out.println();
        System.out.println("Основное событие на предстоящие 5 дней: "
                + forecast.getHeadline().getText()
                + " (" + forecast.getHeadline().getEffectiveDate().substring(0, 10) + ")");
    }

    public void saveForecastToDB(DailyForecast forecast, String cityName) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        addConnection = DriverManager.getConnection("jdbc:sqlite:accuweather.db");
        Statement addDataStatement = addConnection.createStatement();
        addDataStatement.executeUpdate("delete from forecast");

        ArrayList<DailyForecasts> dailyForecasts = new ArrayList<>(forecast.getDailyForecasts());

        Iterator<DailyForecasts> iter = dailyForecasts.iterator();
        while (iter.hasNext()) {
            DailyForecasts dailyForecastIter = iter.next();
            addDataStatement.executeUpdate("insert into forecast(city_name, first_date, forecast_date, min_temperature, max_temperature, headline) " +
                    "values ('" + cityName + "', '" +
                    dailyForecasts.get(0).getDate().substring(0, 10) + "', '" +
                    dailyForecastIter.getDate().substring(0, 10) + "', '" +
                    dailyForecastIter.getTemperatureObject().getMinimumObject().getValue() +
                    dailyForecastIter.getTemperatureObject().getMinimumObject().getUnit() + "', '" +
                    dailyForecastIter.getTemperatureObject().getMaximumObject().getValue() +
                    dailyForecastIter.getTemperatureObject().getMaximumObject().getUnit() + "', '" +
                    forecast.getHeadline().getText() + "')");
        }
        addConnection.close();
    }

    public void printDataFromDB() throws ClassNotFoundException, SQLException {

        String cityName = "";
        String minTempFromDB, maxTempFromDB;
        Class.forName("org.sqlite.JDBC");
        getDataConnection = DriverManager.getConnection("jdbc:sqlite:accuweather.db");
        Statement getDataStatement = getDataConnection.createStatement();
        DailyForecast forecast = new DailyForecast();
        Headline forecastHeadline = new Headline();

        ArrayList<DailyForecasts> dailyForecasts = new ArrayList<>();

        ResultSet forecastResults = getDataStatement.executeQuery("select * from forecast");

        while (forecastResults.next()) {
            if (forecastResults.isFirst()) {
                forecastHeadline.setEffectiveDate(forecastResults.getString("first_date"));
                forecastHeadline.setText(forecastResults.getString("headline"));
                forecast.setHeadline(forecastHeadline);
                cityName = forecastResults.getString("city_name");
            }
            DailyForecasts dailyForecast = new DailyForecasts();
            Temperature temperature = new Temperature();
            Maximum maximum = new Maximum();
            Minimum minimum = new Minimum();

            dailyForecast.setDate(forecastResults.getString("forecast_date"));
            minTempFromDB = forecastResults.getString("min_temperature");
            maxTempFromDB = forecastResults.getString("max_temperature");
            minimum.setUnit(minTempFromDB.substring(minTempFromDB.length() - 1, minTempFromDB.length()));
            minimum.setValue(Float.parseFloat(minTempFromDB.substring(0, minTempFromDB.length() - 1)));
            maximum.setUnit(maxTempFromDB.substring(maxTempFromDB.length() - 1, maxTempFromDB.length()));
            maximum.setValue(Float.parseFloat(maxTempFromDB.substring(0, maxTempFromDB.length() - 1)));
            temperature.setMinimumObject(minimum);
            temperature.setMaximumObject(maximum);
            dailyForecast.setTemperatureObject(temperature);
            dailyForecasts.add(dailyForecast);
        }
        forecast.setDailyForecasts(dailyForecasts);

        getDataConnection.close();

        printForecast(forecast, cityName);
    }
}
