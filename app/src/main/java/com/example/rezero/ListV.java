package com.example.rezero;

public class ListV {
    //private int poster;
    private String designerName;
    private String introduce;

    public ListV(String designerName, String introduce){//(int poster, String movieName, String grade) - 원래 받앗던 인자값
        //this.poster = poster;
        this.designerName = designerName;
        this.introduce = introduce;
    }

    /*public int getPoster()
    {
        return this.poster;
    }*/

    public String getDesignerName()
    {
        return this.designerName;
    }

    public String getIntroduce()
    {
        return this.introduce;
    }
}