package fr.warzou.tp_3;

import fr.warzou.tp_3.salaire.Employe;
import fr.warzou.tp_3.salaire.info.impl.InfoSalaireCommercial;
import fr.warzou.tp_3.salaire.info.impl.InfoSalaireHoraire;

import java.util.Arrays;

public class TP_3 {

    public static void main(String[] args) {
        Employe[] employes = new Employe[3];
        employes[0] = new Employe(new InfoSalaireHoraire(20.0, 36.0, 0.3), "Jeremy");
        employes[1] = new Employe(new InfoSalaireHoraire(20.0, 38.0, 0.5), "Kevin");
        employes[2] = new Employe(new InfoSalaireCommercial(200, 3_764), "Jean-Marc");
        System.out.println(Arrays.toString(employes));
    }
}
