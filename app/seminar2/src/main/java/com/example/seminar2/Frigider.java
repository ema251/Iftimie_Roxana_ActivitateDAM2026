package com.example.seminar2;
public class Frigider {
    private String marca;
    private int pret;
    private int capacitate;
    private String clasa;
    private String culoare;
    private boolean noFrost;
    private boolean smart;
    private float rating;

    public Frigider(String marca, int pret, int capacitate, String clasa, String culoare, boolean noFrost, boolean smart, float rating) {
        this.marca = marca;
        this.pret = pret;
        this.capacitate = capacitate;
        this.clasa = clasa;
        this.culoare = culoare;
        this.noFrost = noFrost;
        this.smart = smart;
        this.rating = rating;
    }

    public String getMarca() { return marca; }
    public int getPret() { return pret; }
    public int getCapacitate() { return capacitate; }
    public String getClasa() { return clasa; }
    public String getCuloare() { return culoare; }
    public boolean isNoFrost() { return noFrost; }
    public boolean isSmart() { return smart; }
    public float getRating() { return rating; }

    @Override
    public String toString() {
        return "Frigider " + marca + ", pret: " + pret + " lei, capacitate: " + capacitate + " l, clasa: " + clasa + ", culoare: " + culoare + ", no frost: " + noFrost + ", smart: " + smart + ", rating: " + rating;
    }
}