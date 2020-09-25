package com.aliomercik.hesapkitap.model;

import java.util.Objects;

public class UrunModel {
    private int id;
    private int kasaAdedi;
    private double kilogram;
    private float kilogramFiyat;

    public UrunModel() {
    }


    public Double getTutar() {
        return this.kilogram * this.kilogramFiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKasaAdedi() {
        return kasaAdedi;
    }

    public void setKasaAdedi(int kasaAdedi) {
        this.kasaAdedi = kasaAdedi;
    }

    public double getKilogram() {
        return kilogram;
    }

    public void setKilogram(double kilogram) {
        this.kilogram = kilogram;
    }

    public float getKilogramFiyat() {
        return kilogramFiyat;
    }

    public void setKilogramFiyat(float kilogramFiyat) {
        this.kilogramFiyat = kilogramFiyat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
