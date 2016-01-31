package com.example.max.kikooworld.Acrobate.AcrobateItems;

/**
 * Created by Max on 31/01/2016.
 */
public class ModulesGetItem {
    private String semester;
    private String begin;
    private String end;
    private String end_register;
    private String scolaryear;
    private String code;
    private String codeinstance;
    private String instance_location;
    private String credits;
    private String status;
    private String active_promo;
    private String open;
    private String title;

    public ModulesGetItem(String semester, String begin, String end, String end_register,
                          String scolaryear, String code, String codeinstance, String instance_location,
                          String credits, String status, String active_promo, String open, String title)
    {
        this.semester = semester;
        this.begin = begin;
        this.end = end;
        this.end_register = end_register;
        this.scolaryear = scolaryear;
        this.code = code;
        this.codeinstance = codeinstance;
        this.instance_location = instance_location;
        this.credits = credits;
        this.status = status;
        this.active_promo = active_promo;
        this.open = open;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getSemester() {
        return semester;
    }

    public String getBegin() {
        return begin;
    }

    public String getEnd() {
        return end;
    }

    public String getEnd_register() {
        return end_register;
    }

    public String getScolaryear() {
        return scolaryear;
    }

    public String getCode() {
        return code;
    }

    public String getCodeinstance() {
        return codeinstance;
    }

    public String getInstance_location() {
        return instance_location;
    }

    public String getCredits() {
        return credits;
    }

    public String getStatus() {
        return status;
    }

    public String getActive_promo() {
        return active_promo;
    }

    public String getOpen() {
        return open;
    }
}
