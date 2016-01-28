package com.example.max.kikooworld.Acrobate.AcrobateItems;

/**
 * Created by Fox on 28/01/2016.
 */

public class ProjectsGetItem {
    private String codemodule;
    private String project;
    private String end_acti;
    private String acti_title;
    private String title_module;
    private String begin_acti;
    private String scolaryear;
    private String code_location;
    private String type_acti_code;
    private String codeacti;
    private String registered;
    private String codeinstance;
    private String type_acti;


    public ProjectsGetItem(String codemodule, String project, String end_acti,
                           String acti_title, String title_module, String begin_acti,
                           String scolaryear, String code_location, String type_acti_code,
                           String codeacti, String registered, String codeinstance, String type_acti)
    {
        this.codemodule = codemodule;
        this.project = project;
        this.end_acti = end_acti;
        this.acti_title = acti_title;
        this.title_module = title_module;
        this.begin_acti = begin_acti;
        this.scolaryear = scolaryear;
        this.code_location = code_location;
        this.type_acti_code = type_acti_code;
        this.codeacti = codeacti;
        this.codeacti = registered;
        this.codeinstance = codeinstance;
        this.type_acti = type_acti;
    }

    public String getCodeModule(){ return this.codemodule; }
    public String getProject() { return this.project; }
    public String getEnd_acti() { return this.end_acti; }
    public String getActi_title() { return this.acti_title; }
    public String getTitle_module() { return this.title_module; }
    public String getBegin_acti() { return this.begin_acti; }
    public String getCode_location() { return this.code_location; }
    public String getType_acti_code() { return this.type_acti_code; }
    public String getCodeacti() { return this.codeacti; }
    public String getRegistered() { return this.registered; }
    public String getCodeinstance() { return this.codeinstance; }
    public String getType_acti() { return this.type_acti; }
    public String getScolaryear() { return this.scolaryear; }
}
