package com.aliomercik.hesapkitap.model;

public class Workermodel {
    private String name;
    private int wage;
    private long date;

    public Workermodel(){

    }

    public Workermodel(String name, int wage, long date) {
        this.name = name;
        this.wage = wage;
        this.date = date;
    }

    public String getName() {return name;}

    public void setName(String name) { this.name = name;}

    public int getWage() { return wage; }

    public void setWage(int wage) { this.wage = wage;}

    public long getDate() { return date;}

    public void setDate(long date) { this.date = date;}
}
