package com.example.som;

import java.io.Serializable;

public class CultureData implements Serializable {

    private String name;
    private String date;
    private String address;
    private String target,fee,cast,information,etc;
    private String website;
    private String image;

    public String getName() { return name; }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getTarget() {
        return target;
    }

    public String getFee() {
        return fee;
    }

    public String getCast() {
        return cast;
    }

    public String getInformation() {
        return information;
    }

    public String getEtc() {
        return etc;
    }

    public String getWebsite() {
        return website;
    }

    public String getImage() {
        return image;
    }

    public void setName(String name) { this.name = name; }

    public void setDate(String date) { this.date = date; }

    public void setAddress(String address) { this.address = address; }

    public void setTarget(String target) { this.target = target; }

    public void setFee(String fee) { this.fee = fee; }

    public void setCast(String cast) { this.cast = cast; }

    public void setInformation(String information) { this.information = information; }

    public void setEtc(String etc) { this.etc = etc; }

    public void setWebsite(String website) { this.website = website; }

    public void setImage(String image) { this.image = image; }
}
