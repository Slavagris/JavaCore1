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
import java.util.Scanner;

public class WeatherForecastView {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        WeatherForecastController weatherForecastController = new WeatherForecastController();

        while (true) {
            System.out.println();
            System.out.println("Введите город: ");
            String cityForSearch = scanner.nextLine();
            System.out.println("Введите \"1\" для прогноза на 1 день, \"2\" для прогноза на 5 дней, \"9\" для вывода из БД, \"0\" для выхода: ");
            switch (scanner.nextLine()) {
                case "0":
                    return;
                case "1":
                    try {
                        weatherForecastController.weatherForecast.getWeatherForecast(1, cityForSearch);
                    } catch (IOException | ParseException | ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    try {
                        weatherForecastController.weatherForecast.getWeatherForecast(2, cityForSearch);
                    } catch (IOException | ParseException | ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case "9":
                    try {
                        weatherForecastController.weatherForecast.printDataFromDB();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Неправильный ввод, попробуйте еще раз...");
                    break;
            }
        }
    }
}
