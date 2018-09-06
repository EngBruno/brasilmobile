package com.bruno.brasil_mobile.model;

public class City {
    private int id;
    private int code;
    private String name;
    private String UF;

    public City(int id,int code,String name,String UF){
        this.id = id;
        this.code = code;
        this.name = name;
        this.UF = UF;
    }

    public String toString(){
        return "Nome: "+this.name +" UF: "+this.UF;
    }

}
