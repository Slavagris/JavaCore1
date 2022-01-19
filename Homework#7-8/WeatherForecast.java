package Homework7;
/**
* JavaСore 1 Homework#7-8
*
* @author Slava Grishin
* version 17.01.2022
* 
*/
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public interface WeatherForecast {
    public void getWeatherForecast(int option, String cityID) throws IOException, ParseException, ClassNotFoundException, SQLException;
    public void printDataFromDB() throws ClassNotFoundException, SQLException;
}
