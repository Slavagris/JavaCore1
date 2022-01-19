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

public class Headline {
    private String EffectiveDate;
    private float EffectiveEpochDate;
    private float Severity;
    private String Text;
    private String Category;
    private String EndDate;
    private float EndEpochDate;
    private String MobileLink;
    private String Link;

    public Headline() {
    }

    @Override
    public String toString() {
        return "Headline{" +
                "EffectiveDate='" + EffectiveDate + '\'' +
                ", EffectiveEpochDate=" + EffectiveEpochDate +
                ", Severity=" + Severity +
                ", Text='" + Text + '\'' +
                ", Category='" + Category + '\'' +
                ", EndDate='" + EndDate + '\'' +
                ", EndEpochDate=" + EndEpochDate +
                ", MobileLink='" + MobileLink + '\'' +
                ", Link='" + Link + '\'' +
                '}';
    }

    @JsonGetter("EffectiveDate")
    public String getEffectiveDate() {
        return EffectiveDate;
    }

    @JsonSetter("EffectiveDate")
    public void setEffectiveDate(String effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    @JsonGetter("EffectiveEpochDate")
    public float getEffectiveEpochDate() {
        return EffectiveEpochDate;
    }

    @JsonSetter("EffectiveEpochDate")
    public void setEffectiveEpochDate(float effectiveEpochDate) {
        EffectiveEpochDate = effectiveEpochDate;
    }

    @JsonGetter("Severity")
    public float getSeverity() {
        return Severity;
    }

    @JsonSetter("Severity")
    public void setSeverity(float severity) {
        Severity = severity;
    }

    @JsonGetter("Text")
    public String getText() {
        return Text;
    }

    @JsonSetter("Text")
    public void setText(String text) {
        Text = text;
    }

    @JsonGetter("Category")
    public String getCategory() {
        return Category;
    }

    @JsonSetter("Category")
    public void setCategory(String category) {
        Category = category;
    }

    @JsonGetter("EndDate")
    public String getEndDate() {
        return EndDate;
    }

    @JsonSetter("EndDate")
    public void setEndDate(String endDate) {
        EndDate = endDate;
    }

    @JsonGetter("EndEpochDate")
    public float getEndEpochDate() {
        return EndEpochDate;
    }

    @JsonSetter("EndEpochDate")
    public void setEndEpochDate(float endEpochDate) {
        EndEpochDate = endEpochDate;
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
