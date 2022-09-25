package model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Shares {

    @SerializedName("companies")
    @Expose
    private List<Company> companies = new ArrayList<Company>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Shares() {
    }

    /**
     * 
     * @param companies
     */
    public Shares(List<Company> companies) {
        super();
        this.companies = companies;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Shares.class.getName()).append('[');
        sb.append("companies");
        sb.append('=');
        sb.append(((this.companies == null)?"<null>":this.companies));
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
        result = ((result* 31)+((this.companies == null)? 0 :this.companies.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Shares) == false) {
            return false;
        }
        Shares rhs = ((Shares) other);
        return ((this.companies == rhs.companies)||((this.companies!= null)&&this.companies.equals(rhs.companies)));
    }


}
