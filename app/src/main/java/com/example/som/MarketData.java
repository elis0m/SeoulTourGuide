package com.example.som;

import java.io.Serializable;

public class MarketData implements Serializable {
    private String name;
    private String city;
    private String gu;
    private String dong;
    private String site;


    public String getName() { return name; }

    public String getSite() { return site; }

    public String getCity() { return city; }

    public String getGu() { return gu; }

    public String getDong() { return dong; }


    public void setName(String name) { this.name = name; }

    public void setSite(String site) { this.site = site; }

    public void setCity(String city) { this.city = city; }

    public void setGu(String gu) { this.gu = gu; }

    public void setDong(String dong) { this.dong = dong; }
}
