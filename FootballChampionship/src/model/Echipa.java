package model;

import java.util.ArrayList;
import java.util.List;

public class Echipa {
    private String nume;
    private String antrenor;
    private List<Jucator> jucatori;
    private int numarJocuri;
    private int numarVictori;
    private int numarInfrangeri;
    private int goluriPrimite;
    private int goluriInscrise;

    public Echipa(String nume, String antrenor) {
        this.nume = nume;
        this.antrenor = antrenor;
        this.jucatori = new ArrayList<>();
        this.numarJocuri = 0;
        this.numarVictori = 0;
        this.numarInfrangeri = 0;
        this.goluriPrimite = 0;
        this.goluriInscrise = 0;
    }

    public void adaugaJucator(Jucator jucator) {
        jucatori.add(jucator);
    }

    public void stergeJucator(Jucator jucator) {
        jucatori.remove(jucator);
    }

    public void actualizeazaValoareJucator(String numeJucator, double nouaValoare) {
        for (Jucator j : jucatori) {
            if (j.getNume().equals(numeJucator)) {
                j.setValoare(nouaValoare);
                break;
            }
        }
    }

    public int getPuncte() {
        return numarVictori * 3; 
    }



    public String getNume() {
        return nume;
    }

    public int getNumarJocuri() {
        return numarJocuri;
    }

    public int getNumarVictori() {
        return numarVictori;
    }

    public int getNumarInfrangeri() {
        return numarInfrangeri;
    }

    public int getGoluriPrimite() {
        return goluriPrimite;
    }

    public int getGoluriInscrise() {
        return goluriInscrise;
    }

    public List<Jucator> getJucatori() {
        return jucatori;
    }
}
