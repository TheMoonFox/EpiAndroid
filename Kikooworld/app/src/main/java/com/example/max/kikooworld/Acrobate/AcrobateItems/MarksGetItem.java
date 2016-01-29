package com.example.max.kikooworld.Acrobate.AcrobateItems;

/**
 * Created by Fox on 29/01/2016.
 */

public class MarksGetItem {
    private String scholaryear;
    private String codemodule;
    private String titlemodule;
    private String codeinstance;
    private String codeacti;
    private String title;
    private String date;
    private String correcteur;
    private String finalNote;
    private String comment;

    public MarksGetItem(String scholaryear, String codemodule, String titlemodule, String codeinstance,
                        String codeacti, String title, String date,
                        String correcteur, String finalNote, String comment)
    {
        this.scholaryear = scholaryear;
        this.codemodule = codemodule;
        this.titlemodule = titlemodule;
        this.codeinstance = codeinstance;
        this.codeacti = codeacti;
        this.title = title;
        this.date = date;
        this.correcteur = correcteur;
        this.finalNote = finalNote;
        this.comment = comment;
    }

    public String getScholaryear() { return scholaryear; }
    public String getCodemodule() { return codemodule; }
    public String getTitlemodule() { return titlemodule; }
    public String getCodeinstance() { return codeinstance; }
    public String getCodeacti() { return codeacti; }
    public String getTitle() { return title; }
    public String getDate() { return date; }
    public String getCorrecteur() { return correcteur; }
    public String getFinalNote() { return finalNote; }
    public String getComment() { return comment; }
}
