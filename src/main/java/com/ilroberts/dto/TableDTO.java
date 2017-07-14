package com.ilroberts.dto;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "Table")
public class TableDTO implements Serializable {

    @XmlElement(name = "Country")
    private String country;

    @XmlElement(name = "City")
    private String city;

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry(){
        return country;
    }

    public String getCity() {
        return city;
    }
}
