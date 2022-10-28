package fr.warzou.tp_3.salaire.info.impl;

import fr.warzou.tp_3.salaire.info.InfoSalaire;

public class InfoSalaireHoraire extends InfoSalaire {

    public static double HEUR_MAX = 35.0d;

    private final double tauxHoraire;
    private final double nombreHeur;
    private final double tauxHeurSup;

    public InfoSalaireHoraire(double tauxHoraire, double nombreHeur, double tauxHeurSup) {
        this.tauxHoraire = tauxHoraire;
        this.nombreHeur = nombreHeur;
        this.tauxHeurSup = tauxHeurSup;
    }

    @Override
    public double calcule() {
        if (this.nombreHeur <= HEUR_MAX)
            return this.tauxHoraire * nombreHeur;
        return HEUR_MAX * this.tauxHoraire + (this.nombreHeur - HEUR_MAX) * (this.tauxHoraire * (1.0 + this.tauxHeurSup));
    }

    public double getTauxHoraire() {
        return this.tauxHoraire;
    }

    public double getNombreHeur() {
        return this.nombreHeur;
    }

    public double getTauxHeurSup() {
        return this.tauxHeurSup;
    }
}
