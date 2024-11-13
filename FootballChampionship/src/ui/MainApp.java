package ui;

import model.Campionat;
import model.Echipa;
import model.Jucator;
import service.CampionatService;

public class MainApp {
	public static void main(String[] args) {
        Campionat campionat = new Campionat("Liga 1", 10, 5);
        CampionatService service = new CampionatService(campionat);

        Echipa echipa1 = new Echipa("FCSB", "Charalambous");
        Echipa echipa2 = new Echipa("Dinamo", "Kopic");
        Echipa echipa3 = new Echipa("Universitatea Craiova","Galca");
        Echipa echipa4 = new Echipa("Rapid","Sumudica");
        Echipa echipa5 = new Echipa("Farul","Hagi");
        Echipa echipa6 = new Echipa("U Cluj","Sabau");
        Echipa echipa7 = new Echipa("Petrolul","Alagic");
        Echipa echipa8 = new Echipa("CFR","Petrescu");
        Echipa echipa9 = new Echipa("Otelul","Munteanu");
        Echipa echipa10 = new Echipa("UTA","Rednic");
        
        Jucator jucator1 = new Jucator("Alex Mitrita",9.5);
        Jucator jucator2 = new Jucator("Denis Alibec",9.3);
        Jucator jucator3 = new Jucator("Elvir Koljic",8);
        
        echipa3.adaugaJucator(jucator1);
        echipa3.adaugaJucator(jucator3);
        echipa3.adaugaJucator(jucator2);
        
        System.out.println(echipa3);
        
        echipa3.actualizeazaValoareJucator("Elvir Koljic", 9);
        echipa3.stergeJucator(jucator2);
        
        

        campionat.adaugaEchipa(echipa1);
        campionat.adaugaEchipa(echipa2);
        campionat.adaugaEchipa(echipa3);
        campionat.adaugaEchipa(echipa4);
        campionat.adaugaEchipa(echipa5);
        campionat.adaugaEchipa(echipa6);
        campionat.adaugaEchipa(echipa7);
        campionat.adaugaEchipa(echipa8);
        campionat.adaugaEchipa(echipa9);
        campionat.adaugaEchipa(echipa10);

		
		service.simuleazaEtapa(campionat);
		service.afiseazaClasament();
		System.out.println();
		
		System.out.println(echipa3);
		 
    }
}
