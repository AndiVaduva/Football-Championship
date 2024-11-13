package model;

public class Jucator {
	 private String nume;
	 private double valoare;
	 private int numarJocuri;
	 private int numarVictorii;
	 private int numarInfrangeri;
	 private int goluriPrimite;
	 private int goluriInscrise;
	 
	    public Jucator(String nume, double valoare) {
	        this.nume = nume;
	        this.valoare = valoare;
	        this.numarJocuri = 0;
	        this.numarVictorii = 0;
	        this.numarInfrangeri = 0;
	        this.goluriPrimite = 0;
	        this.goluriInscrise = 0;
	    }	
	    public String getNume() {
	        return nume;
	    }

	    public double getValoare() {
	        return valoare;
	    }

	    public void setValoare(double valoare) {
	        this.valoare = valoare;
	    }

	    public void adaugaJoc() {
	        numarJocuri++;
	    }

	    public void adaugaVictorie() {
	        numarVictorii++;
	    }

	    public void adaugaInfrangere() {
	        numarInfrangeri++;
	    }

	    public void adaugaGolInscris() {
	        goluriInscrise++;
	    }

	    public void adaugaGolPrimit() {
	        goluriPrimite++;
	    }

	    
	    public String toString() {
	        return nume + " - Valoare: " + valoare;
	    }
	    
}
