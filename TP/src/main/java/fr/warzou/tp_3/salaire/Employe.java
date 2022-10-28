package fr.warzou.tp_3.salaire;

import fr.warzou.tp_3.salaire.info.InfoSalaire;

public class Employe {

    private InfoSalaire infoSalaire;
    private final String name;

    public Employe(InfoSalaire infoSalaire, String name) {
        this.infoSalaire = infoSalaire;
        this.name = name;
    }

    public double getSalaire() {
        return this.infoSalaire.calcule();
    }

    public InfoSalaire getInfoSalaire() {
        return this.infoSalaire;
    }

    public void setInfoSalaire(InfoSalaire infoSalaire) {
        this.infoSalaire = infoSalaire;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " gagne " + getSalaire();
    }
}
