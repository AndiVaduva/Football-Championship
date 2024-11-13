package service;

import java.util.Collections;
import java.util.List;

import model.Campionat;
import model.Echipa;
import model.Jucator;


public class CampionatService {
	private Campionat campionat;
	
	public CampionatService(Campionat campionat) {
        this.campionat = campionat;
    }
	
	public void simuleazaEtapa(Campionat campionat) {
	    // Verificăm dacă avem un număr suficient de echipe (par și cel puțin 2)
	    if (campionat.getEchipe().size() < 2) {
	        System.out.println("Nu exista suficiente echipe pentru a simula o etapa.");
	        return;
	    }

	    List<Echipa> echipe = campionat.getEchipe();

	    // Verificăm dacă numărul de echipe este impar
	    if (echipe.size() % 2 != 0) {
	        System.out.println("Numărul de echipe este impar. O echipă va sta această etapa.");
	        return;
	    }

	    // Amestecăm lista de echipe pentru a genera perechi aleator
	    Collections.shuffle(echipe);

	    // Simulăm meciurile pentru etapă
	    for (int i = 0; i < echipe.size(); i += 2) {
	        Echipa echipa1 = echipe.get(i);
	        Echipa echipa2 = echipe.get(i + 1);

	        // Generăm aleator numărul de goluri pentru fiecare echipă
	        int goluriEchipa1 = (int) (Math.random() * 5);
	        int goluriEchipa2 = (int) (Math.random() * 5);

	        // Actualizăm statisticile echipelor
	        echipa1.adaugaGoluriInscrise(goluriEchipa1);
	        echipa1.adaugaGoluriPrimite(goluriEchipa2);
	        echipa2.adaugaGoluriInscrise(goluriEchipa2);
	        echipa2.adaugaGoluriPrimite(goluriEchipa1);

	        // Afișăm rezultatul meciului
	        System.out.println("Meci: " + echipa1.getNume() + " vs " + echipa2.getNume());
	        System.out.println(echipa1.getNume() + " " + goluriEchipa1 + " : " + goluriEchipa2 + " " + echipa2.getNume());

	        // Determinăm câștigătorul
	        if (goluriEchipa1 > goluriEchipa2) {
	            echipa1.adaugaVictorie();
	            echipa2.adaugaInfrangere();
	            System.out.println("Echipa castigatoare: " + echipa1.getNume() + "\n");
	        } else if (goluriEchipa1 < goluriEchipa2) {
	            echipa2.adaugaVictorie();
	            echipa1.adaugaInfrangere();
	            System.out.println("Echipa castigatoare: " + echipa2.getNume() + "\n");
	        } else {
	            echipa1.adaugaEgalitate();
	            echipa2.adaugaEgalitate();
	            System.out.println("Meciul s-a terminat la egalitate.\n");
	        }
	    }

	    System.out.println("Etapa s-a încheiat.\n");
	}



    public void afiseazaClasament() {
        campionat.afiseazaClasament();
    }
    
    private Echipa cautaEchipa(String numeEchipa) {
        for (Echipa echipa : campionat.getEchipe()) {
            if (echipa.getNume().equals(numeEchipa)) {
                return echipa;
            }
        }
        return null;
    }
    
    public void adaugaJucator(String numeEchipa, String numeJucator, double valoare) {
        Echipa echipa = cautaEchipa(numeEchipa);
        if (echipa != null) {
            Jucator jucator = new Jucator(numeJucator, valoare);
            echipa.adaugaJucator(jucator);
            System.out.println("Jucatorul " + numeJucator + " a fost adaugat în echipa " + numeEchipa + ".");
        } else {
            System.out.println("Echipa " + numeEchipa + " nu a fost gasita.");
        }
    }
    
    public void stergeJucator(String numeEchipa, String numeJucator) {
        Echipa echipa = cautaEchipa(numeEchipa);
        if (echipa != null) {
            boolean sters = echipa.stergeJucator(numeJucator);
            if (sters) {
                System.out.println("Jucatorul " + numeJucator + " a fost sters din echipa " + numeEchipa + ".");
            } else {
                System.out.println("Jucatorul " + numeJucator + " nu a fost gasit în echipa " + numeEchipa + ".");
            }
        } else {
            System.out.println("Echipa " + numeEchipa + " nu a fost gasita.");
        }
    }
    
    public void schimbaValoareJucator(String numeEchipa, String numeJucator, double nouaValoare) {
        Echipa echipa = cautaEchipa(numeEchipa);
        if (echipa != null) {
            boolean actualizat = echipa.actualizeazaValoareJucator(numeJucator, nouaValoare);
            if (actualizat) {
                System.out.println("Valoarea jucatorului " + numeJucator + " a fost actualizata la " + nouaValoare + ".");
            } else {
                System.out.println("Jucătorul " + numeJucator + " nu a fost găsit în echipa " + numeEchipa + ".");
            }
        } else {
            System.out.println("Echipa " + numeEchipa + " nu a fost găsită.");
        }
    }


    


    
}


