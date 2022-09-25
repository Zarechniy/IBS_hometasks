package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Company {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phoneNumber")
    @Expose
    private String phoneNumber;
    @SerializedName("inn")
    @Expose
    private String inn;
    @SerializedName("founded")
    @Expose
    private String founded;
    @SerializedName("securities")
    @Expose
    private List<Security> securities = new ArrayList<Security>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Company() {
    }

    /**
     * 
     * @param address
     * @param phoneNumber
     * @param name
     * @param inn
     * @param founded
     * @param id
     * @param securities
     */
    public Company(Integer id, String name, String address, String phoneNumber, String inn, String founded, List<Security> securities) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.inn = inn;
        this.founded = founded;
        this.securities = securities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFounded() {
//        SimpleDateFormat format = new SimpleDateFormat();
//        format.applyPattern("dd.MM.yyyy");
//        Date founded = format.parse(this.founded);
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Company.class.getName()).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("phoneNumber");
        sb.append('=');
        sb.append(((this.phoneNumber == null)?"<null>":this.phoneNumber));
        sb.append(',');
        sb.append("inn");
        sb.append('=');
        sb.append(((this.inn == null)?"<null>":this.inn));
        sb.append(',');
        sb.append("founded");
        sb.append('=');
        sb.append(((this.founded == null)?"<null>":this.founded));
        sb.append(',');
        sb.append("securities");
        sb.append('=');
        sb.append(((this.securities == null)?"<null>":this.securities));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.phoneNumber == null)? 0 :this.phoneNumber.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.inn == null)? 0 :this.inn.hashCode()));
        result = ((result* 31)+((this.founded == null)? 0 :this.founded.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.securities == null)? 0 :this.securities.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Company) == false) {
            return false;
        }
        Company rhs = ((Company) other);
        return ((((((((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address)))&&((this.phoneNumber == rhs.phoneNumber)||((this.phoneNumber!= null)&&this.phoneNumber.equals(rhs.phoneNumber))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.inn == rhs.inn)||((this.inn!= null)&&this.inn.equals(rhs.inn))))&&((this.founded == rhs.founded)||((this.founded!= null)&&this.founded.equals(rhs.founded))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.securities == rhs.securities)||((this.securities!= null)&&this.securities.equals(rhs.securities))));
    }

    public void getNameAndFoundationDate() {
        System.out.println(this.name + " - Дата основания " + this.founded);
    }

}
