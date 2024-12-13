package ui;

import model.Campionat;
import model.Echipa;
import service.CampionatService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp extends JFrame {
    private CampionatService service;
    private Campionat campionat;

    public MainApp(CampionatService service, Campionat campionat) {
        this.service = service;
        this.campionat = campionat;

        // Configurarea ferestrei
        setTitle("Management Campionat");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panou pentru butoane
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2));

        // Butoane pentru funcționalități
        JButton simulateButton = new JButton("Simulează Etapă");
        JButton showRankingButton = new JButton("Afișează Clasament");
        JButton addPlayerButton = new JButton("Adaugă Jucător");
        JButton removePlayerButton = new JButton("Șterge Jucător");
        JButton updatePlayerButton = new JButton("Actualizează Jucător");
        JButton addTeamButton = new JButton("Adaugă Echipa");

        // Adăugarea butoanelor la panou
        buttonPanel.add(simulateButton);
        buttonPanel.add(showRankingButton);
        buttonPanel.add(addPlayerButton);
        buttonPanel.add(removePlayerButton);
        buttonPanel.add(updatePlayerButton);
        buttonPanel.add(addTeamButton);

        // Adăugarea panoului în fereastră
        add(buttonPanel, BorderLayout.CENTER);

        // Zona de afișare a rezultatelor
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.SOUTH);

        // Listener pentru "Simulează Etapă"
        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                service.simuleazaEtapa(service.getCampionat());
                outputArea.append("Etapa a fost simulată.\n");
            }
        });

        // Listener pentru "Afișează Clasament"
        showRankingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.append("Clasamentul echipelor:\n");
                service.afiseazaClasament();
            }
        });

        // Listener pentru "Adaugă Jucător"
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String echipa = JOptionPane.showInputDialog("Introduceți numele echipei:");
                String jucator = JOptionPane.showInputDialog("Introduceți numele jucătorului:");
                double valoare = 0;

                // Verificare pentru valoare numerică validă
                try {
                    valoare = Double.parseDouble(JOptionPane.showInputDialog("Introduceți valoarea jucătorului:"));
                } catch (NumberFormatException ex) {
                    outputArea.append("Valoare invalidă introdusă.\n");
                    return;  // Ieși din metoda dacă valoarea nu este validă
                }

                Echipa echipaGasita = service.cautaEchipa(echipa);
                if (echipaGasita != null) {
                    echipaGasita.adaugaJucator(new model.Jucator(jucator, valoare));
                    outputArea.append("Jucătorul " + jucator + " a fost adăugat la echipa " + echipa + ".\n");
                } else {
                    outputArea.append("Echipa " + echipa + " nu a fost găsită.\n");
                }
            }
        });

        // Listener pentru "Șterge Jucător"
        removePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String echipa = JOptionPane.showInputDialog("Introduceți numele echipei:");
                String jucator = JOptionPane.showInputDialog("Introduceți numele jucătorului:");

                Echipa echipaGasita = service.cautaEchipa(echipa);
                if (echipaGasita != null) {
                    boolean sters = echipaGasita.stergeJucator(jucator);
                    if (sters) {
                        outputArea.append("Jucătorul " + jucator + " a fost șters din echipa " + echipa + ".\n");
                    } else {
                        outputArea.append("Jucătorul " + jucator + " nu a fost găsit în echipa " + echipa + ".\n");
                    }
                } else {
                    outputArea.append("Echipa " + echipa + " nu a fost găsită.\n");
                }
            }
        });

        // Listener pentru "Actualizează Jucător"
        updatePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String echipa = JOptionPane.showInputDialog("Introduceți numele echipei:");
                String jucator = JOptionPane.showInputDialog("Introduceți numele jucătorului:");
                double valoare = Double.parseDouble(JOptionPane.showInputDialog("Introduceți noua valoare a jucătorului:"));

                Echipa echipaGasita = service.cautaEchipa(echipa);
                if (echipaGasita != null) {
                    boolean actualizat = echipaGasita.actualizeazaValoareJucator(jucator, valoare);
                    if (actualizat) {
                        outputArea.append("Valoarea jucătorului " + jucator + " a fost actualizată la " + valoare + ".\n");
                    } else {
                        outputArea.append("Jucătorul " + jucator + " nu a fost găsit în echipa " + echipa + ".\n");
                    }
                } else {
                    outputArea.append("Echipa " + echipa + " nu a fost găsită.\n");
                }
            }
        });

        // Listener pentru "Adaugă Echipa"
        addTeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teamName = JOptionPane.showInputDialog("Introduceți numele echipei:");
                String coachName = JOptionPane.showInputDialog("Introduceți numele antrenorului:");

                if (teamName != null && coachName != null && !teamName.isEmpty() && !coachName.isEmpty()) {
                    Echipa newTeam = new Echipa(teamName, coachName);
                    campionat.adaugaEchipa(newTeam);
                    outputArea.append("Echipa " + teamName + " a fost adăugată în campionat.\n");
                } else {
                    outputArea.append("Vă rugăm să introduceți atât numele echipei cât și al antrenorului.\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        Campionat campionat = new Campionat("Liga 1", 10, 5);
        CampionatService service = new CampionatService(campionat);

        // Crearea interfeței grafice
        SwingUtilities.invokeLater(() -> {
            MainApp gui = new MainApp(service, campionat);
            gui.setVisible(true);
        });
    }
}
