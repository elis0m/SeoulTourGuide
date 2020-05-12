package com.example.som;

import java.io.Serializable;

public class AssetData implements Serializable {
    private String name;
    private String city;
    private String gu;
    private String dong;
    private String longitude;
    private String latitude;
    private String specified;
    private String release;


    public String getName() {
        return name;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getCity() {
        return city;
    }

    public String getGu() { return gu; }

    public String getDong() { return dong; }

    public String getSpecified() { return specified; }

    public String getRelease() { return release; }

    public void setName(String name) { this.name = name; }

    public void setLongitude(String longitude) { this.longitude = longitude; }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public void setCity(String city) { this.city = city; }

    public void setGu(String gu) { this.gu = gu; }

    public void setDong(String dong) { this.dong = dong; }

    public void setSpecified(String specified) { this.specified = specified; }

    public void setRelease(String release) { this.release = release; }


}
