package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Security {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("currency")
    @Expose
    private List<String> currency = new ArrayList<String>();
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("date")
    @Expose
    private String date;

    /**
     * No args constructor for use in serialization
     */
    public Security() {
    }

    /**
     * @param date
     * @param code
     * @param name
     * @param currency
     */
    public Security(String name, List<String> currency, String code, String date) {
        super();
        this.name = name;
        this.currency = currency;
        this.code = code;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCurrency() {
        return currency;
    }

    public void setCurrency(List<String> currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Security.class.getName()).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("currency");
        sb.append('=');
        sb.append(((this.currency == null) ? "<null>" : this.currency));
        sb.append(',');
        sb.append("code");
        sb.append('=');
        sb.append(((this.code == null) ? "<null>" : this.code));
        sb.append(',');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null) ? "<null>" : this.date));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.date == null) ? 0 : this.date.hashCode()));
        result = ((result * 31) + ((this.currency == null) ? 0 : this.currency.hashCode()));
        result = ((result * 31) + ((this.code == null) ? 0 : this.code.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Security) == false) {
            return false;
        }
        Security rhs = ((Security) other);
        return (((((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name))) && ((this.date == rhs.date) || ((this.date != null) && this.date.equals(rhs.date)))) && ((this.currency == rhs.currency) || ((this.currency != null) && this.currency.equals(rhs.currency)))) && ((this.code == rhs.code) || ((this.code != null) && this.code.equals(rhs.code))));
    }

    public String expiredSecuritiesToList() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        String date = getDate();
        Date currentDate = new Date();

        String expiredCode = null;
        int result = format.parse(date.toString()).compareTo(currentDate);
        if (result < 0) {
            expiredCode = getCode();
        }
        return expiredCode;
    }

    public void expiredSecuritiesPrintInfo() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        String date = getDate();
        Date currentDate = new Date();

        int result = format.parse(date.toString()).compareTo(currentDate);
        if (result < 0) {
            System.out.println("Ценная бумага просрочена :" + "\n" +
                    "код " + getCode() + "\n" +
                    "дата истечения " + getDate() + "\n" +
                    "название организации: " + getName()
            );
        }
    }
}


