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
    private int numarPuncte;

    public Echipa(String nume, String antrenor) {
        this.nume = nume;
        this.antrenor = antrenor;
        this.jucatori = new ArrayList<>();
        this.numarJocuri = 0;
        this.numarVictori = 0;
        this.numarInfrangeri = 0;
        this.goluriPrimite = 0;
        this.goluriInscrise = 0;
        this.numarPuncte = 0; 
    }

    public void adaugaJucator(Jucator jucator) {
        jucatori.add(jucator);
    }

    public void stergeJucator(Jucator jucator) {
        jucatori.remove(jucator);
    }

    public boolean actualizeazaValoareJucator(String numeJucator, double nouaValoare) {
        for (Jucator j : jucatori) {
            if (j.getNume().equals(numeJucator)) {
                j.setValoare(nouaValoare);
                System.out.println("Valoarea jucatorului " + numeJucator + " a fost actualizată la " + nouaValoare + ".");
                return true;
            }
        }
        return false;
    }

    public int getPuncte() {
        return numarPuncte; 
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
    
    public void adaugaVictorie() {
        numarVictori++;
        numarJocuri++;
        numarPuncte+=3;
    }
    
    public void adaugaEgalitate() {
    	numarJocuri++;
    	numarPuncte++;
    }

    public void adaugaInfrangere() {
        numarInfrangeri++;
        numarJocuri++;
    }

    public int getTotalGoluri() {
        return goluriInscrise - goluriPrimite;
    }

	public void adaugaGoluriInscrise(int goluriInscrise) {
		this.goluriInscrise+=goluriInscrise;
		
	}

	public void adaugaGoluriPrimite(int goluriPrimite) {
		this.goluriPrimite+=goluriPrimite;
		
	}

	public boolean stergeJucator(String numeJucator) {
	    for (Jucator j : jucatori) {
	        if (j.getNume().equals(numeJucator)) {
	            jucatori.remove(j);
	            return true;
	        }
	    }
	    return false;
	}

	
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Echipa: ").append(nume).append("\n");
	    sb.append("Antrenor: ").append(antrenor).append("\n");
	    sb.append("Numar de jocuri: ").append(numarJocuri).append("\n");
	    sb.append("Victorii: ").append(numarVictori).append("\n");
	    sb.append("Infrangeri: ").append(numarInfrangeri).append("\n");
	    sb.append("Goluri inscrise: ").append(goluriInscrise).append("\n");
	    sb.append("Goluri primite: ").append(goluriPrimite).append("\n");
	    sb.append("Puncte: ").append(numarPuncte).append("\n");
	    sb.append("Jucatori:\n");

	    for (Jucator jucator : jucatori) {
	        sb.append("  - ").append(jucator.toString()).append("\n");
	    }

	    return sb.toString();
	}



}
