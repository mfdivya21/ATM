package com.mobiquity.ATM;

import org.springframework.stereotype.Component;

import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */

 class GeoLocation{
    public String lat;
    public String lng;
}

 class Address{
    public String street;
    public String housenumber;
    public String postalcode;
    public String city;
    public GeoLocation geoLocation;
}

 class Hour{
    public String hourFrom;
    public String hourTo;
}

 class OpeningHour{
    public int dayOfWeek;
    public List<Hour> hours;
}

public class AtmModel{
    public Address address;
    public int distance;
    public List<OpeningHour> openingHours;
    public String functionality;
    public String type;
}

