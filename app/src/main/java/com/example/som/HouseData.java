package com.example.som;

import java.io.Serializable;

public class HouseData implements Serializable {
    private String name;
    private String city;
    private String gu;
    private String dong;
    private String site;
    private String phone;
    private String hours;


    public String getName() {
        return name;
    }

    public String getSite() {
        return site;
    }

    public String getCity() {
        return city;
    }

    public String getGu() { return gu; }

    public String getDong() { return dong; }

    public String getPhone() { return phone; }

    public String getHours() { return hours; }

    public void setName(String name) { this.name = name; }

    public void setSite(String site) { this.site = site; }

    public void setCity(String city) { this.city = city; }

    public void setGu(String gu) { this.gu = gu; }

    public void setDong(String dong) { this.dong = dong; }

    public void setPhone(String phone) { this.phone = phone; }

    public void setHours(String hours) { this.hours = hours; }


}
