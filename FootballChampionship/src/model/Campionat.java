package model;

import java.util.ArrayList;
import java.util.List;

public class Campionat {
    private String numeCampionat;
    private List<Echipa> echipe;
    private int numarEtape;

    public Campionat(String numeCampionat, int numarEchipe, int numarEtape) {
        this.numeCampionat = numeCampionat;
        this.echipe = new ArrayList<>(numarEchipe);
        this.numarEtape = numarEtape;
    }

    public void adaugaEchipa(Echipa echipa) {
        echipe.add(echipa);
    }

    public void afiseazaClasament() {
        echipe.sort((e1, e2) -> Integer.compare(e2.getPuncte(), e1.getPuncte()));
        for (Echipa e : echipe) {
            System.out.println(e.getNume() + " - Puncte: " + e.getPuncte());
        }
    }

    // Metode pentru a verifica statisticile echipelor
    public void echipeCuGoluriPrimiteMaiMari(int numarGoluri) {
        for (Echipa e : echipe) {
            if (e.getGoluriPrimite() > numarGoluri) {
                System.out.println(e.getNume());
            }
        }
    }

    public void echipeCuGoluriInscriseMaiMari(int numarGoluri) {
        for (Echipa e : echipe) {
            if (e.getGoluriInscrise() > numarGoluri) {
                System.out.println(e.getNume());
            }
        }
    }

    public void echipeCuPuncteMaiMici(int numarPuncte) {
        for (Echipa e : echipe) {
            if (e.getPuncte() < numarPuncte) {
                System.out.println(e.getNume());
            }
        }
    }
}
