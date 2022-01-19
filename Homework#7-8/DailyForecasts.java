package Homework7;
/**
* JavaСore 1 Homework#7-8
*
* @author Slava Grishin
* version 17.01.2022
* 
*/

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;

public class DailyForecasts {
    private String Date;
    private float EpochDate;
    private Temperature TemperatureObject;
    private Day DayObject;
    private Night NightObject;
    private ArrayList<String> Sources = new ArrayList<>();
    private String MobileLink;
    private String Link;

    public DailyForecasts() {
    }

    @Override
    public String toString() {
        return "DailyForecasts{" +
                "Date='" + Date + '\'' +
                ", EpochDate=" + EpochDate +
                ", TemperatureObject=" + TemperatureObject +
                ", DayObject=" + DayObject +
                ", NightObject=" + NightObject +
                ", Sources=" + Sources.toString() +
                ", MobileLink='" + MobileLink + '\'' +
                ", Link='" + Link + '\'' +
                '}';
    }

    @JsonGetter("Date")
    public String getDate() {
        return Date;
    }

    @JsonSetter("Date")
    public void setDate(String date) {
        Date = date;
    }

    @JsonGetter("EpochDate")
    public float getEpochDate() {
        return EpochDate;
    }

    @JsonSetter("EpochDate")
    public void setEpochDate(float epochDate) {
        EpochDate = epochDate;
    }

    @JsonGetter("Temperature")
    public Temperature getTemperatureObject() {
        return TemperatureObject;
    }

    @JsonSetter("Temperature")
    public void setTemperatureObject(Temperature temperatureObject) {
        TemperatureObject = temperatureObject;
    }

    @JsonGetter("Day")
    public Day getDayObject() {
        return DayObject;
    }

    @JsonSetter("Day")
    public void setDayObject(Day dayObject) {
        DayObject = dayObject;
    }

    @JsonGetter("Night")
    public Night getNightObject() {
        return NightObject;
    }

    @JsonSetter("Night")
    public void setNightObject(Night nightObject) {
        NightObject = nightObject;
    }

    @JsonGetter("Sources")
    public ArrayList<String> getSources() {
        return Sources;
    }

    @JsonSetter("Sources")
    public void setSources(ArrayList<String> sources) {
        Sources = sources;
    }

    @JsonGetter("MobileLink")
    public String getMobileLink() {
        return MobileLink;
    }

    @JsonSetter("MobileLink")
    public void setMobileLink(String mobileLink) {
        MobileLink = mobileLink;
    }

    @JsonGetter("Link")
    public String getLink() {
        return Link;
    }

    @JsonSetter("Link")
    public void setLink(String link) {
        Link = link;
    }
}

class Temperature {
    private Minimum MinimumObject;
    private Maximum MaximumObject;

    public Temperature() {
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "MinimumObject=" + MinimumObject +
                ", MaximumObject=" + MaximumObject +
                '}';
    }

    @JsonGetter("Minimum")
    public Minimum getMinimumObject() {
        return MinimumObject;
    }

    @JsonSetter("Minimum")
    public void setMinimumObject(Minimum minimumObject) {
        MinimumObject = minimumObject;
    }

    @JsonGetter("Maximum")
    public Maximum getMaximumObject() {
        return MaximumObject;
    }

    @JsonSetter("Maximum")
    public void setMaximumObject(Maximum maximumObject) {
        MaximumObject = maximumObject;
    }
}

class Maximum {
    private float Value;
    private String Unit;
    private float UnitType;

    public Maximum() {
    }

    @Override
    public String toString() {
        return "Maximum{" +
                "Value=" + Value +
                ", Unit='" + Unit + '\'' +
                ", UnitType=" + UnitType +
                '}';
    }

    @JsonGetter("Value")
    public float getValue() {
        return Value;
    }

    @JsonSetter("Value")
    public void setValue(float value) {
        Value = value;
    }

    @JsonGetter("Unit")
    public String getUnit() {
        return Unit;
    }

    @JsonSetter("Unit")
    public void setUnit(String unit) {
        Unit = unit;
    }

    @JsonGetter("UnitType")
    public float getUnitType() {
        return UnitType;
    }

    @JsonSetter("UnitType")
    public void setUnitType(float unitType) {
        UnitType = unitType;
    }
}

class Minimum {
    private float Value;
    private String Unit;
    private float UnitType;

    public Minimum() {
    }

    @Override
    public String toString() {
        return "Minimum{" +
                "Value=" + Value +
                ", Unit='" + Unit + '\'' +
                ", UnitType=" + UnitType +
                '}';
    }

    @JsonGetter("Value")
    public float getValue() {
        return Value;
    }

    @JsonSetter("Value")
    public void setValue(float value) {
        Value = value;
    }

    @JsonGetter("Unit")
    public String getUnit() {
        return Unit;
    }

    @JsonSetter("Unit")
    public void setUnit(String unit) {
        Unit = unit;
    }

    @JsonGetter("UnitType")
    public float getUnitType() {
        return UnitType;
    }

    @JsonSetter("UnitType")
    public void setUnitType(float unitType) {
        UnitType = unitType;
    }
}

class Day {
    private float Icon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private String PrecipitationType;
    private String PrecipitationIntensity;

    public Day() {
    }


    @Override
    public String toString() {
        return "Day{" +
                "Icon=" + Icon +
                ", IconPhrase='" + IconPhrase + '\'' +
                ", HasPrecipitation=" + HasPrecipitation +
                '}';
    }

    @JsonGetter("Icon")
    public float getIcon() {
        return Icon;
    }

    @JsonSetter("Icon")
    public void setIcon(float icon) {
        Icon = icon;
    }

    @JsonGetter("IconPhrase")
    public String getIconPhrase() {
        return IconPhrase;
    }

    @JsonSetter("IconPhrase")
    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    @JsonGetter("HasPrecipitation")
    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    @JsonSetter("HasPrecipitation")
    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    @JsonGetter("PrecipitationType")
    public String getPrecipitationType() {
        return PrecipitationType;
    }

    @JsonSetter("PrecipitationType")
    public void setPrecipitationType(String precipitationType) {
        PrecipitationType = precipitationType;
    }

    @JsonGetter("PrecipitationIntensity")
    public String getPrecipitationIntensity() {
        return PrecipitationIntensity;
    }

    @JsonSetter("PrecipitationIntensity")
    public void setPrecipitationIntensity(String precipitationIntensity) {
        PrecipitationIntensity = precipitationIntensity;
    }
}

class Night {
    private float Icon;
    private String IconPhrase;
    private boolean HasPrecipitation;
    private String PrecipitationType;
    private String PrecipitationIntensity;

    public Night() {
    }

    @Override
    public String toString() {
        return "Night{" +
                "Icon=" + Icon +
                ", IconPhrase='" + IconPhrase + '\'' +
                ", HasPrecipitation=" + HasPrecipitation +
                '}';
    }

    @JsonGetter("Icon")
    public float getIcon() {
        return Icon;
    }

    @JsonSetter("Icon")
    public void setIcon(float icon) {
        Icon = icon;
    }

    @JsonGetter("IconPhrase")
    public String getIconPhrase() {
        return IconPhrase;
    }

    @JsonSetter("IconPhrase")
    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    @JsonGetter("HasPrecipitation")
    public boolean isHasPrecipitation() {
        return HasPrecipitation;
    }

    @JsonSetter("HasPrecipitation")
    public void setHasPrecipitation(boolean hasPrecipitation) {
        HasPrecipitation = hasPrecipitation;
    }

    @JsonGetter("PrecipitationType")
    public String getPrecipitationType() {
        return PrecipitationType;
    }

    @JsonSetter("PrecipitationType")
    public void setPrecipitationType(String precipitationType) {
        PrecipitationType = precipitationType;
    }

    @JsonGetter("PrecipitationIntensity")
    public String getPrecipitationIntensity() {
        return PrecipitationIntensity;
    }

    @JsonSetter("PrecipitationIntensity")
    public void setPrecipitationIntensity(String precipitationIntensity) {
        PrecipitationIntensity = precipitationIntensity;
    }
}
