package fr.warzou.tp_3.salaire.info.impl;

import fr.warzou.tp_3.salaire.info.InfoSalaire;

public class InfoSalaireCommercial extends InfoSalaire {

    public static double PERCENT = 0.1d;

    private final double fix;
    private final double chiffreAffaire;

    public InfoSalaireCommercial(double fix, double chiffreAffaire) {
        this.fix = fix;
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    public double calcule() {
        return this.fix + (this.chiffreAffaire * (1.0 + PERCENT));
    }

    public double getFix() {
        return this.fix;
    }

    public double getChiffreAffaire() {
        return this.chiffreAffaire;
    }
}
