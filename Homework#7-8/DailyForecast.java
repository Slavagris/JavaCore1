package Homework7;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;

public class DailyForecast {

    private Headline Headline;
    private ArrayList<DailyForecasts> DailyForecasts = new ArrayList<>();

    public DailyForecast() {
    }

    @JsonGetter("Headline")
    public Headline getHeadline() {
        return Headline;
    }

    @JsonSetter("Headline")
    public void setHeadline(Headline Headline) {
        this.Headline = Headline;
    }

    @JsonGetter("DailyForecasts")
    public ArrayList<DailyForecasts> getDailyForecasts() {
        return DailyForecasts;
    }

    @JsonSetter("DailyForecasts")
    public void setDailyForecasts(ArrayList<DailyForecasts> DailyForecasts) {
        this.DailyForecasts = DailyForecasts;
    }

    @Override
    public String toString() {
        return "OneDayForecast{" +
                "Headline=" + Headline +
                ", DailyForecasts=" + DailyForecasts +
                '}';
    }
}