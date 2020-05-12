package com.example.som;

import java.io.Serializable;

public class AudioData implements Serializable {
    private String name_ENG;
    private String name_KOR;
    private String simple_KOR;
    private String simple_ENG;
    private String simple_CHI;
    private String simple_JAP;
    private String detail_KOR;
    private String detail_ENG;
    private String detail_CHI;
    private String detail_JAP;


    public String getName_KOR() {
        return name_KOR;
    }

    public String getName_ENG() {
        return name_ENG;
    }

    public String getSimple_KOR() {
        return simple_KOR;
    }

    public String getSimple_ENG() { return simple_ENG; }

    public String getSimple_CHI() { return simple_CHI; }

    public String getSimple_JAP() { return simple_JAP; }

    public String getDetail_KOR() { return detail_KOR; }

    public String getDetail_ENG() { return detail_ENG; }

    public String getDetail_CHI() { return detail_CHI; }

    public String getDetail_JAP() { return detail_JAP; }


    public void setName_KOR(String name_KOR) { this.name_KOR = name_KOR; }

    public void setName_ENG(String name_ENG) { this.name_ENG = name_ENG; }

    public void setSimple_KOR(String simple_KOR) { this.simple_KOR = simple_KOR; }

    public void setSimple_ENG(String simple_ENG) { this.simple_ENG = simple_ENG; }

    public void setSimple_CHI(String simple_CHI) { this.simple_CHI = simple_CHI; }

    public void setSimple_JAP(String simple_JAP) { this.simple_JAP = simple_JAP; }

    public void setDetail_KOR(String detail_KOR) { this.detail_KOR = detail_KOR; }

    public void setDetail_ENG(String detail_ENG) { this.detail_ENG = detail_ENG; }

    public void setDetail_CHI(String detail_CHI) { this.detail_CHI = detail_CHI; }

    public void setDetail_JAP(String detail_JAP) { this.detail_JAP = detail_JAP; }

}
