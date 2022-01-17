package Homework7;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public interface WeatherForecast {
    public void getWeatherForecast(int option, String cityID) throws IOException, ParseException, ClassNotFoundException, SQLException;
    public void printDataFromDB() throws ClassNotFoundException, SQLException;
}