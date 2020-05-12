package com.example.som;

import java.io.Serializable;

public class SpotData implements Serializable {
    private String name;
    private String phone;
    private String site;
    private String fee1;
    private String fee2;
    private String fee3,longitude,latitude;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSite() {
        return site;
    }

    public String getFee1() {
        return fee1;
    }

    public String getFee2() {
        return fee2;
    }

    public String getFee3() {
        return fee3;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() { return longitude;}


    public void setName(String name) { this.name = name; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setSite(String site) { this.site = site; }

    public void setFee1(String fee1) { this.fee1 = fee1; }

    public void setFee2(String fee2) { this.fee2 = fee2; }

    public void setFee3(String fee3) { this.fee3 = fee3; }

    public void setLatitude(String latitude) { this.latitude = latitude; }

    public void setLongitude(String longitude) { this.longitude = longitude; }

}
