package com.example.som;

import java.io.Serializable;

public class WifiData implements Serializable  {

    private String latitude, longitude;

    public WifiData(){}

    public WifiData(String latitude, String longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLongitude() { return this.longitude; }

    public String getLatitude() { return this.latitude; }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public void setLongitude(String longitude) { this.longitude = longitude; }

}
